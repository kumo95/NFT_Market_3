<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>상품상세페이지</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <!--CSS-->
    <link href="css/productDetail.css" type="text/css" rel="stylesheet" />
</head>
<%@ include file="../header.jsp" %>
<body>
    <section class="">
        <div class="container px-5 my-5 ">           
            <div class="row gx-5">
                <div class="col-12 text-center">
                <c:choose>
               <c:when test="${empty product.nftUrl}">
					<img class="img-fluid rounded-3 mb-5" src="images/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img class="img-fluid rounded-3 mb-5" src="upload/${product.nftUrl}">
				</c:otherwise>
				</c:choose>	
                </div>
            </div>
        </div>
    </section>
    <!-- 상품 설명 2칸-->
    <section class="py-5" id="features">
        <div class="container px-5 my-5">
            <div class="row gx-5">

                <div class="col-lg-12">
                    <div class="row gx-4 row-cols-1 row-cols-md-2 px-lg-4">
                        <div class="col mb-5 h-100">

                            <div class="col-lg-10 mb-5 mb-lg-0">
                                <div><h4 class="fw-bolder">상품명 : ${product.p_name}</h4></div>
                                <div class="mb-4">
                                <p class="mb-1">상품설명</p>
                                ${product.description}
                                </div>
                            </div>
                            
                            <div class="">
                            <h2 class="h5 mb-1">판매 정보</h2>
                                <div>
                                    <div>
                                        판매자 : ${product.creator}
                                        <br>
                                        지금 보시는 상품은 #${product.edition} 입니다.
                                        <a class="text-decoration-none" href="#!">
                    						${product.creator}의 에디션 더보기<i class="bi-arrow-right"></i>
               							</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col mb-5 h-100">
                            <div class="h5">
                                판매가 : ${product.price} ETH
                            </div>

                            <div class="d-flex float-md-end">
                                <div>
                                <a class="btn btn-outline-dark flex-shrink-0" href="addCart.do?userid=${loginUser.userid}&creator=${product.creator}&unique_no=${product.unique_no}&p_name=${product.p_name}&price=${product.price}&nftUrl=${product.nftUrl}">
                                <i class="bi-cart-fill me-1"></i>장바구니
                                </a>
                                </div>
                                <div>
                                <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                    구매하기
                                </button>
								</div>
                            </div>
                        </div>
                        <div class="col mb-5 mb-md-0 h-100">
                            <h2 class="h5 mb-2">NFT 정보</h2>
                            <div>
                                <div>
                                    <div>
                                        <div class="mb-1">소유자: ${product.owner}
                                            
                                        </div>
                                    </div>
                                    <div>
                                        <div class="">NFT 등록 날짜: ${product.reg_date}
                                            
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="col h-100">
                            <h2 class="h5">가격제안 현황</h2>
                            <div>
                                <table class="table">
									<tr>
										<p class="small form-text">제안된 가격이 아직 없습니다. 구매 가격을 직접 제안해보세요.</p>
									</tr>
                                    <tr>
                                    	<td class="small">제안시간</td>
                                    	<td class="small">제안가격</td>
                                    </tr>
                                    <tr>
                                        <!-- 첫번째 줄 시작 -->
                                        <td>첫번째 칸</td>
                                        <td>두번째 칸</td>
                                    </tr><!-- 첫번째 줄 끝 -->
                                    <tr>
                                        <!-- 두번째 줄 시작 -->
                                        <td>첫번째 칸</td>
                                        <td>두번째 칸</td>
                                    </tr><!-- 두번째 줄 끝 -->
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 거래 체결/제시 2칸-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="row gx-4 gx-lg-5 align-items-center">
                <div class="col-md-6">
                    <div class="fs-6 mb-6">
                        <h6 class="fw-bolder">최근 거래 체결가</h6>
                        <table class="table">
                        	<tr>
								<p class="small form-text">최근 거래가 없습니다.</p>
							</tr>
                            <th class="small">거래일시</th>
                            <th class="small">에디션</th>
                            <th class="small">체결가</th>
                            <tr>
                                <!-- 첫번째 줄 시작 -->
                                <td>첫번째 칸</td>
                                <td>두번째 칸</td>
                                <td>세번째 칸</td>
                            </tr><!-- 첫번째 줄 끝 -->
                            <tr>
                                <!-- 두번째 줄 시작 -->
                                <td>첫번째 칸</td>
                                <td>두번째 칸</td>
                                <td>세번째 칸</td>
                            </tr><!-- 두번째 줄 끝 -->
                        </table>
                    </div>
                </div>

                <div class="py-5 col-md-6">
                    <div class="fs-6 mb-6">
                        <h6 class="fw-bolder"><input value="에디션">거래 이력 </h6>
                        <table class="table">
                            <tr>
								<p class="small form-text">거래 이력이 없습니다.</p>
							</tr>
                            <th class="small">거래일시</th>
                            <th class="small">마켓</th>
                            <th class="small">판매자</th>
                            <th class="small">소유자</th>
                            <th class="small">금액</th>
                            <tr>
                                <!-- 첫번째 줄 시작 -->
                                <td>첫번째 칸</td>
                                <td>두번째 칸</td>
                                <td>세번째 칸</td>
                                <td>네번째 칸</td>
                                <td>다섯번째 칸</td>
                            </tr><!-- 첫번째 줄 끝 -->
                            <tr>
                                <!-- 두번째 줄 시작 -->
                                <td>첫번째 칸</td>
                                <td>두번째 칸</td>
                                <td>세번째 칸</td>
                                <td>네번째 칸</td>
                                <td>다섯번째 칸</td>
                            </tr><!-- 두번째 줄 끝 -->
                        </table>
                        <table></table>
                    </div>
                </div>
            </div>

        </div>
    </section>
  <!--유의사항-->
    <div class="row gx-5 justify-content-center">
        <div class="col-lg-10">
            <div class="mb-5">
                <p class="lead fw-normal text-muted">Marketplace 유의사항</p>
                <p class="text-muted">
                    - 구매는 업비트 계좌 내 이더리움(ETH)이 차감되는 방식으로 진행됩니다.
                    <br>- 구매 거래가 체결되면 거래 취소가 불가하므로 신중하게 결정하여 진행해주세요.
                    <br>- 구매 가격 제안은 제안 시점으로부터 3일간 유효합니다. 제안 기간이 만료되면 해당 제안은 자동 취소됩니다.
                    <br>- 구매 가격 제안이 완료되면 해당 금액은 업비트 내 거래 가능 금액에서 제외됩니다.
                    <br>- 판매자가 가격 제안을 수락하면, 업비트 계좌 내 계좌에서 이더리움(ETH)이 차감되어 거래가 체결될 수 있습니다.
                    <br>- 구매 가격 제안 취소는 거래가 체결되기 이전까지 'My NFT(마이NFT) > Price Offer(가격제안)' 메뉴에서 하실 수 있습니다.
                    <br>- NFT의 외부 입출금은 현재 지원하지 않습니다. (추후 지원 예정)
                    <br>- 해당 NFT에 연계된 디지털상품 관련 분쟁 (지식재산권 분쟁 포함)이 발생한 경우 해당 NFT에 대한 거래지원이 종료될 수 있습니다.
                    <br>- NFT 소유자는 NFT와 연계된 “디지털 저작물“을 비상업적인 용도로 사용(개인 SNS 내 업로드하는 행위 및 디지털 저작물 원본 그대로 개인적 용도로 사용하는 행위)할
                    수 있는 권리와 NFT 입출금, 거래 등이 지원되는 경우 지원되는 방식에 따라 NFT의 소유권을 타인에게 이전할 수 있는 권리를 갖습니다.</p>
            </div>
        </div>
    </div>


<!--  연관된 다른 아이템들 누를수 있도록 4개 상품 -->
    <section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">Creator 관련상품</h2>
            
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start">
         	
         <c:forEach var="productList" items="${productList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->                    
                <a style="color: inherit; text-decoration: none;" href="productDetail.do?unique_no=${productList.unique_no}">
                <c:choose>
				<c:when test="${empty productList.nftUrl}">
					<img class="card-img-top" src="images/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img class="card-img-top" src="upload/${productList.nftUrl}">
				</c:otherwise>
				</c:choose>
				</a>
                        <!-- Product details-->
                        <div class="card-body p-4">
							<div class="text-center">
							<a style="color: inherit; text-decoration: none;" href="productDetail.do?unique_no=${productList.unique_no}">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${productList.p_name}</h5>
                                <!-- Product price-->
                                ${productList.price} 
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

        <!--???????슬라이드 기능? 어캐구현함..-->
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




<%--    <!-- 다른 관련 카테고리 이동 할수있도록??-->
        <!-- Categories widget-->
        <div class="card mb-4">
            <div class="card-header">Categories</div>
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-6">
                        <ul class="list-unstyled mb-0">
                            <li><a href="#!">Web Design</a></li>
                            <li><a href="#!">HTML</a></li>
                            <li><a href="#!">Freebies</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6">
                        <ul class="list-unstyled mb-0">
                            <li><a href="#!">JavaScript</a></li>
                            <li><a href="#!">CSS</a></li>
                            <li><a href="#!">Tutorials</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!--SNS 업로드 기능이나...문의 할수있도록??...-->
    <!--SNS-->
    <div class="col-xl-4">
        <div class="card border-0 bg-light mt-xl-5">
            <div class="card-body p-4 py-lg-5">
                <div class="d-flex align-items-center justify-content-center">
                    <div class="text-center">
                        <div class="h6 fw-bolder">Have more questions?</div>
                        <p class="text-muted mb-4">
                            Contact us at
                            <br />
                            <a href="#!">support@domain.com</a>
                        </p>
                        <div class="h6 fw-bolder">Follow us</div>
                        <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-twitter"></i></a>
                        <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-facebook"></i></a>
                        <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-linkedin"></i></a>
                        <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-youtube"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div> --%>

</body>
<%@ include file="../footer.jsp" %>
</html>