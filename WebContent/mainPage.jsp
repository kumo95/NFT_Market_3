<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>메인페이지</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="index/css/styles.css" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com">
</head>
<%@ include file="header.jsp"%>
<body>
	
	<!--  section -->
	<section class="py-5">	
		<div class="main_picture">
			<img src="index/img/img1.png">
		</div>
		<div class="section-top">
			<h3 class="section-title">MarketPlace</h3>
			<p class="section-subTitle">NFT를 자유롭게 거래해보세요.</p>
			<div class="rightArr">
				<a class="btn btn-outline-dark mt-auto" href="productList.do">전체보기</a>
			</div>
		</div>	
		
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
<!--  상품리스트 DB연결 -->
		<c:forEach var="product" items="${productList}">
			<div class="col mb-5">
				<div class="card h-100">
				<!-- Product image  -->
				<a style="color: inherit; text-decoration: none;" href="productDetail.do?unique_no=${product.unique_no}">      
                <c:choose>
				<c:when test="${empty product.nftUrl}">
					<img class="card-img-top" src="images/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img class="card-img-top" src="upload/${product.nftUrl}">
				</c:otherwise>
				</c:choose>
				</a>
				<!-- Product details -->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name -->
						<h5 class="fw-bolder">${product.p_name}</h5>
						<h6 class="fw1">판매자 ${product.creator}</h6>
						<h6 class="fw2">소유자 ${product.owner}</h6>
						Product price ${product.price} ETH~
					</div>
				</div>
				<!-- Product actions -->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" 
                        href="addCart.do?userid=${loginUser.userid}&creator=${product.creator}&unique_no=${product.unique_no}&p_name=${product.p_name}&price=${product.price}&nftUrl=${product.nftUrl}">
                        장바구니</a> 
						<a class="btn btn-outline-dark mt-auto" href="#">좋아요</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>





		
<%@ include file="footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
