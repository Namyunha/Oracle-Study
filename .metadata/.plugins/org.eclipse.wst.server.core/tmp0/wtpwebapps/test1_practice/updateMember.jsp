<%@ page import="com.test.test1.dao.MemberDAO" %>
<%@ page import="com.test.test1.dto.MemberDTO" %>
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
		String id = request.getParameter("id");
		MemberDAO memberDAO = new MemberDAO();
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String duty = request.getParameter("duty");
		String phone = request.getParameter("phone");
		System.out.println("Update에 있는 Id = " + id + " Name = " + name + " dept = " + dept + " position = " + position + " duty = " + duty + " phone = " + phone);
		int result = memberDAO.updateMember(id, name, dept, position, duty, phone);
		if(result >= 1) {
	%>
		<script>
			alert("회원수정에 성공하셨습니다.");
			location.href="updateMemberForm.jsp";
		</script>
	<% } else {  %>
		<script>
			alert("회원수정에 실패하였습니다");
			location.href="updateMemberForm.jsp";
		</script>
	<% } %>
</body>
</html>