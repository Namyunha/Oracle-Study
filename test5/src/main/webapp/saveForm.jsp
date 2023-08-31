<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
		<h1>(과정평가형 정보처리 산업기사) 지역구 의원 투표 프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="memberList">후보조회</a></li>
			<li><a href="saveForm">투표하기</a></li>
			<li><a href="voteList">투표검수조회</a></li>
			<li><a href="memberRecord">후보자등수</a></li>
			<li><a href="index">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h1>투표하기</h1>
		<form id="saveForm" action="saveVote" method="post">
			<label for="v_jumin">주민번호</label> <input id="v_jumin" name="v_jumin" type="text" ><br>
			<label for="v_name">성명</label> <input type="text" name="v_name"><br>
			<label for="m_no">투표번호</label> <input type="text" name="m_no"><br>
			<label for="v_time">투표시간</label> <input type="text" name="v_time"><br>
			<label for="v_area">투표장소</label> <input type="text" name="v_area"><br>
			<label for="v_confirm">유권자확인</label>
			<input type="radio" name="v_confirm" value="Y">확인 
			<input type="radio" name="v_confirm" value="N">미확인<br>
			<input onclick="saveBtn()" type="button" value="투표하기">
			<input onclick="resetBtn()" type="button" value="다시하기">
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserved. Human Resources Development Service of Korea</p>
	</footer>
	<script>
		const saveBtn = () => {
			const saveForm = document.querySelector("#saveForm");
			saveForm.submit();
		}
	</script>
</body>
</html>