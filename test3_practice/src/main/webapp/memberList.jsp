<%@page import="com.test.test3.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.test.test3.dao.VoteDAO" %>
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
	<h1>후보조회</h1>
	<table>
		<thead>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>
		</thead>
		<tbody>
		<% 
			VoteDAO voteDAO = new VoteDAO();
			List<MemberDTO> memberList = voteDAO.findAll();
			for(MemberDTO memberDTO : memberList){
				System.out.println(memberDTO.getmName());
			
		%>
		<tr>
			<td><%=memberDTO.getmNo() %></td>
			<td><%=memberDTO.getmName() %></td>
			<td><%=memberDTO.getpName() %></td>
			<td><%=memberDTO.getpSchool() %></td>
			<td><%=memberDTO.getmJumin() %></td>
			<td><%=memberDTO.getmCity() %></td>
			<td><%=memberDTO.getpTel() %></td>
		</tr>
		</tbody>
		<%} %>
	</table>
	<%@ include file="footer.jsp" %>
</body>
</html>