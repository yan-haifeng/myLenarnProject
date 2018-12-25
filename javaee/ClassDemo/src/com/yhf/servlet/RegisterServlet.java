package com.yhf.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.yhf.util.DBHelper;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// TODO Auto-generated method stub
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
				//1、获取用户名输入的用户名和密码
					String ReUser = request.getParameter("register-username");
					String RePass = request.getParameter("register-password");
					String ReIfcode = request.getParameter("register-code").toUpperCase();
					
					int ErrorType = 0;
				
					boolean flag = false;
				//2、连接数据库
				
					java.sql.Connection connection = null;
					PreparedStatement pStatement = null;
					ResultSet rSet = null;
					
					try {
						connection = DBHelper.getConnection();
						
						//判断验证码是否正确
						if (!ReIfcode.equals(request.getSession().getAttribute("piccode"))) {
							
							ErrorType = 1;
							System.out.println(request.getSession().getAttribute("piccode"));
							
						}else{
							//3、在连接的基础上，执行SQL命令，并返回执行结果
							String sql = "insert into tb_user(username,password) values(?,?)";
							pStatement = connection.prepareStatement(sql);
							pStatement.setString(1, ReUser);
							pStatement.setString(2, RePass);
							
							pStatement.executeUpdate();
							
							if (rSet.next()) {
								flag = true;
							}
						}
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				//4、根据执行结果，作出相应处理
					if(flag) {
						response.getWriter().println("<script>window.alert('注册成功');window.location.href='index.jsp';</script>");
						//response.getWriter().println("用户名或密码错误");
						//System.out.println("用户名或密码错误");
						}else {
						//response.sendRedirect("http://www.baidu.com");
						switch (ErrorType) {
						case 0:
							response.getWriter().println("<script>window.alert('用户名已存在');window.location.href='index.jsp';</script>");
							break;
						case 1:
							response.getWriter().println("<script>window.alert('验证码错误');window.location.href='index.jsp';</script>");
							break;}}		
}
}
