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
	 int result = (int) request.getAttribute("saveResult");
	if(result >= 0) {
	%>
	<script>
		alert("등록 성공!");
		location.href="index";
	</script>
	<%} else { %>
	<script>
		alert("등록 실패!");
		location.href="productForm";
	</script>
	<%
	}
	%>
</body>
</html>