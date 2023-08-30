<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>생산관리 등록화면</h1>
	<label for="saveForm">생산관리 등록화면</label>
	<form id="saveForm" name="saveForm" method="post">
		<ul>
			<li>
				<label for="code">제품코드</label>
				<input id="code" type="text" name="code">
			</li>
			<li>
				<label for="pname">제품이름</label>
				<input id="pname" type="text" name="pname" >
			</li>
			<li>
				<label for="cost">제품원가</label>
				<input id="cost" type="text" name="cost" >
			</li>
			<li>
				<label for="pnum">제고수량</label>
				<input id="pnum" type="text" name="pnum" >
			</li>
			<li>
				<label for="inum">목표수량</label>
				<input id="inum" type="text" name="inum" >
			</li>
			<li>
				<label for="sale">출고가</label>
				<input id="sale" type="text" name="sale" >
			</li>
			<li>
				<label for="gcode">그룹이름</label>
				<select id="gcode" name="gcode">
					<option>선택하기</option>
					<option value="A">컴퓨터</option>
					<option value="B">냉장고</option>
					<option value="C">냉장고소모품</option>
				</select>
			</li>
		</ul>
		<div id="btnGroup">
			<input onclick="saveProduction()" type="button" value="등록">
			<input onclick="goHome()" type="button" value="메인화면">
		</div>
	</form>
	<script>
	let saveForm = document.querySelector("#saveForm");
	const saveProduction = () => {
		saveForm.action = "saveProduction";
		saveForm.submit();
	}
	
	const goHome = () => {
		saveForm.action = "index";
		saveForm.submit();
	}
	</script>
</body>
</html>



