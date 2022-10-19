<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nft.controller.sy.NftListServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>상품 목록 - 관리자 페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[1대1문의 목록]</small></h4>
<!-- <form action="deleteNft.do" method="post"> -->
	<table class="table table-bordered">
		<tr>
			<th>창조자</th>
			<th>소유자</th>
			<th>고유번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>nftUrl</th>
			<th>설명</th>
			<th>에디션</th>
			<th>등록일자</th>
			<th>상세</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td><c:out value="${product.creator}" /></td>
					<td><c:out value="${product.owner}"/></td>
					<td><c:out value="${product.unique_no}"/></td>	
					<td><c:out value="${product.p_name}"/></td>
					<td><c:out value="${product.price}"/></td>
					<td><c:out value="${product.nftUrl}"/></td>
					<td><c:out value="${product.description}"/></td>
					<td><c:out value="${product.edition}"/></td>
					<td><c:out value="${product.reg_date}"/></td>
					<td><a href="nftDetail.do?unique_no=${product.unique_no}">상세</a></td>
					<td><a href="deleteNft.do?unique_no=${product.unique_no}">삭제</a></td>					
				</tr>
			</c:forEach>	
	</table> 	 
<!-- </form>  -->	
</body>
</html>