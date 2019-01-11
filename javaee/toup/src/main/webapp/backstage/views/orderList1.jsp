<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/assets/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css" media="all">
<script src="${pageContext.request.contextPath }/backstage/assets/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/backstage/assets/jquery-1.11.3.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/backstage/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js" charset="utf-8"></script>

<title>Insert title here</title>
<style type="text/css">
        .layui-table-cell{
            height: 38px;
        }
        .layui-input, .layui-select, .layui-textarea{
            border-width: 0px;
        }
        table tr td{
        	width:200px;
        }
        .form-control{
        	border:0px;
        }
</style>
</head>
<body>
<div class="table-responsive" style="height:500px">
<form id="orderFormEdit" action="" method="">
	<a href="${pageContext.request.contextPath }/backstage/views/orderAdd1.jsp" class="layui-btn layui-btn-normal">添加订单</a><button id="sub"  class="layui-btn layui-btn-normal" lay-submit="" lay-filter="sub">保存修改</button>
	<div class="pre-scrollable " style="width:800;height:500px;overflow-x:auto;">
	<table class="table table-condensed table-hover" style="margin-bottom:2px;">
		<thead>
			<tr style="color:#666;background-color:#f2f2f2;">
				<th style="background-color:#f5f5f5;">订单编号</th>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>购买数量</th>
				<th>商品总价</th>
				<th>用户编号</th>
				<th>下单用户</th>
				<th>用户手机</th>
				<th>下单时间</th>
				<th></th>
			</tr>
		</thead>
	</table>
	<table class="table table-condensed table-hover "  >
		
		<tbody id="orderTBody">
			<tr>
				<td style='background-color:#f5f5f5'><input style='background-color:#f5f5f5' class="layui-input" type="text" name="id" value="1" readonly></td>
				<td><input class="layui-input" type="text" name="goodsId" value="0" readonly></td>
				<td>
					<select  name="goodsName" class="form-control">
						<option>请选择</option>
						<option>1</option>
  					</select>	
  				</td>
				<td><input class="layui-input" type="text" name="goodsPrice" value="0" readonly></td>
				<td><input class="layui-input" type="text" name="buyquantity" value="0"></td>
				<td><input class="layui-input" type="text" name="totalprice" value="0" readonly></td>
				<td><input class="layui-input" type="text" name="userId" value="1" readonly></td>
				<td>
					<select  name="name" class="form-control">
						<option>请选择</option>
						<option>1</option>
  					</select>	
  				</td>
				<td><input class="layui-input" type="text" name="phone" value="00000000000" readonly></td>
<!-- 				<td><input class="layui-input" type="text" name="ordertime" value="2019-1-9"></td> -->
				<td>
					<input type="text" class="layui-input" id="ordertime" name="ordertime" placeholder="yyyy-MM-dd">
				</td>
			</tr>
			
		</tbody>
	</table>
	</div>
</form>

<button id="addTrc" class="btn btn-warning">添加后菜单行</button>
<button id="paddTrc" class="btn btn-warning">添加前菜单行</button>
</div>

<script type="text/javascript">
	var count=10;
	layui.use('form', function(){
		var form=layui.form;
		$("#sub").click(function(){
			//监听提交
			  form.on('submit(sub)', function(data){
				  	console.log(JSON.stringify(data));//测试是否获取到表单数据，调试模式下在页面控制台查看
				  	console.log($('#orderFormEdit').serialize());
				    layer.confirm(JSON.stringify(data.field), {title: '最终的提交信息',
				    	yes:function(index){
//			 	    		layer.msg('确定');	//弹出提示窗口
				    		$.ajax({
				    			url:"${pageContext.request.contextPath }/orderEdit1",
				    			type:"POST",
				    			data:new FormData($("#orderFormEdit")[0]),
				    			dataType:'JSON',
				    			cache: false,  
				                processData: false,  
				                contentType: false,
				    			success:function(res){	//返回的json对象
				    				if(res.code==0){
								    	layer.msg("订单修改成功");
//			 				    		parent.location.reload();	//刷新父级页面
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
		})
	})
	
	
	function addOrderView(orderViewDatas,goodsDatas,userDatas){
		$.each(orderViewDatas, function(i, orderViewData){
			var trn=$("<tr></tr>");
			var tdId=$("<td style='background-color:#f5f5f5'><input style='background-color:#f5f5f5' class='layui-input' type='text' name='id' value='"+orderViewData.id+"' readonly></td>");
			var tdGoodsId=$("<td><input class='layui-input' type='text' name='goodsId' value='"+orderViewData.goodsId+"' readonly></td>");	
			var tdGoodsName=$("<td></td>");
			var selGoodsName=$("<select  name='goodsName' class='form-control'><option>请选择</option><option>1</option></select>");	
			var tdGoodsPrice=$("<td><input class='layui-input' type='text' name='goodsPrice' value='"+orderViewData.goodsPrice+"' readonly></td>");
			var tdBuyquantity=$("<td><input class='layui-input' type='text' name='buyquantity' value='"+orderViewData.buyquantity+"'></td>");
			var tdTotalprice=$("<td><input class='layui-input' type='text' name='totalprice' value='"+orderViewData.totalprice+"' readonly></td>");
			var tdUserId=$("<td><input class='layui-input' type='text' name='userId' value='"+orderViewData.userId+"' readonly></td>");
			var tdName=$("<td></td>");
			var selName=$("<select  name='name' class='form-control'><option>请选择</option><option>1</option></select>");			
			var tdPhone=$("<td><input class='layui-input' type='text' name='phone' value='"+orderViewData.phone+"' readonly></td>");			
			var tdOrdertime=$("<td><input type='text' class='layui-input' id='ordertime' name='ordertime' placeholder='yyyy-MM-dd' value='"+new Date(orderViewData.ordertime).format('yyyy-MM-dd')+"'></td>");
			
			//添加商品名下拉
			var resG = goodsDatas;
			$.each(resG, function(){
				if(orderViewData.goodsName==this.goodsName){
					selGoodsName.append($("<option></option>").text(this.goodsName).attr("selected",true));
				}
				else{
					selGoodsName.append($("<option></option>").text(this.goodsName));
				}
			})
			//添加用户名下拉
			var resU = userDatas;
			console.log(userInfo);
			$.each(resU, function(){
				if(orderViewData.name==this.name){
					selName.append($("<option></option>").text(this.name).attr("selected",true));
				}
				else{
					selName.append($("<option></option>").text(this.name));
				}
			})
			$("#orderTBody").append(trn.append(tdId)
					.append(tdGoodsId)
					.append(tdGoodsName.append(selGoodsName))
					.append(tdGoodsPrice)
					.append(tdBuyquantity)
					.append(tdTotalprice)
					.append(tdUserId)
					.append(tdName.append(selName))
					.append(tdPhone)
					.append(tdOrdertime));
			
		})
		//给下拉商品名绑定接听事件
		$("select[name='goodsName']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resG = goodsInfo.data;
			$.each(resG, function(i,item){
				if(item.goodsName==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(1).find("input").val(item.id);
					thi.parents("tr").find("td").eq(3).find("input").val(item.goodsPrice);
					return;
				}
			})
		})
		//给下拉用户名绑定接听事件
		$("select[name='name']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resU = userInfo.data;
			$.each(resU, function(i,item){
				if(item.username==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(6).find("input").val(item.id);
					thi.parents("tr").find("td").eq(8).find("input").val(item.phone);
					return;
				}
			})
		})
		//购买数量接听
		$("input[name='buyquantity']").on("blur",function(){
			var a = $(this).val();
			console.log(a);
			var v = $(this).parents("tr").find("td").eq(3).find("input").val();
			$(this).parents("tr").find("td").eq(5).find("input").val(a*v);
		});
		
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		//同时绑定多个
		  $("input[name='ordertime']").each(function(){
		    laydate.render({
		      elem: this
		      ,value: '2019-01-09'
		      //,trigger: 'click'
		    });
		  });
		});
		
	}
	
	$("#addTrc").click(function(){
		count=count+1;
		var trn=$("<tr></tr>");
		var tdId=$("<td style='background-color:#f5f5f5'><input style='background-color:#f5f5f5' class='layui-input' type='text' name='id' value='"+count+"' readonly></td>");
		var tdGoodsId=$("<td><input class='layui-input' type='text' name='goodsId' value='0' readonly></td>");	
		var tdGoodsName=$("<td></td>");
		var selGoodsName=$("<select  name='goodsName' class='form-control'><option>请选择</option><option>1</option></select>");	
		var tdGoodsPrice=$("<td><input class='layui-input' type='text' name='goodsPrice' value='0' readonly></td>");
		var tdBuyquantity=$("<td><input class='layui-input' type='text' name='buyquantity' value='0'></td>");
		var tdTotalprice=$("<td><input class='layui-input' type='text' name='totalprice' value='0' readonly></td>");
		var tdUserId=$("<td><input class='layui-input' type='text' name='userId' value='1' readonly></td>");
		var tdName=$("<td></td>");
		var selName=$("<select  name='name' class='form-control'><option>请选择</option><option>1</option></select>");			
		var tdPhone=$("<td><input class='layui-input' type='text' name='phone' value='00000000000' readonly></td>");			
		var tdOrdertime=$("<td><input type='text' class='layui-input' id='ordertime' name='ordertime' placeholder='yyyy-MM-dd'></td>");			
  						
  				
		$("#orderTBody").append(trn.append(tdId)
									.append(tdGoodsId)
									.append(tdGoodsName.append(selGoodsName))
									.append(tdGoodsPrice)
									.append(tdBuyquantity)
									.append(tdTotalprice)
									.append(tdUserId)
									.append(tdName.append(selName))
									.append(tdPhone)
									.append(tdOrdertime));
		
		//添加商品名下拉
		var resG = goodsInfo.data;
		$.each(resG, function(){
			selGoodsName.append($("<option></option>").text(this.goodsName));
		})
		//添加用户名下拉
		var resU = userInfo.data;
		console.log(userInfo);
		$.each(resU, function(){
			selName.append($("<option></option>").text(this.username));
		})
		//给下拉商品名绑定接听事件
		$("select[name='goodsName']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resG = goodsInfo.data;
			$.each(resG, function(i,item){
				if(item.goodsName==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(1).find("input").val(item.id);
					thi.parents("tr").find("td").eq(3).find("input").val(item.goodsPrice);
					return;
				}
			})
		})
		//给下拉用户名绑定接听事件
		$("select[name='name']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resU = userInfo.data;
			$.each(resU, function(i,item){
				if(item.username==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(6).find("input").val(item.id);
					thi.parents("tr").find("td").eq(8).find("input").val(item.phone);
					return;
				}
			})
		})
		//购买数量接听
		$("input[name='buyquantity']").on("blur",function(){
			var a = $(this).val();
			console.log(a);
			var v = $(this).parents("tr").find("td").eq(3).find("input").val();
			$(this).parents("tr").find("td").eq(5).find("input").val(a*v);
		});
		
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		//同时绑定多个
		  $("input[name='ordertime']").each(function(){
		    laydate.render({
		      elem: this
		      ,value: '2019-01-09'
		      //,trigger: 'click'
		    });
		  });
		});
	})
	
	
	$("#paddTrc").click(function(){
		count=count+1;
		var trn=$("<tr></tr>");
		var tdId=$("<td style='background-color:#f5f5f5'><input style='background-color:#f5f5f5' class='layui-input' type='text' name='id' value='"+count+"' readonly></td>");
		var tdGoodsId=$("<td><input class='layui-input' type='text' name='goodsId' value='0' readonly></td>");	
		var tdGoodsName=$("<td></td>");
		var selGoodsName=$("<select  name='goodsName' class='form-control'><option>请选择</option><option>1</option></select>");	
		var tdGoodsPrice=$("<td><input class='layui-input' type='text' name='goodsPrice' value='0' readonly></td>");
		var tdBuyquantity=$("<td><input class='layui-input' type='text' name='buyquantity' value='0'></td>");
		var tdTotalprice=$("<td><input class='layui-input' type='text' name='totalprice' value='0' readonly></td>");
		var tdUserId=$("<td><input class='layui-input' type='text' name='userId' value='1' readonly></td>");
		var tdName=$("<td></td>");
		var selName=$("<select  name='name' class='form-control'><option>请选择</option><option>1</option></select>");			
		var tdPhone=$("<td><input class='layui-input' type='text' name='phone' value='00000000000' readonly></td>");			
		var tdOrdertime=$("<td><input type='text' class='layui-input' id='ordertime' name='ordertime' placeholder='yyyy-MM-dd'></td>");			
  						
  				
		$("#orderTBody").prepend(trn.append(tdId)
									.append(tdGoodsId)
									.append(tdGoodsName.append(selGoodsName))
									.append(tdGoodsPrice)
									.append(tdBuyquantity)
									.append(tdTotalprice)
									.append(tdUserId)
									.append(tdName.append(selName))
									.append(tdPhone)
									.append(tdOrdertime));
		
		//添加商品名下拉
		var resG = goodsInfo.data;
		$.each(resG, function(){
			selGoodsName.append($("<option></option>").text(this.goodsName));
		})
		//添加用户名下拉
		var resU = userInfo.data;
		console.log(userInfo);
		$.each(resU, function(){
			selName.append($("<option></option>").text(this.username));
		})
		//给下拉商品名绑定接听事件
		$("select[name='goodsName']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resG = goodsInfo.data;
			$.each(resG, function(i,item){
				if(item.goodsName==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(1).find("input").val(item.id);
					thi.parents("tr").find("td").eq(3).find("input").val(item.goodsPrice);
					return;
				}
			})
		})
		//给下拉用户名绑定接听事件
		$("select[name='name']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resU = userInfo.data;
			$.each(resU, function(i,item){
				if(item.username==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(6).find("input").val(item.id);
					thi.parents("tr").find("td").eq(8).find("input").val(item.phone);
					return;
				}
			})
		})
		//购买数量接听
		$("input[name='buyquantity']").on("blur",function(){
			var a = $(this).val();
			console.log(a);
			var v = $(this).parents("tr").find("td").eq(3).find("input").val();
			$(this).parents("tr").find("td").eq(5).find("input").val(a*v);
		});
		
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		//同时绑定多个
		  $("input[name='ordertime']").each(function(){
		    laydate.render({
		      elem: this
		      ,value: '2019-01-09'
		      //,trigger: 'click'
		    });
		  });
		});
	})
	
	//给下拉商品名绑定接听事件
		$("select[name='goodsName']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resG = goodsInfo.data;
			$.each(resG, function(i,item){
				if(item.goodsName==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(1).find("input").val(item.id);
					thi.parents("tr").find("td").eq(3).find("input").val(item.goodsPrice);
					return;
				}
			})
		});
		//给下拉用户名绑定接听事件
		$("select[name='name']").change(function(){
			var a = $(this).find("option:selected").text()
			console.log(a);
			var thi=$(this);
			//console.log($(this).parents("tr").html());
			var resU = userInfo.data;
			$.each(resU, function(i,item){
				if(item.username==a){
					console.log(thi.parents("tr").find("td").html());
					thi.parents("tr").find("td").eq(6).find("input").val(item.id);
					thi.parents("tr").find("td").eq(8).find("input").val(item.phone);
					return;
				}
			})
		});
		
		//购买数量接听
		$("input[name='buyquantity']").on("blur",function(){
			var a = $(this).val();
			console.log(a);
			var v = $(this).parents("tr").find("td").eq(3).find("input").val();
			$(this).parents("tr").find("td").eq(5).find("input").val(a*v);
		});
	
	
	var goodsInfo,userInfo,orderViewInfo;
	$(function(){
		
		$.ajax({
			url : "${pageContext.request.contextPath }/orderViewAllList"
			,type : "GET"
			,dataType : "json"
			,success : function(result){
				var res = result.data;
				orderViewInfo = result;
				console.log(orderViewInfo);
				//获取商品信息
				$.ajax({
					url : "${pageContext.request.contextPath }/goodsAllList"
					,type : "GET"
					,dataType : "json"
					,success : function(result){
						var res = result.data;
						goodsInfo = result;
						console.log(goodsInfo);
						//获取用户信息
						$.ajax({
							url : "${pageContext.request.contextPath }/userAllList"
							,type : "GET"
							,dataType : "json"
							,success : function(result){
								var mId = result.data;
								userInfo = result;
								console.log(userInfo);
								addOrderView(orderViewInfo.data,goodsInfo.data,userInfo.data);
							}
							,error : function(result){
								
							}
						});		
					}
					,error : function(result){
						
					}
				});
			}
			,error : function(result){
				
			}
		});
		
		
	})
	


layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#ordertime' //指定元素
    ,value: '2019-01-09'
  });
//同时绑定多个
  $("input[name='ordertime']").each(function(){
    laydate.render({
      elem: this
      ,value: '2019-01-09'
      //,trigger: 'click'
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