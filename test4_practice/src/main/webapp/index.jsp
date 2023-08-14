<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>생산관리 시스템</h1>
	<label>생산관리 메인메뉴</label>
	<div>
		<button onclick="saveProduct()">제품입력</button><button>제품조회</button><button>우선생산제품</button><button>이익순위</button><br>
		<button>그룹별재고수량</button>
	</div>
	<script>
		const saveProduct = () => {
			location.href= "productForm";
		}
	</script>
</body>
</html>