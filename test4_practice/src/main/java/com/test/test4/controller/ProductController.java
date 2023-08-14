package com.test.test4.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.test.test4.dao.ProductDAOImpl;
import com.test.test4.vo.ProductVO;

import javax.servlet.annotation.*;

@WebServlet("/")
public class ProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(req, resp);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(req, resp);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("action = " + action);
		request.setCharacterEncoding("UTF-8");
		ProductDAOImpl productDAO = new ProductDAOImpl();
		String resultPage = "";
		if(action.equals("productForm")) {
			resultPage = "productForm.jsp";
		} else if(action.equals("saveProduct")) {
			String code = request.getParameter("code");
			String pname = request.getParameter("pname");
			int cost = Integer.parseInt(request.getParameter("cost"));
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			int inum = Integer.parseInt(request.getParameter("inum"));
			int sale = Integer.parseInt(request.getParameter("sale"));
			String gcode = request.getParameter("gcode");
			ProductVO vo = new ProductVO(code, pname, cost, pnum, inum, sale, gcode);
			System.out.println(vo.getPname());
			int result = productDAO.create(vo);
			System.out.println("result = " + result);
			request.setAttribute("saveResult", result);
			resultPage = "saveProduct.jsp";
		}
		
		else if(action.equals("index")) {
			resultPage = "index.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}








