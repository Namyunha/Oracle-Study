<%@ page import="com.test.test2.dao.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String custno = request.getParameter("custno");
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	System.out.println("custno = " + custno + " custname = " + custname + " phone = " + phone + " address = " + address + " grade = " + grade + " city = " + city);
	
	MemberDAO memberDAO = new MemberDAO();
	int result = memberDAO.save(custno, custname, phone, address, joindate, grade, city);
	if(result >= 1) {
%>
	<script>
		location.href="index.jsp";
	</script>
	<% } else { %>
	<script>
		alert("회원등록에 실패하셨습니다.");
		location.href="saveMemberForm.jsp";
	</script>
	<%} %>
<body>
</body>
</html>



