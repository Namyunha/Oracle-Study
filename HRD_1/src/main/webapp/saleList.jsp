<%@page import="com.test.test2.dto.SaleDTO"%>
<%@page import="java.util.List"%>
<%@ page import="com.test.test2.dao.MemberDAO" %>
<%@ page import="com.test.test2.dto.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
<%@include file="nav.jsp"%>
<h1>회원매출조회</h1>
<table>
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
	</thead>
<%
	MemberDAO memberDAO = new MemberDAO();
	List<SaleDTO> saleList = memberDAO.findSaleList();
	for(SaleDTO saleDTO : saleList){
%>
	<tbody>
		<tr>
			<td><%=saleDTO.getCustno() %></td>
			<td><%=saleDTO.getCustname() %></td>
			<td><%=saleDTO.getGrade() %></td>
			<td><%=saleDTO.getSaleamount() %></td>
		</tr>
	</tbody>
<%} %>

</table>
</body>
</html>