<%@ page import="com.test.test1.dao.MemberDAO" %>
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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println("deleteMember에 있는 name = " + name + " id = " + id);
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.deleteMember(name, id);
		if(result >= 1) {
	%>
		<script>
			alert("삭제에 성공하였습니다.");
			location.href="deleteMemberForm.jsp";
		</script>
	<% } else { %>
		<script>
			alert("삭제에 실패하였습니다.");
			location.href="deleteMemberForm.jsp";
		</script>
	<% } %>
</body>
</html>