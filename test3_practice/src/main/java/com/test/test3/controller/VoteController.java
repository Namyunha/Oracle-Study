package com.test.test3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.test3.dao.VoteDAO;
import com.test.test3.dto.MemberDTO;
import com.test.test3.dto.RankingDTO;
import com.test.test3.dto.VoteDTO;

@WebServlet("/")
public class VoteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			doProcess(req, res);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			doProcess(req, res);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex);
		String result = "";
		VoteDAO voteDAO = new VoteDAO();
		if(action.equals("/memberList")) {
			List<MemberDTO> memberList = voteDAO.findAll();
			req.setAttribute("memberList", memberList);
			result = "memberList.jsp";
		} else if(action.equals("/voteForm")) {
			result = "voteForm.jsp";
		} else if(action.equals("/voteList")) {
			List<VoteDTO> voteList = voteDAO.findVoteAll();
			req.setAttribute("voteList", voteList);
			result = "voteList.jsp";
		} else if(action.equals("/voteRanking")) {
			List<RankingDTO> rankingList = voteDAO.findAllRanking();
			req.setAttribute("rankingList", rankingList);
			result = "voteRanking.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(result);
		dispatcher.forward(req, res);
	}
}
