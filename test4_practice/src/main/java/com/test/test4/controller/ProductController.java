package com.test.test4.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.test4.dao.ProductionDAO;
import com.test.test4.dao.ProductionDAOImpl;
import com.test.test4.vo.ProductionVO;

@WebServlet("/")
public class ProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		System.out.println("uri = " + uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex);
		System.out.println("Action = " + action);
		String resultPage = "";
		ProductionDAOImpl productionDAO = new ProductionDAOImpl();
		ProductionVO productionVO = new ProductionVO();
		if(action.equals("/saveProductionForm")) {
			resultPage = "saveProductionForm.jsp";
		} else if(action.equals("/findProductionForm")) {
			resultPage = "findProductionForm.jsp";
		} else if(action.equals("/findProduction")) {
			resultPage = "/findProduction.jsp";
			String code = request.getParameter("code");
			ProductionVO readVO = productionDAO.readOne(code);
			System.out.println(readVO.toString());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}




