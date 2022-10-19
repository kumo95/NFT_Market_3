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
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="mainPage.jsp">NFTique</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link" href="productList.do">상품</a></li>
				
				<c:if test="${control==null}">
					<li class="nav-item"><a class="nav-link" href="login.do">창조</a></li>
				</c:if>
				<c:if test="${control==1}">
					<li class="nav-item"><a class="nav-link" href="regist.do">창조</a></li>
				</c:if>
					
					<li class="nav-item"><a class="nav-link" href="community.do">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link" href="cs/index.jsp">고객센터</a></li>
					
				<c:if test="${control==null}">
					<li class="nav-item"><a class="nav-link" href="login.do">마이페이지</a></li>
				</c:if>
				<c:if test="${control==1}">
					<li class="nav-item"><a class="nav-link" href="myPage.do">마이페이지</a></li>
				</c:if>
					
				</ul>
				<form class="d-flex">
						<a href="signUp.do"><button class="btn btn" type="button">회원가입</button></a>
					<c:if test="${control==null}">
						<a href="login.do"><button class="btn btn" type="button">로그인</button></a>
					</c:if>
					<c:if test="${control==1}">
						<a href="logout.do"><button class="btn btn" type="button">로그아웃</button></a>
						<a href="updateMember.do"><button class="btn btn" type="button">개인정보변경</button></a>
					</c:if>
				</form>
			</div>
		</div>
	</nav>
	

		
	
	
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





		<!-- DB연동 안됨 -->
			<div class="col mb-5">
			
				<div class="card h-100">
				<!-- Product image  -->
				<img class="card-img-top" src="index/img/img2.png" alt="..." />
				<!-- Product details -->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name -->
						<h5 class="fw-bolder">Internal Rhythm: Red Sea</h5>
						<h6 class="fw1">판매자 김아무개</h6>
						<h6 class="fw2">소유자 kim012</h6>
						Product price 0.338 ETH~
					</div>
				</div>
				<!-- Product actions -->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="#">담기</a> 
						<a class="btn btn-outline-dark mt-auto" href="#">좋아요</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-5">
			<div class="card h-100">
				<!-- Product image  -->
				<img class="card-img-top" src="index/img/img3.png" alt="..." />
				<!-- Product details -->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name -->
						<h5 class="fw-bolder">Universe</h5>
						<h6 class="fw1">판매자 이아무개</h6>
						<h6 class="fw2">소유자 lee</h6>

						Product price 0.137 ETH~
					</div>
				</div>
				<!-- Product actions -->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="#">담기</a> <a
							class="btn btn-outline-dark mt-auto" href="#">좋아요</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-5">
			<div class="card h-100">

				<!-- Product image --> 
				<img class="card-img-top" src="index/img/img4.png" alt="..." />
				<!-- Product details -->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name -->
						<h5 class="fw-bolder">어느 오후</h5>
						<h6 class="fw1">판매자 이아무개</h6>
						<h6 class="fw2">소유자 lee</h6>
						Product price 0.088 ETH~
					</div>
				</div>
				<!-- Product actions -->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="#">담기</a> <a
							class="btn btn-outline-dark mt-auto" href="#">좋아요</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-5">
			<div class="card h-100">
				<!-- Product image  -->
				<img class="card-img-top" src="index/img/img5.png" alt="..." />
				<!-- Product details -->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name -->
						<h5 class="fw-bolder">별이 빛나는 밤에</h5>
						<h6 class="fw1">판매자 박아무개</h6>
						<h6 class="fw2">소유자 park</h6>
						Product price 0.16 ETH~
					</div>
				</div>
				<!-- Product actions -->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="#">담기</a> <a
							class="btn btn-outline-dark mt-auto" href="#">좋아요</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-5">
			<a class="img">
				<img class="img/nft.png">
			</a>
		</div>
	</div>
	</section>


        <!-- Pagination-->	
	         	<c:set var="page" value="${(empty param.p)?1:param.p}"></c:set>
				<c:set var="startNum" value="${page -(page-1) % 5}"></c:set>
				<%-- <c:set var="lastNum" value="${Math.ceil(count/10)}"></c:set> --%>
				<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/8), '.')}"></c:set>      

        <nav aria-label="Pagination">
            <hr class="my-0" />
            <ul class="pagination justify-content-center my-4">
                <c:if test="${startNum-1 > 0}">
                <li class="page-item"><a class="page-link" href="?p=${startNum - 1}">이전</a></li>
				</c:if>
				<c:if test="${startNum-1 <= 0}">
					<span class="page-item page-link" onclick="alert('이전 페이지가 없습니다.')">이전</span>
				</c:if>
				<c:forEach var="i" begin="0" end="4">
					<!-- 마지막 게시물이 있는 페이지까지만 표시 -->
					<c:if test="${(i+startNum) <= lastNum }">
						<!-- // 해당 페이지 인 경우, 스타일 지정 -->									
                <li class="page-item ${(page==(i+startNum))?'active':''}"><a class="page-link" href="?p=${i+startNum}&column=${param.column}&keyword=${param.keyword}">${i+startNum}</a></li>
				</c:if>
				</c:forEach>

            	<c:if test="${startNum + 4 < lastNum}">
            	<li class="page-item"><a class="page-link" href="?p=${startNum + 5}">다음</a></li>
				</c:if>
				<c:if test="${startNum + 4 >= lastNum}">
						<span class="page-item page-link" onclick="alert('다음 페이지가 없습니다.')">다음</span>
				</c:if>
            </ul>
        </nav>
	
	

	<!-- Footer-->
	<footer class="py-5 bg-light">
		<div class="container">
			<p class="m-0 text-center text-black">Copyright &copy; NFTique
				2022</p>
		</div>
	</footer>


	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
