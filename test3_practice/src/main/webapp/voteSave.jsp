<%@ page import="com.test.test3.dao.VoteDAO" %>
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
		request.setCharacterEncoding("UTF-8");
		String vJumin = request.getParameter("vJumin");
		String vName = request.getParameter("vName");
		String mNo = request.getParameter("mNo");
		String vTime = request.getParameter("vTime");
		String vArea = request.getParameter("vArea");
		String vConfirm = request.getParameter("vConfirm");
		System.out.println("vJumin = " + vJumin + " vName = " + vName + " mNo = " + mNo + " vTime = " + vTime + " vArea = " + vArea + " vConfirm = " + vConfirm);
		VoteDAO voteDAO = new VoteDAO();
		int result = voteDAO.saveVote(vJumin, vName, mNo, vTime, vArea, vConfirm);
		if(result >= 1){
	%>
		<script>
			alert("투표하기 정보가 정상적으로 등록되었습니다.");
			location.href="index.jsp";
		</script>
		<% } else { %>
		<script>
			alert("등록에 실패하였습니다..");
			location.href="voteForm.jsp";
		</script>
		<%} %>
</body>
</html>