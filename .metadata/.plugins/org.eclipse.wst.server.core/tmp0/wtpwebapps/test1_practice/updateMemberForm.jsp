<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인사관리 사원정보 변경화면</h1>
	<form id="updateForm" action="updateMember.jsp" method="post">
		<label for="name">성명</label><input id="name" name="name" type="text"><br>
		<label for="id">사원번호</label><input id="id" name="id" type="text"><br>
		<label for="dept">소속부서</label>
		<select name="dept" id="dept">
			<option value="인사부">인사부</option>
			<option value="기획부">기획부</option>
			<option value="영업부">영업부</option>
			<option value="홍보부">홍보부</option>
			<option value="경리부">경리부</option>
		</select>
		<br>
		<label for="position">직급</label>
		<select id="position" name="position">
			<option value="1">1급</option>
			<option value="2">2급</option>
			<option value="3">3급</option>
			<option value="4">4급</option>
		</select>
		<br>
		<label for="duty">직책</label><input id="duty" name="duty" type="text"><br>
		<label for="phone">연락처</label><input id="phone" name="phone" type="text"><br>
		<input onclick="updateMember()" type="button" value="수정"><input onclick="deleteBtn()" type="button" value="취소">
	</form>
	<script>
		const updateMember = () => {
			const updateForm = document.querySelector("#updateForm");
			updateForm.submit();
		}
		
		const deleteBtn = () => {
			location.href="index.jsp";
		}
		
		
	</script>
</body>
</html>