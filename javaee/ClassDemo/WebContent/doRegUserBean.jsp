<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myuser" class="com.yhf.entity.User"/>
<jsp:setProperty property="username" name="myuser" param="register-username"/>
<jsp:setProperty property="password" name="myuser" param="register-password"/>

<jsp:useBean id="userDao" class="com.yhf.dao.UserDao"/>
<%
	if(userDao.saveUser(myuser)){
		out.println("注册成功，5秒钟后返回注册页面");
		response.setHeader("refresh", "5;url=index.jsp");
	}else{
		out.println("注册失败，请修改信息");
	}
%>
</body>
</html>