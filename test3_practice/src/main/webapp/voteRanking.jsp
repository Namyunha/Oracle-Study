<%@page import="com.test.test3.dto.RankingDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.test3.dao.VoteDAO" %>
<%@ page import="com.test.test3.dto.VoteDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		text-align: center;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%@ include file="nav.jsp" %>
		<table>
			<thead>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>총투표건수</th>
			</tr>	
			</thead>
			<tbody>
			<%
				VoteDAO voteDAO = new VoteDAO();
				List<RankingDTO> rankingList = voteDAO.findAllRanking();
				for(RankingDTO ranking : rankingList) {
			%>
			<tr>
				<td><%=ranking.getM_no() %></td>
				<td><%=ranking.getM_name() %></td>
				<td><%=ranking.getV_sum() %></td>
			</tr>
			<% 		
				}
			%>
			</tbody>
		</table>
	<%@ include file="footer.jsp" %>
</body>
</html>