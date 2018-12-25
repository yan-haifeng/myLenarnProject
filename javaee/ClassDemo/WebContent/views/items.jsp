<%@page import="com.yhf.dao.ItemsDao"%>
<%@page import="com.yhf.entity.Items"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String add = "add",
		 update = "update";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../assets/css/layui.css">
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">商品</a>
                  <a><cite>我的商品</cite></a>
                </span>
                <h2 class="title">我的商品</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item">
                            <div class="layui-inline">
                                <div class="layui-form-mid">id号:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" autocomplete="off" class="layui-input">
                                </div>
                                <button class="layui-btn layui-btn-blue">查询</button>
                                <button class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div> 
                        <a class="layui-btn layui-btn-blue" onclick="editItem('add')"><i class="layui-icon">&#xe654;</i>新增</a>
                        <table lay-filter="demo">
                          <colgroup>
                            <col width="150">
                            <col width="200">
                            <col>
                          </colgroup>
                          <thead>
                            <tr>
                              <th lay-data="{field:'id', sort:true}">ID</th>
                              <th lay-data="{field:'name'}">商品名</th>
                              <th lay-data="{field:'city'}">产地</th>
                              <th lay-data="{field:'price'}">价格</th>
                              <th lay-data="{field:'number'}">余量</th>
                              <th lay-data="{field:'btn',unresize:true}">操作</th>
                            </tr> 
                          </thead>
                          <tbody>
                          <!-- 表格开始 -->
                          <%
                          ItemsDao itemsDao = new ItemsDao();
                          ArrayList<Items> list = itemsDao.getAllItems();
                          Items items = new Items();
                          int id = -1;
                          for(int i=0;i<list.size();i++){
                        	  items = list.get(i);
                        	  id = items.getId();
                          %>
                            <tr>
                              <td><%=id%></td>
                              <td><%=items.getName()%></td>
                              <td><%=items.getCity()%></td>
                              <td><%=items.getPrice()%></td>
                              <td><%=items.getNumber()%></td>
                              <td><div class="layui-btn-group" style="margin-right:auto;margin-left:auto">
                                <a class="layui-btn layui-btn-sm" onclick="seeItem(<%=id%>)">查看</a>
                                <a class="layui-btn layui-btn-sm layui-btn-warm" onclick="editItem('update',<%=id%>)">编辑</a>
                                <a class="layui-btn layui-btn-sm layui-btn-danger"  href="<%=request.getContextPath()%>/ItemService?action=del&id=<%=items.getId()%>">删除</a>
                              </div></td>
                            </tr>
                            <%
                          }
                            %>
                            <!-- 表格结束 -->
    <script src="../assets/layui.all.js"></script>
    <script>
    var table = layui.table;
 
    //转换静态表格
    table.init('demo', {
    //height: 315//设置高度
    page: true 
    ,limit: 5
    ,limits: [5,10,15]
    }); 
    </script>
    <script> 
    function editItem(action,id){
    layui.use('layer',function(){
        var layer = layui.layer;
        layer.open({
            title: ['商品信息添加修改', 'font-size:18px;'],
            type: 2, 
            content: '../views/form.jsp?id='+id+'&action='+action,//这里content是一个普通的String
            area: ['800px' ,'500px']
        });
    });
}
    function seeItem(id){
        layui.use('layer',function(){
            var layer = layui.layer;
            layer.open({
                title: ['商品信息', 'font-size:18px;'],
                type: 2, 
                content: '../Detailid.jsp?id='+id,//这里content是一个普通的String
                area: ['1000px' ,'500px'],
                btn: '确定'
            });
        });
    }
    </script>
</body>
</html>