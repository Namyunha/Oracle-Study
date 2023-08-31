<%@page import="com.test.test5.dto.RecordDTO"%>
<%@page import="java.util.List"%>
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
		<h1>후보자등수</h1>
		<table>
			<thead>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
			</thead>
			<%
				List<RecordDTO>recordList = (List<RecordDTO>) request.getAttribute("list");
				for(RecordDTO record : recordList){
			%>
			<tbody>
				<tr>
					<td><%=record.getM_no() %></td>
					<td><%=record.getM_name() %></td>
					<td><%=record.getV_sum() %></td>
				</tr>
			</tbody>
			<%} %>
		</table>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserved. Human Resources Development Service of Korea</p>
	</footer>
</body>
</html>