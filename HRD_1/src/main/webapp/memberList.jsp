<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.test2.dao.MemberDAO" %>
<%@ page import="com.test.test2.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>
<h1>회원목록조회/수정</h1>
<table>
	<thead>
		<th>회원번호</th>
		<th>회원성명</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>가입일자</th>
		<th>고객등급</th>
		<th>거주지역</th>
	</thead>
	<%
		MemberDAO memberDAO = new MemberDAO();
		List<MemberDTO> memberList = memberDAO.findAll();
		for(MemberDTO memberDTO : memberList) {
	%>
	<tbody>
		<td><a href="updateForm.jsp?custno=<%=memberDTO.getCustno() %>"><%=memberDTO.getCustno() %></a></td>
		<td><%=memberDTO.getCustname() %></td>
		<td><%=memberDTO.getPhone() %></td>
		<td><%=memberDTO.getAddress() %></td>
		<td><%=memberDTO.getJoindate() %></td>
		<td><%=memberDTO.getGrade() %></td>
		<td><%=memberDTO.getCity() %></td>
	</tbody>
	<% } %>
	
	
</table>
<%@include file="footer.jsp" %>
</body>
</html>