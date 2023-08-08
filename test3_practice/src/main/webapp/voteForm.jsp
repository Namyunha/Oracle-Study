<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>
<h1>투표하기</h1>
<div id="content">
	<form id="saveForm" action="voteSave.jsp" method="post">
		<label for="vJumin">주민번호</label>
		<input type="text" id="vJumin" name="vJumin"><br>
		<label for="vName">성명</label>
		<input id="vName" name="vName" type="text"><br>
		<label for="mNo">투표번호</label>
		<select id="mNo" name="mNo">
			<option value="">선택하기</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option	value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select><br>
		<label for="vTime">투표시간</label>
		<input type="text" id="vTime" name="vTime"><br>
		<label for="vArea">투표장소</label>
		<input type="text" id="vArea" name="vArea"><br>
		<label>유권자확인</label>
		<input id="yConfirm" type="radio" name="vConfirm" value="Y"> 확인
		<input id="nConfirm" type="radio" name="vConfirm" value="N"> 미확인<br>
		<input onclick="voteSave()" type="button" value="투표하기"> <input onclick="resetBtn()" type="button" value="다시하기">
	</form>
</div>
<%@include file="footer.jsp" %>
<script>
	const saveForm = document.querySelector("#saveForm")
	const vJumin = document.querySelector("#vJumin");
	const vName= document.querySelector("#vName");
	const mNo= document.querySelector("#mNo");
	const vTime = document.querySelector("#vTime");
	const vArea = document.querySelector("#vArea");
	const yConfirm = document.querySelector("#yConfirm");
	const nConfirm = document.querySelector("#nConfirm");
	
	const resetBtn = () => {
		vJumin.value = "";
		vName.value = "";
		mNo.value = "" ;
		vTime.value = "";
		vArea.value = "";
		yConfirm.checked = false;
		nConfirm.checked = false;
		vJumin.focus();
		alert("정보를 지우고 처음부터 다시 입력합니다.");
	}
	
	const voteSave = () => {
		if(vJumin.value == ""){
			alert("주민번호가 입력되지 않았습니다!");
			vJumin.focus();
			return false;
		}else if(vName == ""){
			alert("성명이 입력되지 않았습니다!");
			vName.focus();
			return false;
		}else if(mNo == ""){
			alert("후보번호가 선택되지 않았습니다!");
			mNo.focus();
			return false;
		}else if(vTime.value == ""){
			alert("투표시간이 입력되지 않았습니다!");
			vTime.focus();
			return false;
		}else if(vArea.value == ""){
			alert("투표장소가 입력되지 않았습니다!");
			vArea.focus();
			return false;
		}else if(!yConfirm.checked && !nConfirm.checked){
			alert("유권자확인이 선택되지 않았습니다.");
			yConfirm.focus();
			return false;
		}else {
			saveForm.submit();
		}
	}
</script>
</body>
</html>