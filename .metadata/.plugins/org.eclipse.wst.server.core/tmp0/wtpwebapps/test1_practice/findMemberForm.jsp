<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인사관리조회화면</h1>
	<form id="findForm" action="findMember.jsp" method="post">
		<label>인사관리조회</label><br>
		<input name="searchType" value="id" type="radio"> 사원번호로 조회 <input id="searchId" name="id" type="text"><br>
		<input name="searchType" value="dept" type="radio"> 부서명으로 조회 
		<select id="searchDept"  name="dept">
			<option value="인사부">인사부</option>
			<option value="기획부">기획부</option>
			<option value="홍보부">홍보부</option>
			<option value="영업부">영업부</option>
			<option value="경리부">경리부</option>
		</select>
		<br>
		<input onclick="findMember()" type="button" value="조회"> <input onclick="deleteBtn()" type="button" value="취소">
	</form>
	<script>
	
	const findMember = () => {
		findForm.submit();
	}
	
	const deleteBtn = () => {
		location.href="index.jsp";
	}
		
	</script>
</body>
</html>