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
		if(request.getAttribute("result")!=null){
		int result = (int) request.getAttribute("result");
		
	%>
	<script>
		if(<%=result%> == 1){
			alert("삭제에 성공 하셨습니다.");	
		} 
	</script>
	<%
		}
	%>
	<h1>생산관리 시스템</h1>
	<label>생산관리 매안매뉴</label>
	<button onclick="location.href='saveProductionForm'">제품입력</button>
	<button onclick="location.href='findProductionForm'">제품조회</button>
	<button onclick="location.href='findByPriority'">우선생산제품</button>
	<button onclick="location.href='findByProfit'">이익순위</button>
	<button onclick="location.href='findByGroup'">그룹별재고수량</button>
</body>
</html>