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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String duty = request.getParameter("duty");
		String phone = request.getParameter("phone");
		System.out.println("name = "+ name + " id = " + id + " dept = " + dept + " position = " + position + " duty = " + duty + " phone = " + phone);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setName(name);
		memberDTO.setDept(dept);
		memberDTO.setPosition(position);
		memberDTO.setDuty(duty);
		memberDTO.setPhone(phone);
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.saveMember(memberDTO);
		if(result >= 1) {
	%>
	<script>
		alert("사원 등록에 성공하셨습니다");
		location.href="saveMemberForm.jsp";
	</script>
	<% } else { %>
	<script>
		alert("사원 등록에 실패하였습니다");
		location.href="saveMemberForm.jsp";
	</script>
	<% } %>
	
	
</body>
</html>