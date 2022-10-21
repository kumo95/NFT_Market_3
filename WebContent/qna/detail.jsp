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
<title>QnA 상세</title>
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
<jsp:include page="../header.jsp"/>
<body>
	
	<h4 align="center"><small>[QnA 삭제 상세 페이지]</small></h4>
				<table class="table table-hover">
						<thead class="thead-light">
							<tr>
								<td>번호</td>
								<td>작성자</td>
								<td>제목</td>
								<td>내용</td>
								<td>작성일</td>		
							</tr>								
						</thead>
						<tbody>
							<tr>
								<td>${qna.bno}</td>
								<td>${qna.userid}</td>
								<td>${qna.title}</td>
								<td>${qna.content}</td>
								<td>${qna.wireDate}</td>	
							</tr>
						</tbody>	
							<tr>
								<td>
									<input type="button" value="목록" onclick="location.href='qnaAdminList.do'">
								</td>
							</tr>	
					</table> 	
<jsp:include page="../footer.jsp"/>
</body>

</body>
</html>