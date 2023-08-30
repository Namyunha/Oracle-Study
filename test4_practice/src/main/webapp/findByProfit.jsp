<%@page import="com.test.test4.vo.ProductionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이익 순위 제품</h1>
<%
	List<ProductionVO>list = (List<ProductionVO>) request.getAttribute("list");
	for(ProductionVO production : list){
%>
	<table>
		<thead>
			<tr>
				<th>제품이름</th>
				<th>총이익금액</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=production.getPname() %></td>
				<td><%=production.getInum() %></td>
			</tr>
		</tbody>
	</table>
<% 
	}
%>

</body>
</html>