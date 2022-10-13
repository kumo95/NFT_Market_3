<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
    <link href="css/productDetail.css" type="text/css" rel="stylesheet" />
    
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    
</head>

<%@ include file="../header.jsp" %>

<body>

		<div class="container">
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" action="searchProduct.do">
               <select name="column">
                    <option ${(param.column=="p_name")?"selected":""} value="p_name">상품명</option>
                    <option ${(param.column=="creator")?"selected":""} value="creator">creator</option>
                </select>
                <div class="input-group">
                    <input class="form-control" type="text" name="keyword" value="${param.keyword}" placeholder="검색어를 입력하세요" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>
		</div>
		
<section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">NFT</h2>
            
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start">
         	
             <c:forEach var="product" items="${productList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        
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
                        <!-- Product details-->
                        <div class="card-body p-4">
							<div class="text-center">
							<a style="color: inherit; text-decoration: none;" href="productDetail.do?unique_no=${product.unique_no}">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${product.p_name}</h5>
                                <!-- Product price-->
                                ${product.price} ETH
                           </a>
                            </div>
                        </div>
        
                        <!-- Product actions-->
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
			</div>
		</div>
</section>



<a href="regist.do">상품등록</a>	


        <!-- Pagination-->
        <nav aria-label="Pagination">
            <hr class="my-0" />
            <ul class="pagination justify-content-center my-4">
                <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1"
                        aria-disabled="true">Newer</a></li>
                <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                <li class="page-item"><a class="page-link" href="#!">2</a></li>
                <li class="page-item"><a class="page-link" href="#!">3</a></li>
                <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                <li class="page-item"><a class="page-link" href="#!">15</a></li>
                <li class="page-item"><a class="page-link" href="#!">Older</a></li>
            </ul>
        </nav>

</body>

<%@ include file="../footer.jsp" %>

</html>