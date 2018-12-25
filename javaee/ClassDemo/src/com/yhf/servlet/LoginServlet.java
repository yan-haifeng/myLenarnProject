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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Resultset;
import com.sun.corba.se.pept.transport.Connection;
import com.yhf.util.DBHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 登录逻辑处理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0、设置编码格式
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//1、获取用户名输入的用户名和密码
			String name = request.getParameter("login-username");
			String password = request.getParameter("login-password");
		
			boolean flag = false;
		//2、连接数据库
		
			java.sql.Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet rSet = null;
			
			String user = "root";
			String pass = "haifeng";
			
			try {
				connection = DBHelper.getConnection();
				
		
		//3、在连接的基础上，执行SQL命令，并返回执行结果
				String sql = "select username,password from tb_user where username=? and password=?";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, name);
				pStatement.setString(2, password);
				
				rSet = pStatement.executeQuery();
				
				if (rSet.next()) {
					flag = true;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//4、根据执行结果，作出相应处理
			if(!flag) {
				//response.getWriter().println("用户名或密码错误");
				response.getWriter().println("<script>window.alert('用户名或密码错误');window.location.href='index.jsp'</script>");
			}else {
				response.sendRedirect("taobao.jsp");
				HttpSession session = request.getSession(true);
				session.setAttribute("username", name);
			}	
	}

}
