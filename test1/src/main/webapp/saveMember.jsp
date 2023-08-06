<%@page import="com.test.test1.dao.MemberDAO"%>
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String duty = request.getParameter("duty");
		String phone = request.getParameter("phone");
		
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.saveMember(id, name, dept, position, duty, phone);
		if (result > 0) {
	%>
	<script>
		alert("등록성공");
		location.href="index.jsp";
	</script>
	<%
		} else {
	%>
	<script>
		alert("등록실패");
		location.href="saveMemberForm.jsp";
	</script>
	<%
		}
	%>
</body>
</html>