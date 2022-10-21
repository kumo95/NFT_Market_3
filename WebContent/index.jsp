<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>

<%@ include file="header.jsp" %>

<body>
<br>로그인 하면 메인으로?
<br>
<h2>첫 페이지</h2>
<br>
<br>
<br>
<br>
<h1><a href="login.do">로그인</a></h1>	
<br>
<br>
<br>
<br>
<br>
<a href="regist.do">상품등록</a>
<a href="productList.do">상품 리스트</a>
<input type="button" value="목록" onclick="location.href='productList.do'">	
<br>
<br>
<a href="admin-bootstrap/index.jsp">관리자</a>


</body>



<%@ include file="footer.jsp" %>

</html>