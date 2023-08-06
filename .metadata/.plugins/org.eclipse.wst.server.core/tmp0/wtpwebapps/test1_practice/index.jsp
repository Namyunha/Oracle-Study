<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>인사관리시스템</h1>
<label>인사관리 메인메뉴</label><br>
<button onclick="findMember()">조회</button> <button onclick="saveMember()">사원등록</button> <button onclick="updateMember()">정보변경</button> <br>
<button onclick="deleteMember()">퇴사처리</button><button>종료</button>
<script>
	const findMember = () => {
		location.href="findMemberForm.jsp";
	}
	const saveMember = () => {
		location.href="saveMemberForm.jsp";
	}
	const updateMember = () => {
		location.href="updateMemberForm.jsp";
	}
	const deleteMember = () => {
		location.href="deleteMemberForm.jsp";
	}
</script>
</body>
</html>