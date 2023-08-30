package com.test.test4.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		if(action.equals("/index")) {
			resultPage = "/index.jsp";
		} else if(action.equals("/saveProductionForm")) {
			resultPage = "saveProductionForm.jsp";
		} else if(action.equals("/saveProduction")) {
			String code = request.getParameter("code");
			String pname = request.getParameter("pname");
			long cost = Long.parseLong(request.getParameter("cost"));
			long pnum = Long.parseLong(request.getParameter("pnum"));
			long inum = Long.parseLong(request.getParameter("inum"));
			long sale = Long.parseLong(request.getParameter("sale"));
			String gcode = request.getParameter("gcode");
			ProductionVO vo = new ProductionVO(code, pname, cost, pnum, inum, sale, gcode);
			int result = productionDAO.create(vo);
			resultPage= "/index.jsp";
		} else if(action.equals("/findProductionForm")) {
			resultPage = "findProductionForm.jsp";
		} else if(action.equals("/findProduction")) {
			resultPage = "/findProduction.jsp";
			String code = request.getParameter("code");
			ProductionVO readVO = productionDAO.readOne(code);
			request.setAttribute("product", readVO);
		} else if(action.equals("/updateProduction")) {
			resultPage = "/findProduction.jsp";
			String code = request.getParameter("code");
			String pname = request.getParameter("pname");
			long cost = Long.parseLong(request.getParameter("cost"));
			long pnum = Long.parseLong(request.getParameter("pnum"));
			long inum = Long.parseLong(request.getParameter("inum"));
			long sale = Long.parseLong(request.getParameter("sale"));
			String gcode = request.getParameter("gcode");
			ProductionVO vo = new ProductionVO(code, pname, cost, pnum, inum, sale, gcode);
			System.out.println("process VO  = " + vo.toString());
			int result = productionDAO.upgrade(vo);
			request.setAttribute("result", result);
			request.setAttribute("product", vo);
		} else if(action.equals("/deleteProduction")) {
			String code = request.getParameter("code");
			int result = productionDAO.delete(code);
			request.setAttribute("result", result);
			resultPage = "/index.jsp";
		} else if(action.equals("/findByPriority")) {
			List<ProductionVO> priorityList = productionDAO.readList("priority");
			request.setAttribute("list", priorityList);
			resultPage = "/findByPriority.jsp";
		} else if(action.equals("/findByProfit")) {
			List<ProductionVO> priorityList = productionDAO.readList("profit");
			request.setAttribute("list", priorityList);
			resultPage = "/findByProfit.jsp";
		} else if(action.equals("/findByGroup")) {
			List<ProductionVO> groupList = productionDAO.readList("group");
			request.setAttribute("list", groupList);
			resultPage = "/findByGroup.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}




