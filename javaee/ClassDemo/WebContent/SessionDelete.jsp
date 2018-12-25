<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>模拟淘宝</title>
</head>
<body>
<%
session.removeAttribute("username");
session.invalidate();
response.getWriter().println("<script>window.location.href='taobao.jsp';</script>");
%>
</body>
</html>