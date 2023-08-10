<%@page import="java.util.List"%>
<%@ page import="com.test.test3.dao.VoteDAO" %>
<%@ page import="com.test.test3.dto.VoteDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%@ include file="nav.jsp" %>
	<div id="content">
		<h1>투표검수조회</h1>
		<table>
		<thead>
			<th>성명</th>
			<th>생년월일</th>
			<th>나이</th>
			<th>성별</th>
			<th>후보번호</th>
			<th>투표시간</th>
			<th>유권자확인</th>
		</thead>
		<tbody>
		<%
			VoteDAO voteDAO = new VoteDAO();
			List<VoteDTO> voteList = voteDAO.findVoteAll();
			for(VoteDTO voteDTO : voteList){
				System.out.println(voteDTO.getvName());
		%>
			<td><%=voteDTO.getvName() %></td>
			<td><%=voteDTO.getvJumin() %></td>
			<td><%=voteDTO.getvAge() %></td>
			<td><%=voteDTO.getvGender() %></td>
			<td><%=voteDTO.getmNo() %></td>
			<td><%=voteDTO.getvTime() %></td>
			<td><%=voteDTO.getvConfirm() %></td>
		</tbody>
		<%} %>
		</table>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>