<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/assets/css/layui.css" media="all">
	<!-- ${pageContext.request.contextPath } -->
    <title>商品管理</title>
  </head>
  
  <body>

<blockquote class="layui-elem-quote layui-text">
  搜索商品名：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="searchReload" autocomplete="off">
  </div>
  <button id="searchReloadBtn" class="layui-btn" data-type="reload" lay-filter="sub">搜索</button>
<!--   <button id="searchReloadMBtn" class="layui-btn" data-type="reload">模糊搜索</button> -->
  <a class="layui-btn" data-type="reload" href="addGoods.jsp">添加</a>
<!--   <a class="layui-btn" data-type="reload">修改</a> -->
  <a id="delAllCheck" class="layui-btn" data-type="reload">删除</a>
</blockquote>

<table id="demo2" lay-filter="test" class="layui.hide"></table>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

  </body>
  <script src="${pageContext.request.contextPath }/backstage/assets/layui.js" charset="utf-8"></script>
<script>
layui.use(['jquery','table','layer','form','laypage'], function(){
	var table = layui.table;
	var layer = layui.layer;
	var $ = layui.jquery;
	
	
	  
	//	表格添加
	var tableIns=table.render({
	    elem: '#demo2'
	    ,id: 'goodsTable'
	    ,height: 420
	    ,url:'${pageContext.request.contextPath }/goodsList'	//获取服务器返回的json数据页面
// 	    ,method:"post"
	    ,page: true //开启分页
	    ,limit:10
	    ,even: true	//交叉颜色
// 	    ,toolbar: 'true' //开启工具栏，此处显示默认图标
// 	    ,defaultToolbar: ['filter', 'print', 'exports']
// 	    ,contentType: 'application/json;charset=utf-8'	//以json格式传递到后台
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,cols: [[
	    	{fixed:'left', type:'checkbox' }
	      ,{field:'id', width:50, title: 'ID', sort: true}
	      ,{field:'goodsName', width:120, title: '商品名'}
	      ,{field:'goodsPrice', width:120, title: '商品价格', sort: true}
	      ,{field:'goodsStock', width:120, title: '商品库存', sort: true}
	      ,{field:'goodsCity', title: '商品产地', width:120, sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
	      ,{field:'goodsSpecifications', title: '商品规格', width:120, sort: true}
	      ,{field:'goodsManufacturer', title: '商品生产厂家', width:'30%', minWidth:100}
	      ,{field:'goodsDate', title: '商品生产日期', width:150, sort: true,
	    	  templet:function(d){
	    		  //console.log(d.goodsDate);
	    		  return new Date(d.goodsDate).format('yyyy-MM-dd');
	    	  }
	      }
	      ,{field:'goodsImgpath', title: '商品图片路径', width:150}
	      ,{field:'goodsDescribe', title: '商品描述', width:150}
	      ,{
	    	  field: 'menuDisplay',
	    	    title: '是否显示',

	    	    unresize: true,
	    	    filter: "isShow",
	    	    sort: false,
	    	    width:100,
	    	    templet: function (d) {
	    	        if (d.menuDisplay == 'Y') {
	    	            return` <input type = "checkbox"
	    	            name = "menuDisplay"
	    	            value = "`+d.menuId+`"
	    	            lay - skin = "switch"
	    	            lay - text = "显示|隐藏"
	    	            lay - filter = "isShow" > `;
	    	        } else {
	    	            return` <input type = "checkbox"
	    	            name = "menuDisplay"
	    	            value = "`+d.menuId+`"
	    	            lay - skin = "switch"
	    	            lay - text = "显示|隐藏"
	    	            lay - filter = "isShow"
	    	            checked > `;
	    	        }
	    	    }
	      }
	      ,{fixed:'right', title: '操作', width:178,  align:'center', toolbar: '#barDemo'}
	    ]]
	  });
	
	//监听头工具栏事件
	  table.on('toolbar(test)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
	    switch(obj.event){
	      case 'add':
	        layer.msg('添加');
	      break;
	      case 'update':
	        if(data.length === 0){
	          layer.msg('请选择一行');
	        } else if(data.length > 1){
	          layer.msg('只能同时编辑一个');
	        } else {
	          layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
	        }
	      break;
	      case 'delete':
	        if(data.length === 0){
	          layer.msg('请选择一行');
	        } else {
	          layer.msg('删除');
	        }
	      break;
	    };
	  });
	
	//监听行工具事件
	  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		  console.log(obj);
	    var data = obj.data //获得当前行数据
	    ,layEvent = obj.event; //获得 lay-event 对应的值
	    if(layEvent === 'detail'){
	      layer.msg('查看操作');
	      parent.layer.open({
	    	  type: 2,
	    	  title: data.name,
	    	  closeBtn: 1,
	    	  btn: ['确定'],
	    	  area: ['1000px', '500px'],
	          content: "${pageContext.request.contextPath }/reception/Template1.html?id="+data.id+"",
	      });
// 	      window.location.href ="Detailid.jsp?id="+data.id+"";
	    } else if(layEvent === 'del'){	//删除
	      layer.confirm('确定要删除ID为 '+data.id+' 的记录吗？',{icon:3, title:'提示信息'}, function(index){
	        $.ajax({
                url: "${pageContext.request.contextPath }/delGoods",
                type: "GET",
//                 contentType: "application/json",	//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
                data:{"id":data.id},
                dataType: "json",	//期待返回的数据类型text, json
                success: function(res){
                	if(res.code==0){
                		//删除对应行（tr）的DOM结构
	    	        	obj.del(); 
	    	        	//关闭提示框
	    	    		layer.close(index);
	                    layer.msg(res.msg, {icon: 6});
                	}
                	else{
                		layer.close(index);
	                    layer.msg(res.msg, {icon: 5});
                	}
                	
                },
                error:function (res) {
                	parent.layer.msg("操作失败", {icon: 5});
                }

            });
	        //向服务端发送删除指令
	      });
	    } else if(layEvent === 'edit'){
	    	window.location.href ="editGoods.jsp?id="+data.id+"";
	      	layer.msg('编辑操作');
	    }
	  });
	
	  table.on('checkbox(test)', function(obj){
		  //console.log(obj.checked); //当前是否选中状态
		  //console.log(obj.data); //选中行的相关数据
		  //console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
		});
	  $("#delAllCheck").click(function(){
		  var arr=[];
		  var checkData = table.checkStatus("goodsTable");
		  console.log(checkData);
		  $.each(checkData.data, function(i, item){
			 arr.push(item.id); 
		  });
		  layer.confirm('确定要删除ID为 '+arr+' 的记录吗？',{icon:3, title:'提示信息'}, function(index){
		        $.ajax({
	                url: "${pageContext.request.contextPath }/delAllGoods",
	                type: "GET",
//	                 contentType: "application/json",	//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
	                data:{"ids":arr.toString()},
	                dataType: "json",	//期待返回的数据类型text, json
	                success: function(res){
	                	if(res.code==0){
		    	        	//关闭提示框
		    	    		layer.close(index);
		                    layer.msg(res.msg, {icon: 6});
		                    table.reload('goodsTable', {
		            			url:'${pageContext.request.contextPath }/goodsList'	    	  
		            	      });
	                	}
	                	else{
	                		layer.close(index);
		                    layer.msg(res.msg, {icon: 5});
	                	}
	                	
	                },
	                error:function (res) {
	                	parent.layer.msg("操作失败", {icon: 5});
	                }

	            });
		        //向服务端发送删除指令
		      });
	  })
	  
	  //查询操作
	  var active = {
	    reload: function(){
	      var searchReload = $('#searchReload');
	      
	      //执行重载
	      table.reload('goodsTable', {
			url:'${pageContext.request.contextPath }/searchGoodsData'	    	  
	        ,page: {
	          curr: 1 //重新从第 1 页开始
	        }
	        ,where: {
	            searchGoods: searchReload.val()
	        }
	      });
	    }
	  };
			  
	  $('#searchReloadBtn').on('click', function(){
		  var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
// 		  var searchReload = $('#searchReload');
	      
// 	      //执行重载
// 	      tableIns.reload({
// 			url:'searchItemData?id='+searchReload.val()+''
// 	      });
	  });
	  
// 	  var activeM = {
// 	    reload: function(){
// 	      var searchReload = $('#searchReload');
	      
// 	      //执行重载
// 	      table.reload('goodsTable', {
// 			url:'searchItemMData'	    	  
// 	        ,page: {
// 	          curr: 1 //重新从第 1 页开始
// 	        }
// 	        ,where: {
// 	            id: searchReload.val()
// 	        }
// 	      });
// 	    }
// 	  };

// 	  $('#searchReloadMBtn').on('click', function(){
// 		  var type = $(this).data('type');
//           activeM[type] ? activeM[type].call(this) : '';
// 	  });
Date.prototype.format = function(format)
  	{
	  	 var o = {
	  	 "M+" : this.getMonth()+1, //month
	  	 "d+" : this.getDate(),    //day
	  	 "h+" : this.getHours(),   //hour
	  	 "m+" : this.getMinutes(), //minute
	  	 "s+" : this.getSeconds(), //second
	  	 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	  	 "S" : this.getMilliseconds() //millisecond
	  	 }
	  	 if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
	  	 (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	  	 for(var k in o)if(new RegExp("("+ k +")").test(format))
	  	 format = format.replace(RegExp.$1,
	  	 RegExp.$1.length==1 ? o[k] :
	  	 ("00"+ o[k]).substr((""+ o[k]).length));
	  	 return format;
  	}
  	
});
</script>


</html>
