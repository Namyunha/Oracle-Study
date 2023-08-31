package com.test.test5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.test5.dao.VoteDAOImpl;
import com.test.test5.dto.MemberDTO;
import com.test.test5.dto.RecordDTO;
import com.test.test5.dto.VoteDTO;

@WebServlet("/")
public class VoteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("UTF-8");
		String resultPage = "";
		VoteDAOImpl voteDAO = new VoteDAOImpl();
		if(action.equals("saveForm")) {
			resultPage="/saveForm.jsp";
		} else if(action.equals("saveVote")) {
			String v_jumin = request.getParameter("v_jumin");
			String v_name = request.getParameter("v_name");
			String m_no = request.getParameter("m_no");
			String v_time = request.getParameter("v_time");
			String v_area = request.getParameter("v_area");
			String v_confirm = request.getParameter("v_confirm");
			VoteDTO voteDTO = new VoteDTO(v_jumin, v_name, m_no, v_time, v_area, v_confirm);
			List<VoteDTO> voteList = voteDAO.voteList();
			int result = voteDAO.saveVote(voteDTO);
			request.setAttribute("list", voteList);
			resultPage ="/voteList.jsp";
		} else if(action.equals("memberList")) {
			List<MemberDTO> memberList = voteDAO.memberList();
			request.setAttribute("list", memberList);
			resultPage ="/memberList.jsp";
		} else if(action.equals("voteList")) {
			List<VoteDTO> voteList = voteDAO.voteList();
			request.setAttribute("list", voteList);
			resultPage = "/voteList.jsp";
		} else if(action.equals("memberRecord")) {
			List<RecordDTO> recordList = voteDAO.recordList(); 
			request.setAttribute("list", recordList);
			resultPage="/memberRecord.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}








