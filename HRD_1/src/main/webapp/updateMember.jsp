<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="com.test.test2.dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		System.out.println("custno = " + custno + " custname = " + custname + " phone = " + phone + " address = " + address + "joindate = " + joindate + " city = " + city);
 		MemberDAO memberDAO = new MemberDAO(); 
		int result = memberDAO.updateMember(custno, custname, phone, address, joindate, grade, city);
		if(result >= 1) {
	%>
		<script>
			alert("수정에 성공했습니다.");
			location.href="memberList.jsp";
		</script>
		<%} else { %>
		<script>
			alert("수정에 실패했습니다.");
			location.href="updateForm.jsp?custno=<%=custno%>";
		</script>
		<% } %>
</body>
</html>