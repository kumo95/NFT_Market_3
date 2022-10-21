<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>상품삭제 - 관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="../index/css/header.css">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h4 align="center"><small>[상품 삭제 목록]</small></h4>
<form action="deleteNft.do" method="post">
	<table class="table table-hover">
		<thead class="thead-light">
			<tr>
				<th class="text-center" style="width:8%">창조자</th>
				<th>소유자</th>
				<th>고유번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>nftUrl</th>
				<th>설명</th>
				<th>에디션</th>
				<th>게시날짜</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<%-- <c:forEach var="product" items="${productList}"> --%>
				<tr>
					<td class="text-center" style="width:8%">${product.creator}</td>
					<td>${product.owner}</td>
					<td>${product.unique_no}</td>
					<td>${product.p_name}</td>
					<td>${product.price}</td>
					<td>${product.nftUrl}</td>
					<td>${product.description}</td>
					<td>${product.edition}</td>
					<td>${product.reg_date}</td>
					<td>
						<input type="hidden" name="unique_no" value="${product.unique_no}">
						<input type="submit" value="삭제">	
						<input type="button" value="목록" onclick="location.href='nftList.do'">
					</td>
				</tr>
			<%-- </c:forEach> --%>
		</tbody>		
	</table> 
	
</form>   	




</body>
</html>