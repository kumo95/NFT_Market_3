<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="">
	<div class="py-5">
        <div class="container px-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-xxl-6">
                    <div class="text-center my-5">
                        <h1 class="fw-bolder mb-3">나만의 NFT를 만들어 드립니다.</h1>
                        <p class="lead fw-normal text-muted mb-4">파일을 업로드하고 배경을 선택해보세요.</p>
                        <a class="btn btn-primary btn-lg"><input type="file" name="SelectFile"></a>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<div class="">
        <div class="container px-5">
            <div class="row gx-5">
                <div class="col-lg-6">
                    수정 전
                    <img class="img-fluid rounded-3 mb-5" src="https://dummyimage.com/600x400/343a40/6c757d"
                        alt="..." />
                </div>
                <div class="col-lg-6">
                    수정 후
                    <img class="img-fluid rounded-3 mb-5" src="https://dummyimage.com/600x400/343a40/6c757d"
                        alt="..." />
                </div>
            </div>
        </div>
    </div>
    <!-- Pricing section-->
    <div class="bg-light">
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
                            <div class="small text-uppercase fw-bold text-muted">color</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                    <h5 class="fw-bolder">우주</h5>
                                    <div class="fst-italic text-muted">우주배경</div>
                                </div>
                            </div>
                            <div class="d-grid"><a class="btn btn-outline-primary" href="#!">선택하기</a></div>
                        </div>
                    </div>
                </div>

                <!-- 2-->
                <div class="col-lg-6 col-xl-4">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-5">
                            <div class="small text-uppercase fw-bold text-muted">color</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                    <h5 class="fw-bolder">GREEN</h5>
                                    <div class="fst-italic text-muted">자연</div>
                                </div>
                            </div>
                            <div class="d-grid"><a class="btn btn-primary" href="#!">선택하기</a></div>
                        </div>
                    </div>
                </div>

                <!--3 -->
                <div class="col-lg-6 col-xl-4">
                    <div class="card">
                        <div class="card-body p-5">
                            <div class="small text-uppercase fw-bold text-muted">color</div>
                            <div class="col mb-5 mb-5 mb-xl-0">
                                <div class="text-center">
                                    <img class="img-fluid rounded-circle mb-4 px-4"
                                        src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                    <h5 class="fw-bolder">네온사인</h5>
                                    <div class="fst-italic text-muted">네온사인 배경</div>
                                </div>
                            </div>

                            <div class="d-grid"><a class="btn btn-outline-primary" href="#!">선택하기</a></div>
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
                                <a class="btn btn-primary btn-lg" href="#scroll-target">등록하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>