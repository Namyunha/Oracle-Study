<%@ page import="com.example.test2.model.MemberDAO" %>
<%@ page import="com.example.test2.model.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        #contents {
            padding: 20px;
            background-color: burlywood;
            text-align: center;

        }
    </style>
</head>
<body>
<%
    MemberDAO memberDAO = new MemberDAO();
    String custno = request.getParameter("custno");
%>
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>
<div id="contents">
    
</div>
<%@include file="footer.jsp"%>
</body>
<script>
    function saveCheck() {
        if (document.updateForm.custname.value == "") {
            alert("이름을 입력해주세요");
            document.updateForm.custname.focus();
            return false;
        } else if (document.updateForm.phone.value == "") {
            alert("전화번호를 입력해주세요");
            document.updateForm.phone.focus();
            return false;
        } else if (document.updateForm.address.value == "") {
            alert("주소를 입력해주세요");
            document.updateForm.address.focus();
            return false;
        } else if (document.updateForm.joindate.value == "") {
            alert("가입일자를 입력해주세요");
            document.updateForm.joindate.focus();
            return false;
        } else if (document.updateForm.grade.value == "") {
            alert("고객등급을 입력해주세요");
            document.updateForm.grade.focus();
            return false;
        } else if (document.updateForm.city.value == "") {
            alert("도시코드를 입력해주세요");
            document.updateForm.city.focus();
            return false;
        }
        alert("회원정보수정이 완료되었습니다.");
        document.updateForm.submit();
    }
</script>
</html>
