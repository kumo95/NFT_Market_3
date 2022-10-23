<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		
<section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-1">
            <h2 class="fw-bolder mb-1">NFT 상품</h2>
            
		<div class="container px-4 px-lg-5 text-end">
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" action="productList.do">
               <div class="input-group">
               <select name="column">
                    <option ${(param.column=="p_name")?"selected":""} value="p_name">상품명</option>
                    <option ${(param.column=="creator")?"selected":""} value="creator">creator</option>
                </select>
                    <input class="form-control" type="text" name="keyword" value="${param.keyword}" placeholder="검색어를 입력하세요" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>
		</div>
            
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start mt-4">
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


       		
         		<c:set var="page" value="${(empty param.p)?1:param.p}"></c:set>
				<c:set var="startNum" value="${page -(page-1) % 5}"></c:set>
				<%-- <c:set var="lastNum" value="${Math.ceil(count/10)}"></c:set> --%>
				<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/8), '.')}"></c:set>      

       
        <!-- Pagination-->
        <nav aria-label="Pagination">
            <hr class="my-0" />
            <ul class="pagination justify-content-center my-4">
                <c:if test="${startNum-1 > 0}">
                <li class="page-item"><a class="page-link" href="?p=${startNum - 1}&column=${param.column}&keyword=${param.keyword}">이전</a></li>
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
            	<li class="page-item"><a class="page-link" href="?p=${startNum + 5}&column=${param.column}&keyword=${param.keyword}">다음</a></li>
				</c:if>
				<c:if test="${startNum + 4 >= lastNum}">
						<span class="page-item page-link" onclick="alert('다음 페이지가 없습니다.')">다음</span>
				</c:if>
            </ul>
        </nav>
   
   
<%-- <a href="regist.do">상품등록</a>	
<div>상품 ${count}개</div>    
				<table>
					<tr>
						<td style="border:white; text-align:right;">
						<div><span>${(empty param.p)?1:param.p }</span>/${lastNum} pages</div>		
						</td>
					</tr>
				</table>      --%>
        
</body>
<%@ include file="../footer.jsp" %>

</html>