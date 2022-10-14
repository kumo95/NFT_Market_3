<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nft.controller.NftListServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 - 관리자 페이지</title>
</head>
<body>
<h2>상품목록조회 - 관리자 페이지</h2>
<!-- <form action="deleteNft.do" method="post"> -->
	<table border="1">
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