
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.test1.dao.MemberDAO" %>
<%@ page import="com.test.test1.dto.MemberDTO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원정보조회결과</h1>
<table>
<tr>
	<th>사원번호</th>
	<th>사원명</th>
	<th>소속부서</th>
	<th>직급</th>
	<th>직책</th>
	<th>연락처</th>
</tr>

<%
	request.setCharacterEncoding("UTF-8");
	String searchId = request.getParameter("id");
	String searchDept = request.getParameter("dept");
	String searchType = request.getParameter("searchType");
	System.out.println("SearchId = " + searchId + " searchDept = " + searchDept + " searchType = " + searchType);
	MemberDAO memberDAO = new MemberDAO();
	List<MemberDTO> memberList = memberDAO.findMember(searchId, searchDept, searchType);
	System.out.println("memberList = " + memberList);
	for(MemberDTO memberDTO : memberList){
%>
<tr>
	<td><%=memberDTO.getId() %></td>
	<td><%=memberDTO.getName() %></td>
	<td><%=memberDTO.getDept() %></td>
	<td><%=memberDTO.getDuty() %></td>
	<td><%=memberDTO.getPosition() %></td>
	<td><%=memberDTO.getPhone() %></td>
</tr>
<% } %>
</table>
<button onclick="findMember()">확인</button>

<script>
const findMember = () => {
	location.href="findMemberForm.jsp"
}

</script>
</body>
</html>