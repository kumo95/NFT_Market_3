<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>고객센터 메인</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" type="text/css" href="csMain.css">
</head>
<body>
<jsp:include page="/index/header.jsp"/>

	<!-- Icons Grid-->
	<section class="features-icons bg-light text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<div class="features-icons-item mx-auto mb-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="bi-window m-auto text-primary"></i>
						</div>
						<h3>NOTICE</h3>
						<p class="lead mb-0">공지사항을 확인하세요.</p>
						<div>
							<button type="button" onclick="location='../noticeListMember.do'">공지사항</button>
						</div>
					</div>
				</div>
				
				<div class="col-lg-7">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="bi-layers m-auto text-primary"></i>
						</div>
						<h3>QnA</h3>
						<p class="lead mb-0">1대1 문의를 해보세요.</p>
						<div>
							<button type="button" onclick="location='../qnaWrite.do'">QnA 작성</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	 <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="csMain.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>