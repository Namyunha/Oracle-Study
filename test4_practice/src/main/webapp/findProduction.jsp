<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String code = request.getParameter("code");
		System.out.print("findForm code = " + code);
	%>
	<h1>
		findProduction
	</h1>
</body>
</html>