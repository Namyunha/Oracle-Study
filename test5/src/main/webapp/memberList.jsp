<%@page import="com.test.test5.dto.MemberDTO"%>
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
		<h2>후보조회</h2>
		<table>
			<thead>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
			</thead>
			<%
				List<MemberDTO>memberList = (List<MemberDTO>)request.getAttribute("list");
				for(MemberDTO m : memberList){
			%>
			<tbody>
				<tr>
					<td><%=m.getM_no() %></td>
					<td><%=m.getM_name() %></td>
					<td><%=m.getP_name() %></td>
					<td><%=m.getP_school() %></td>
					<td><%=m.getM_jumin() %></td>
					<td><%=m.getM_city() %></td>
					<td><%=m.getP_tel() %></td>
				</tr>
			</tbody>
			<%
				} 
			%>
		</table>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserved. Human Resources Development Service of Korea</p>
	</footer>
</body>
</html>