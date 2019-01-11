<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/assets/css/layui.css" media="all">
<script src="${pageContext.request.contextPath }/backstage/assets/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/backstage/assets/jquery-1.11.3.min.js" charset="utf-8"></script>
<title>Insert title here</title>
<style type="text/css">
        .layui-table-cell{
            height: 38px;
        }
        .layui-input, .layui-select, .layui-textarea{
            border-width: 0px;
        }
</style>
</head>
<body>
	<form id="orderDataList" action="" method="">
		<a href="${pageContext.request.contextPath }/backstage/views/orderList.jsp" class="layui-btn">返回</a><button class="layui-btn" id="sub" lay-submit="" lay-filter="sub">提交</button>
        <div id="Gl_Table">
            <table class="layui-hide" id="dataTable" style="max-height: 500px; height: 500px;" lay-filter="demoT"></table>
        </div>
    </form>
<button id="btn-add1" class="layui-btn" >新增上一行</button>
<button id="btn-add2" class="layui-btn">新增下一行</button>


<script type="text/javascript">
var orderViewDataList=[];

var initTable;
layui.use(['table', 'form'], function(){
	var table = layui.table;
	var form = layui.form;
	
	//监听提交
	  form.on('submit(sub)', function(data){
		  	console.log(JSON.stringify(data));//测试是否获取到表单数据，调试模式下在页面控制台查看
		  	console.log($('#orderDataList').serialize());
		    layer.confirm(JSON.stringify(data.field), {title: '最终的提交信息',
		    	yes:function(index){
//	 	    		layer.msg('确定');	//弹出提示窗口
		    		$.ajax({
		    			url:"${pageContext.request.contextPath }/orderAdd",
		    			type:"POST",
		    			data:new FormData($("#orderDataList")[0]),
		    			dataType:'JSON',
		    			cache: false,  
		                processData: false,  
		                contentType: false,
		    			success:function(res){	//返回的json对象
		    				if(res.code==0){
						    	layer.msg("保存成功");
//	 				    		parent.location.reload();	//刷新父级页面
						    	layer.close(index);	//关闭弹窗
		                    }
		                    else{
		                    	layer.msg(res.msg);
		                    }
		    			},
		    			error:function(){
		    				parent.layer.msg("操作失败");
		    			}
		    		});
		    	}
		    });
		    return false;
		});
	
	$(function(){
		for(var i=0; i<10; i++){
			var data2={"id":"", "goodsName":"", "goodsPrice":"", "buyquantity":"", "totalprice":"", "name":"", "phone":"", "ordertime":1548222644000, "goodsId":"", "userId":""};
			orderViewDataList.push(data2);
		}
				table.render({
				    elem: '#dataTable'
				    ,id:'lDataTable'
				    ,height:400
				    //,type:'GET'
				    //,url:'${pageContext.request.contextPath }/orderViewList'
				    ,data:orderViewDataList
				    ,page: true
				    ,cellMinWidth: 80
				    ,cols: [[
				    	{fixed:'left', type:'checkbox' }
				      ,{field:'id', width:'100', title: '订单编号', sort: true
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="id" value=`+d.id+`>`;
				    	  }
				      }
				      ,{field:'goodsId', width:'100', title: '商品编号', sort: true
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="goodsId" value=`+d.goodsId+`>`;
				    	  }
				      }
				      ,{field:'goodsName', width:'20%', title: '商品名称'
				        ,templet:function(d){
				            return `<input type="text" class="layui-input" required lay-verify="required" name="goodsName" value=`+d.goodsName+`>`;
				        }
				      }
				      ,{field:'goodsPrice', width:'100', title: '商品价格', sort: true
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="goodsPrice" value=`+d.goodsPrice+`>`;
				    	  }
				      }
				      ,{field:'buyquantity', width:'100', title: '购买数量'
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="buyquantity" value=`+d.buyquantity+`>`;
				    	  }
				      }
// 				      ,{field:'totalprice', width: "120", title: '商品总价'
// 				    	  ,templet:function(d){
// 				    		  //console.log(d);
// 				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="totalprice" value=`+d.totalprice+`>`;
// 				    	  }
// 				      }
				      ,{field:'userId', width:"100", title: '用户编号', sort: true
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="userId" value=`+d.userId+`>`;
				    	  }
				      }
				      ,{field:'name', width:"100", title: '下单用户', sort: true
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="name" value=`+d.name+`>`;
				    	  }
				      }
				      ,{field:'ordertime', width:"150", title: '下单时间'
				    	  ,templet:function(d){
				    		  //console.log(d);
				    		  return `<input type="text" class="layui-input" required lay-verify="required" name="ordertime" value=`+new Date(d.ordertime).format('yyyy-MM-dd')+`>`;
				    	  }
				      }
				    ]]
				  });
			
	})
	
		
		
		
		// 新增上一行
		$("#btn-add1").off("click").on("click",function(){
		 	console.log(orderViewDataList);
			var data1={"":"已完成",报销人:"liyoubing1722",部门名称:"开发部门1221",名称:"出差调查",描述:"出差",创建时间:"2018-07-25",单据时间:"2018-07-05",总金额:"922"};
			var data2={"id":"", "goodsName":"", "goodsPrice":"", "buyquantity":"", "totalprice":"", "name":"", "phone":"", "ordertime":1548222644000, "goodsId":"", "userId":""};
			orderViewDataList.unshift(data2);
			 
			table.reload('lDataTable',{
			 
			data : orderViewDataList
		 
		});
		})
		 //新增下一行
		 $("#btn-add2").off("click").on("click",function(){
		     // BottonCommonMenthod();
		    // var oldData =  table.cache["Table"];
		          
	          var data1={"id":"", "goodsName":"", "goodsPrice":"", "buyquantity":"", "totalprice":"", "name":"", "phone":"", "ordertime":1548222644000, "goodsId":"", "userId":""};
	          var data2={审批状态:"",报销人:"",部门名称:"",名称:"",描述:"",创建时间:"",单据时间:"",总金额:""};
	          orderViewDataList.push(data1);
	          console.log(orderViewDataList);
	          table.reload('lDataTable',{
	              data : orderViewDataList
	          });
		 
		  });
	
});

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
	

	
	
	
</script>
</body>
</html>