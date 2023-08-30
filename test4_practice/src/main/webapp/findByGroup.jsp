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
<h1>그룹별재고수량</h1>
<%
	List<ProductionVO> list = (List<ProductionVO>) request.getAttribute("list");
	for(ProductionVO production : list){
		%>
	<table>
		<thead>
			<tr>
				<th>그룹명</th>
				<th>품목명</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=production.getGcode() %></td>
				<td><%=production.getPname() %></td>
			</tr>
		</tbody>
	</table>
		<%
	}
%>

</body>
</html>