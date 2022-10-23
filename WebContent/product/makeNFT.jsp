<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품제작</title>

    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link type="text/css" href="css/makeNFT.css" rel="stylesheet" />
    <link rel="stylesheet" href="">
</head>

<body>
    <div class="py-5">
        <div class="container px-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-xxl-6">
                    <div class="text-center my-5">
                        <h1 class="fw-bolder mb-3">나만의 NFT를 만들어 드립니다.</h1>
                        <p class="lead fw-normal text-muted mb-4">파일을 업로드하고 배경을 선택해보세요.</p>
                        <a class="btn btn-primary btn-lg" href="makeFile.do">
                        	파일업로드
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class="">
        <div class="container px-5">
            <div class="row gx-5">
                <div class="col-lg-6 text-center">
                    수정 전             
                    <div>
                     	<c:choose>
               				<c:when test="${empty nftUrl}">
							<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="images/noimage.jpg">
							</c:when>
							<c:otherwise>
							<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="upload/${nftUrl}">
							</c:otherwise>
						</c:choose>	
                    </div>
                </div>
                <div class="col-lg-6 text-center">
                    수정 후

                    <div>
                    
                    <c:choose>
               				<c:when test="${empty newNftUrl}">
							<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="images/noimage.jpg">
							</c:when>
							<c:otherwise>
							<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="upload/${newNftUrl}">
							</c:otherwise>
						</c:choose>
                    
<%--                     	<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="upload/noimage.png" alt="파일 업로드 후 배경 선택하기 버튼을 눌러주세요">
                		<img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="upload/${nftUrl1}"> --%>
                		<!-- <img class="img-fluid rounded-3 mx-4 my-4 px-1 py-1" style="background-color: skyblue;" src="upload/combinedImage.png" alt="파일 업로드 후 배경 선택하기 버튼을 눌러주세요"> -->
                	</div>

                </div>
            </div>
        </div>
    </section>

    <!-- Pricing section-->
    <section class="bg-light">
        <div class="container px-5">
            <div class="text-center mb-5">
                <h4 class="fw-bolder">배경 선택</h4>
                <p class="lead fw-normal text-muted mb-0">선택한 배경을 해당 NFT에 적용합니다.</p>
            </div>
            <div class="row gx-5 justify-content-center">
                <!-- 1-->
                <div class="col-lg-6 col-xl-4">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-5">
                            <div class="small text-uppercase fw-bold text-muted">~10/31일까지</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="upload/1.PNG" alt="..." />
                                    <h5 class="fw-bolder">할로윈 친구들</h5>
                                    <div class="fst-italic text-muted"></div>
                                </div>
                            </div>
                            <div class="d-grid"><a class="btn btn-outline-primary" href="makeBackground.do?nftUrl=${nftUrl}&select=1">선택하기</a></div>
                        </div>
                    </div>
                </div>

                <!-- 2-->
                <div class="col-lg-6 col-xl-4">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-5">
                            <div class="small text-uppercase fw-bold text-muted">~12/25일까지</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="upload/2.PNG" alt="..." />
                                    <h5 class="fw-bolder">크리스마스 트리</h5>
                                    <div class="fst-italic text-muted"></div>
                                </div>
                            </div>
                            <div class="d-grid"><a class="btn btn-primary" href="makeBackground.do?nftUrl=${nftUrl}&select=2">선택하기</a></div>
                        </div>
                    </div>
                </div>

                <!--3 -->
                <div class="col-lg-6 col-xl-4">
                    <div class="card">
                        <div class="card-body p-5">
                            <div class="small text-uppercase fw-bold text-muted">*</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="upload/3.PNG" alt="..." />
                                    <h5 class="fw-bolder">네온사인</h5>
                                    <div class="fst-italic text-muted"></div>
                                </div>
                            </div>

                            <div class="d-grid"><a class="btn btn-outline-primary" href="makeBackground.do?nftUrl=${nftUrl}&select=3">선택하기</a></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="">
                <div class="container px-5">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-xxl-6">
                            <div class="text-center my-5">
                                <p class="lead fw-normal text-muted mb-4">등록하기 버튼을 눌러주세요</p>
                                <a class="btn btn-primary btn-lg" href="makeNewNftUrl.do?newNftUrl=${newNftUrl}">등록하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>
</html>