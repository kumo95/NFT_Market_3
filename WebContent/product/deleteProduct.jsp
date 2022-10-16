<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제 페이지</title>
</head>
<body>
<h2>상품 삭제 페이지</h2>

<form action="deleteProduct.do" method="post">
<table border="1">
	<tr>
		<td>
			<c:choose>
				<c:when test="${empty product.nftUrl}">
					<img src="image/noimage.png">
				</c:when>
				<c:otherwise>
					<img src="upload/${product.nftUrl}">
				</c:otherwise>
			</c:choose>	
		</td>
		<td>
		<table border="1">		
		<tr>
			<th style="width:80px">상품명</th>
			<td>${product.p_name}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${product.price}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${product.description}</td>
		</tr>
		<tr>
			<th>등록 일자</th>
			<td>${product.reg_date}</td>
		</tr>
		</table>
		</td>
	</tr>
</table>
<input type="hidden" name="unique_no" value="${product.unique_no}">
<input type="submit" value="삭제">
<input type="button" value="목록" onclick="location.href='productList.do'">

</form>
</body>
</html>