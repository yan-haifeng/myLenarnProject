<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myuser" class="com.yhf.entity.User"/>
<jsp:setProperty property="username" name="myuser" param="login-username"/>
<jsp:setProperty property="password" name="myuser" param="login-password"/>

<jsp:useBean id="userDao" class="com.yhf.dao.UserDao"/>
<%
	myuser = userDao.Login(myuser.getUsername(), myuser.getPassword());

	if(!(myuser.getUsername()==null))
	{
		response.sendRedirect("taobao.jsp");
		session.setAttribute("username", myuser.getUsername());
	}
	else
	{
		out.println("用户名密码错误");
	}
%>
</body>
</html>