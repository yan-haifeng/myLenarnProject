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
	 * ��¼�߼�����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0�����ñ����ʽ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//1����ȡ�û���������û���������
			String name = request.getParameter("login-username");
			String password = request.getParameter("login-password");
		
			boolean flag = false;
		//2���������ݿ�
		
			java.sql.Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet rSet = null;
			
			String user = "root";
			String pass = "haifeng";
			
			try {
				connection = DBHelper.getConnection();
				
		
		//3�������ӵĻ����ϣ�ִ��SQL���������ִ�н��
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
		//4������ִ�н����������Ӧ����
			if(!flag) {
				//response.getWriter().println("�û������������");
				response.getWriter().println("<script>window.alert('�û������������');window.location.href='index.jsp'</script>");
			}else {
				response.sendRedirect("taobao.jsp");
				HttpSession session = request.getSession(true);
				session.setAttribute("username", name);
			}	
	}

}
