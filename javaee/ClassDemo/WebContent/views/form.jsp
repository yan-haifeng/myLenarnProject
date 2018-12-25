<%@page import="com.yhf.dao.ItemsDao"%>
<%@page import="com.yhf.entity.Items"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String action = request.getParameter("action");
String name = "", city = "",number = "",price = "",picture = "",Introduct = "";
int id = -1;
if(action.equals("update")){
	ItemsDao iDao = new ItemsDao();
	Items item = new Items();
	id = Integer.parseInt(request.getParameter("id"));
	item = iDao.getItemsById(id);
	
	name = item.getName().toString();
	city = item.getCity().toString();
	number = Integer.toString(item.getNumber());
	price = Double.toString(item.getPrice());
	picture = item.getPicture().toString();
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../assets/css/layui.css">
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <title></title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-row">
            <div class="layui-card">
                <form class="layui-form layui-card-body" action="<%=request.getContextPath()%>/ItemService?action=<%=action%>&id=<%=id%>" method="post">
                  <div class="layui-form-item">
                    <label class="layui-form-label">商品名称</label>
                    <div class="layui-input-block">
                      <input type="text" name="name" required  lay-verify="required" placeholder="请输入商品名" autocomplete="off" class="layui-input" value="<%=name%>">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">商品产地</label>
                    <div class="layui-input-block">
                      <input type="text" name="city" required  lay-verify="required" placeholder="请输入产地名" autocomplete="off" class="layui-input" value="<%=city%>">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">商品价格</label>
                    <div class="layui-input-block">
                      <input type="text" name="price" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input" value="<%=price%>">
                    </div>
                    <p><%=id %></p>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">商品数量</label>
                    <div class="layui-input-block">
                      <input type="text" name="number" required  lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input" value="<%=number%>">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">商品图片</label>
                    <div class="layui-input-block">
                      <input type="text" name="picture" required  lay-verify="required" placeholder="请输入图片链接" autocomplete="off" class="layui-input" value="<%=picture%>">
                    </div>
                  </div>
                  <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">商品介绍</label>
                    <div class="layui-input-block">
                      <textarea name="desc" placeholder="请输入内容" class="layui-textarea" ></textarea>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <input type="submit" class="layui-btn layui-btn-fluid">确定</input>
                  </div>
                </form>  
            </div>
        </div>
    </div>
    <script src="../assets/layui.all.js"></script>
    <script>
      var form = layui.form
        ,layer = layui.layer;
    </script>
</body>
</html>