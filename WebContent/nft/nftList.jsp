<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>관리자 상품 목록 페이지</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="styles.css" rel="stylesheet" type="text/css">
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../index/css/header.css">	
</head>
<body>
<jsp:include page="../header.jsp"/>
	
					<h4 align="center"><small>[상품 목록]</small></h4>
					<table class="table table-hover">
							<thead class="thead-light">						
								<tr>
									<th class="text-center" style="width:8%">창조자</th>
									<th class="text-center" style="width:8%">소유자</th>
									<th class="text-center" style="width:8%">고유번호</th>
									<th class="text-center" style="width:10%">상품명</th>
									<th class="text-center" style="width:5%">가격</th>
									<th class="text-center" style="width:10%">nftUrl</th>
									<th class="text-center" style="width:8%">에디션</th>
									<th class="text-center" style="width:10%">등록일</th>
									<th class="text-center" style="width:8%">상세</th>
									<th class="text-center" style="width:8%">삭제</th>
								</tr>
						</thead>
						<tbody>	
							<c:forEach var="product" items="${productList}">
								<tr>
									<td class="text-center" style="width:8%"><c:out value="${product.creator}" /></td>
									<td class="text-center" style="width:8%"><c:out value="${product.owner}" /></td>
									<td class="text-center" style="width:8%"><c:out value="${product.unique_no}" /></td>
									<td class="text-center" style="width:10%"><c:out value="${product.p_name}" /></td>
									<td class="text-center" style="width:5%"><c:out value="${product.price}" /></td>
									<td class="text-center" style="width:10%"><c:out value="${product.nftUrl}" /></td>
									<td class="text-center" style="width:8%"><c:out value="${product.edition}" /></td>
									<td class="text-center" style="width:10%"><c:out value="${product.reg_date}" /></td>
									<td class="text-center" style="width:8%">
										<a href="nftDetail.do?unique_no=${product.unique_no}">상세</a>
									</td>
									<td class="text-center" style="width:8%">
										<a href="deleteNft.do?unique_no=${product.unique_no}">삭제</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>	
					</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>