package com.yhf.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IfcodeImageServlet
 */
@WebServlet("/IfcodeImageServlet")
public class IfcodeImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IfcodeImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1������bufferedImage����
		BufferedImage bImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		
		//����
		Graphics graphics = bImage.getGraphics();
		
		Color color = new Color(0, 0, 0);
		//graphics.setColor(color);
		graphics.fillRect(0, 0, 68, 22);
		
		//ͨ��random���������֤�벢����
		
		char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789".toCharArray();
		
		Random random = new Random();
		int len = ch.length, index;
		String string = "";
		
		for(int i=0;i<4;i++) {
			index = random.nextInt(len);
			graphics.setColor(color);
			graphics.drawString(ch[index]+"", (i*15)+5, 16);
			string+=ch[index];
		}
		
		//5����֤����Ϣ���浽Session��
		
		request.getSession().setAttribute("piccode", string);
		
		//6������֤��ͼƬ��io���
		
		ImageIO.write(bImage, "JPG",  response.getOutputStream());
	}

}
