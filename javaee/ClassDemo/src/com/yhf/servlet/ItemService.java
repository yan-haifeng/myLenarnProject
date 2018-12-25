package com.yhf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhf.dao.ItemsDao;
import com.yhf.entity.Items;

/**
 * Servlet implementation class ItemService
 */
@WebServlet("/ItemService")
public class ItemService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("action").equals("del")) {  //É¾³ý
			int id = Integer.parseInt(request.getParameter("id"));
			ItemsDao itemsDao = new ItemsDao();
			itemsDao.deleteItem(id);
			response.sendRedirect("views/items.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Items items = new Items();
			ItemsDao itemsDao = new ItemsDao();
			if(request.getParameter("action").equals("add")){  //Ìí¼Ó
				items.setName(request.getParameter("name"));
				items.setCity(request.getParameter("city"));
				items.setPrice(Double.parseDouble(request.getParameter("price")));
				items.setNumber(Integer.parseInt(request.getParameter("number")));
				items.setPicture(request.getParameter("picture"));
				
				itemsDao.addItem(items);
				response.getWriter().println("<script>var index = parent.layer.getFrameIndex(window.name);parent.layer.close(index);</script>");
		}else if(request.getParameter("action").equals("update")){
				items.setId(Integer.parseInt(request.getParameter("id")));
				items.setName(request.getParameter("name"));
				items.setCity(request.getParameter("city"));
				items.setPrice(Double.parseDouble(request.getParameter("price")));
				items.setNumber(Integer.parseInt(request.getParameter("number")));
				items.setPicture(request.getParameter("picture"));
			
				itemsDao.updateItem(items);
				response.getWriter().println("<script>var index = parent.layer.getFrameIndex(window.name);parent.layer.close(index);</script>");
		}
	}

}
