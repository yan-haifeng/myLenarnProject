<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/backstage/assets/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <script type="text/javascript">
	function PreviewImage(imgFile){
		var pattern=/(\.*.jpg$)|(\.*.png$)|(\.*.gif$)|(\.*.bmp$)/;
		if(!pattern.test(imgFile.value)){
			alert("系统只能上传图片格式的文件");
			imgFile.value="";
			imgFile.focus();
		}
		else {
			var path;
			if(document.all){
				imgFile.select();
				path = document.selection.createRange().text;
				document.getElementById("imgPreview").innerHTML="";
				document.getElementById("imgPreview").style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingmethod='scale',src=\""+path+"\")";
			} else {
				path=URL.createObjectURL(imgFile.files[0]);
				document.getElementById("imgPreview").innerHTML="<img width='300px' src='"+path+"'/>";
			}
		}
	}
  </script>
</head>
<body>
          
<blockquote class="layui-elem-quote layui-text">
  		<a class="layui-btn" href="goodsList.jsp">返回</a>
</blockquote>
              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改商品信息</legend>
</fieldset>
 
<form id="editGoodsForm" class="layui-form" action="" method="post" enctype="multipart/form-data" lay-filter="editForm">
  <input type="hidden" name="id" id="id">
  <div class="layui-form-item">
    <label class="layui-form-label">商品名称*</label>
    <div class="layui-input-block">
      <input id="goodsName" type="text" name="goodsName" lay-verify="required" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
  	<div class="layui-inline">
      <label class="layui-form-label">价格*</label>
      <div class="layui-input-inline">
        <input id="goodsPrice" type="tel" name="goodsPrice" lay-verify="required" autocomplete="off" placeholder="￥" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">库存*</label>
      <div class="layui-input-inline">
        <input id="goodsStock" type="tel" name="goodsStock" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
  	  <label class="layui-form-label">产地*</label>
      <div class="layui-input-block">
        <input id="goodsCity" type="text" name="goodsCity" lay-verify="required" placeholder="请输入产地" autocomplete="off" class="layui-input">
      </div>
  	</div>
    <div class="layui-inline">
      <label class="layui-form-label">商品规格</label>
      <div class="layui-input-inline">
        <input id="goodsSpecifications" type="text" name="goodsSpecifications" lay-verify="" placeholder="请输入商品规格" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">生产厂家*</label>
      <div class="layui-input-inline">
        <input id="goodsManufacturer" type="text" name="goodsManufacturer" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">生产日期</label>
      <div class="layui-input-inline">
        <input id="goodsDate" type="text" name="goodsDate" id="goodsDate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">商品图片</label>
    <div class="layui-input-inline">
  	  <div id="imgPreview">
		<img id="goodsImg" width='300px' alt="" src="">
	  </div>
	  <label><input id="file" class="" type="file" name="file" value="上传图片" onchange='PreviewImage(this)'/></label>
	</div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">商品描述</label>
    <div class="layui-input-block">
      <textarea id="goodsDescribe" name="goodsDescribe" placeholder="请输入商品描述" class="layui-textarea"></textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="sub">立即提交</button>
      <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 

          
<script src="<%=request.getContextPath() %>/backstage/assets/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate
  ,$ = layui.jquery;
  var id = ${param.id }
  //日期
  laydate.render({
    elem: '#pTime'
  });
 
  
  	
  	//页面一加载就发送ajax
  	$(function(){
  		$.ajax({
  			url:"${pageContext.request.contextPath }/editGoodsData",
  			type:"GET",
  			data:{"id":id},
  			dataType:"json",
  			success:function(res){
  				console.log(res);
  			  //表单初始赋值
  			  $('#goodsImg').attr('src','/img/'+res.data[0].goodsImgpath);
  			  $('#id').attr('value',id);
  			  $('#goodsName').attr('value',res.data[0].goodsName);
  			  $('#goodsPrice').attr('value',res.data[0].goodsPrice);
  			  $('#goodsStock').attr('value',res.data[0].goodsStock);
  			  $('#goodsCity').attr('value',res.data[0].goodsCity);
  			  $('#goodsSpecifications').attr('value',res.data[0].goodsSpecifications);
  			  $('#goodsManufacturer').attr('value',res.data[0].goodsManufacturer);
  			  $('#goodsDate').attr('value',new Date(res.data[0].goodsDate).format('yyyy-MM-dd'));
  			  $('#goodsDescribe').val(res.data[0].goodsDescribe);
  			  $('#file').attr('value',res.data[0].goodsImgpath);
  			  
  			}
  		})
  	})
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
  
  //监听提交
    form.on('submit(sub)', function(data){
  	  	console.log(JSON.stringify(data));//测试是否获取到表单数据，调试模式下在页面控制台查看
  	    layer.confirm(JSON.stringify(data.field), {title: '最终的提交信息',
  	    	yes:function(index){
//   	    		layer.msg('确定');	//弹出提示窗口
  	    		$.ajax({
  	    			url:"${pageContext.request.contextPath }/editGoods",
  	    			type:"POST",
  	    			data:new FormData($("#editGoodsForm")[0]),
  	    			dataType:'JSON',
  	    			cache: false,  
  	                processData: false,  
  	                contentType: false,
  	    			success:function(res){	//返回的json对象
  	    				if(res.code==0){
  					    	layer.msg("修改成功");
  					    	$("#reset").click();//调用重置按钮将表单数据清空
//   				    		parent.location.reload();	//刷新父级页面
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
  
});
</script>

</body>
</html>