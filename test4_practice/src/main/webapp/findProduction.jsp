<%@page import="com.test.test4.vo.ProductionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ProductionVO productionVO = (ProductionVO)request.getAttribute("product");
	System.out.print("findProduction: production = " + productionVO.toString());
%>
	<h1>생산관리 조회 & 수정 & 삭제 화면</h1>
	<label for="findForm">생산관리 조회 & 수정 & 삭제 화면</label>
	<form id="findForm" name="findForm" method="post">
		<ul>
			<li>
				<label for="code">제품코드</label>
				<input id="code" type="text" name="code" value=<%=productionVO.getCode() %>>
			</li>
			<li>
				<label for="pname">제품이름</label>
				<input id="pname" type="text" name="pname" value=<%=productionVO.getPname() %>>
			</li>
			<li>
				<label for="cost">제품원가</label>
				<input id="cost" type="text" name="cost" value=<%=productionVO.getCost() %>>
			</li>
			<li>
				<label for="pnum">제고수량</label>
				<input id="pnum" type="text" name="pnum" value=<%=productionVO.getPnum() %>>
			</li>
			<li>
				<label for="inum">목표수량</label>
				<input id="inum" type="text" name="inum" value=<%=productionVO.getInum() %>>
			</li>
			<li>
				<label for="sale">출고가</label>
				<input id="sale" type="text" name="sale" value=<%=productionVO.getSale() %>>
			</li>
			<li>
				<label for="gcode">그룹이름</label>
				<select id="gcode" name="gcode">
					<option><%=productionVO.getGcode() %></option>
					<option value="A">컴퓨터</option>
					<option value="B">냉장고</option>
					<option value="C">냉장고소모품</option>
				</select>
			</li>
		</ul>
		<div id="btnGroup">
			<input onclick="findProduction()" type="button" value="조회">
			<input onclick="updateProduction()" type="button" value="수정">
			<input onclick="deleteProduction()" type="button" value="삭제">
			<input onclick="goHome()" type="button" value="메인화면">
		</div>
	</form>
	<script>
		let findForm = document.querySelector("#findForm");
		const findProduction = () => {
			findForm.action = "findProduction";
			findForm.submit();
		}
		
		const updateProduction = () => {
			findForm.action = "updateProduction";
			findForm.submit();
		}
		
		const deleteProduction = () => {
			findForm.action = "deltetProduction";
			findForm.submit();
		}
		
		const goHome = () => {
			findForm.action = "index";
			findForm.submit();
		}
		
	</script>
</body>
</html>