<%@ page import="com.test.test2.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        #contents {
            background-color: burlywood;
            padding: 20px;
        }
    </style>
</head>
<%
	MemberDAO memberDAO = new MemberDAO();
	int custno = memberDAO.getCustNo();
%>
<body>
<%@include file="header.jsp"%>
<%@include file="nav.jsp"%>

<h1>홈쇼핑 회원 등록</h1>

<form id="saveForm" action="saveMember.jsp" method="post">
<table>
	<tr>
		<th><label for="custno">회원번호(자동발생)</label></th>
		<td><%=custno %>
		<input id="custno" type="hidden" name="custno" value=<%=custno %>></td>
	</tr>
	<tr>
		<th><label for="custname">회원성명</label></th>
		<td><input id="custname" type="text" name="custname"></td>
	</tr>
	<tr>
		<th><label for="phone">회원전화</label></th>
		<td><input id="phone" type="text" name="phone"></td>
	</tr>
	<tr>
		<th><label for="address">회원주소</label></th>
		<td><input id="address" type="text" name="address"></td>
	</tr>
	<tr>
		<th><label for="joindate">가입일자</label></th>
		<td><input id="joindate" type="date" name="joindate"></td>
	</tr>
	<tr>
		<th><label for="grade">고객등급(A:VIP, B:일반, C:직원)</label></th>
		<td>
			<select id="grade" name="grade">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
	</tr>
	<tr>
		<th><label for="city">도시코드</label> </th>
		<td><input id="city" type="text" name="city"></td>
	</tr>
	<tr>
		<td><input onclick="memberSave()" type="button" value="등록"><input type="button" value="조회"></td>
	</tr>
</table>
</form>
<script>

	const memberSave = () => {
		const saveForm = document.querySelector("#saveForm");
		const custname = document.querySelector("#custname");
		const phone = document.querySelector("#phone");
		const address = document.querySelector("#address");
		const joindate = document.querySelector("#joindate");
		const grade = document.querySelector("#grade");
		const city = document.querySelector("#city");
		if(custname.value == "") {
			alert("이름을 입력해주세요");
			custname.focus();
			return false;
		} else if(phone.value == ""){
			alert("번호를 입력해주세요");
			phone.focus();
			return false;
		} else if(address.value == ""){
			alert("주소를 입력해주세요");
			address.focus();
			return false;
		} else if(joindate.value == ""){
			alert("날짜를 입력해주세요");
			joindate.focus();
			return false;
		} else if(grade.value == ""){
			alert("고객등급을 선택해주세요");
			grade.focus();
			return false;
		} else if(city.value == ""){
			alert("도시코드를 입력해주세요");
			city.focus();
			return false;
		} else {
			alert("회원등록이 완료되었습니다.");
			saveForm.submit();
		}
	}
</script>
</body>
</html>