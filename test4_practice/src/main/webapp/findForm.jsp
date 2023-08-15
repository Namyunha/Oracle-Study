<%@page import="com.test.test4.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>생산관리 조회 & 수정 화면</h1>
	<label for="productSaveForm">
		생산관리 등록화면
	</label>
	<form id="productForm" action="find" method="post">
		<ul>
			<li>
				<label for="code">제품코드</label>
				<input id="code" name="code" type="text">
			</li>
			<br>
			<li>
				<label for="pname">제품이름</label>
				<input id="pname" name="pname" type="text">
			</li>
			<br>
			<li>
				<label for="cost">제품원가</label>
				<input id="cost" name="cost" type="text">
			</li>
			<br>
			<li>
				<label for="pnum">목표수량</label>
				<input id="pnum" name="pnum" type="text">
			</li>
			<br>
			<li>
				<label for="inum">재고수량</label>
				<input id="inum" name="inum" type="text">
			</li>
			<br>
			<li>
				<label for="sale">출고가</label>
				<input id="sale" name="sale" type="text">
			</li>
			<br>
			<li>
				<label for="gcode">그룹이름</label>
				<select id="gcode" name="gcode">
					<option value="">선택</option>
					<option value="A">컴퓨터</option>
					<option value="B">냉장고</option>
					<option value="C">냉장소모품</option>
				</select>
			</li>
		</ul>
		<br>
		<div>
			<input onclick="findBtn()" type="button" value="조회">
			<input onclick="updateBtn()" type="button" value="수정">
			<input onclick="deleteBtn()" type="button" value="삭제">
			<input onclick="goIndex()" type="button" value="메인화면">
		</div>
	</form>
	<script>
	
		const productForm = document.querySelector("#productForm");	
		
		const findBtn = () => {
			productForm.submit();
		}
	
		const goIndex = () =>{
			location.href="index";
		}
	</script>	
</body>
</html>









