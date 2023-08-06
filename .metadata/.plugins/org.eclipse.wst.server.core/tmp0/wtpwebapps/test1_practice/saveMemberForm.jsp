<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>인사관리사원등록화면</h1><br>
<form id="saveForm" action="saveMember.jsp" method="post">
	<label for="name">성명</label><input id="name" name="name" type="text"><br>
	<label for="id">사원번호</label><input id="id" name="id" type="text"><br>
	<label for="dept">소속부서</label>
	<select id="dept" name="dept">
		<option value="인사부">인사부</option>
		<option value="기획부">기획부</option>
		<option value="홍보부">홍보부</option>
		<option value="영업부">영업부</option>
		<option value="경리부">경리부</option>
	</select>
	<br>
	<label for="position">직급</label>
	<select id="position" name="position">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select>
	<br>
	<label for="duty">직책</label><input id="duty" name="duty" type="text"><br>
	<label for="phone">연락처</label><input id="phone" name="phone" type="text"><br>
	<input type="button" onclick="saveMember()" value="등록"><input type="button" onclick="deleteBtn()" value="취소">
	<script>
		const saveMember = () => {
			saveForm.submit();
		}
		
		const deleteBtn = () => {
			location.href="index.jsp";
		}
	</script>
</form>
</body>
</html>