<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인사관리 퇴사처리 화면</h1>
	<label for="deleteForm">인사관리 사원정보 변경</label>
	<form id="deleteForm" action="deleteMember.jsp" method="post">
		<label for="name">성명: </label><input id="name" name="name" type="text"><br>
		<label for="id">사원번호: </label><input id="id" name="id" type="text"><br>
		<input onclick="deleteMember()" type="button" value="삭제"><input type="button" value="취소">
	</form>
	<script>
		const deleteMember = () => {
			const deleteForm = document.querySelector("#deleteForm");
			deleteForm.submit();
		}
	</script>
</body>
</html>