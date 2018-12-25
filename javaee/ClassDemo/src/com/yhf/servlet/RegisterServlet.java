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
				//1����ȡ�û���������û���������
					String ReUser = request.getParameter("register-username");
					String RePass = request.getParameter("register-password");
					String ReIfcode = request.getParameter("register-code").toUpperCase();
					
					int ErrorType = 0;
				
					boolean flag = false;
				//2���������ݿ�
				
					java.sql.Connection connection = null;
					PreparedStatement pStatement = null;
					ResultSet rSet = null;
					
					try {
						connection = DBHelper.getConnection();
						
						//�ж���֤���Ƿ���ȷ
						if (!ReIfcode.equals(request.getSession().getAttribute("piccode"))) {
							
							ErrorType = 1;
							System.out.println(request.getSession().getAttribute("piccode"));
							
						}else{
							//3�������ӵĻ����ϣ�ִ��SQL���������ִ�н��
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
					
				//4������ִ�н����������Ӧ����
					if(flag) {
						response.getWriter().println("<script>window.alert('ע��ɹ�');window.location.href='index.jsp';</script>");
						//response.getWriter().println("�û������������");
						//System.out.println("�û������������");
						}else {
						//response.sendRedirect("http://www.baidu.com");
						switch (ErrorType) {
						case 0:
							response.getWriter().println("<script>window.alert('�û����Ѵ���');window.location.href='index.jsp';</script>");
							break;
						case 1:
							response.getWriter().println("<script>window.alert('��֤�����');window.location.href='index.jsp';</script>");
							break;}}		
}
}
