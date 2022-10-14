<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품삭제 - 관리자 페이지</title>
</head>
<body>
<div id="wrap" align="center">
<h2>상품 삭제 - 관리자 페이지</h2>

<form action="deleteNft.do" method="post">
	<table border="1">
		<tr>
			<th>만든이</th>
			<td>${product.creator}</td>
		<tr>	
			<th>소유자</th>
			<td>${product.owner}</td>
		</tr>
		<tr>	
			<th>고유번호</th>	
			<td>${product.unique_no}</td>
		</tr>	
		<tr>	
			<th>상품 이름</th>
			<td>${product.p_name}</td>
		</tr>		
		<tr>	
			<th>가격</th>
			<td>${product.price}</td>
		</tr>	
		<tr>	
			<th>nftUrl</th>
			<td>${product.nftUrl}</td>
		<tr>	
		<tr>	
			<th>설명</th>
			<td>${product.description}</td>
		</tr>	
		<tr>	
			<th>에디션</th>
			<td>${product.edition}</td>
		</tr>	
		<tr>	
			<th>게시날짜</th>
			<td>${product.reg_date}</td>
		</tr>	
	</table> 
	<input type="hidden" name="unique_no" value="${product.unique_no}">
	<input type="submit" value="삭제">	
	<input type="button" value="목록" onclick="location.href='nfttList.do'">
</form>   	
</div>



</body>
</html>