<%@ page import="com.test.test2.dao.MemberDAO" %>
<%@ page import="com.test.test2.dto.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>홈쇼핑 회원 정보 수정</h1>
<%@include file="header.jsp"%>
<%@include file="nav.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String custno = request.getParameter("custno");
	System.out.println("custno = " + custno);
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = memberDAO.findById(custno);
%>
<form id="updateForm" action="updateMember.jsp" method="post">
<table>
	<tr>
		<th><label for="custno">회원번호(자동발생)</label></th>
		<td>
		<%=memberDTO.getCustno() %>
		<input id="custno" type="hidden" name="custno" value=<%=memberDTO.getCustno() %> >
		</td>
	</tr>
	<tr>
		<th><label for="custname">회원성명</label></th>
		<td><input id="custname" type="text" name="custname" value=<%=memberDTO.getCustname() %>></td>
	</tr>
	<tr>
		<th><label for="phone">회원전화</label></th>
		<td><input id="phone" type="text" name="phone" value=<%=memberDTO.getPhone() %>></td>
	</tr>
	<tr>
		<th><label for="address">회원주소</label></th>
		<td><input id="address" type="text" name="address" value=<%=memberDTO.getAddress() %>></td>
	</tr>
	<tr>
		<th><label for="joindate">가입일자</label></th>
		<td>
		<%=memberDTO.getJoindate() %> 
		<input id="joindate" type="hidden" name="joindate" value=<%=memberDTO.getJoindate() %>>
		</td>
	</tr>
	<tr>
		<th><label for="grade">고객등급(A:VIP, B:일반, C:직원)</label></th>
		<td>
			<select id="grade" name="grade" value=<%=memberDTO.getGrade() %>>
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
	</tr>
	<tr>
		<th><label for="city">도시코드</label> </th>
		<td><input id="city" type="text" name="city" value=<%=memberDTO.getCity() %>></td>
	</tr>
	<tr>
		<td><input onclick="memberUpdate()" type="button" value="수정"><input type="button" value="조회"></td>
	</tr>
</table>
</form>
<script>
	const memberUpdate = () => {
		const updateForm = document.querySelector("#updateForm");
		updateForm.submit();
	}
</script>
</body>
</html>