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
<title>관리자 1대1문의 목록</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
	<h4 align="center"><small>[관리자 1대1문의 목록]</small></h4>
			<!-- 게시판 리스트 기능 구현 -->
		<table class="table table-hover">
			<thead class="thead-light">	
				<tr>
					<th class="text-center" style="width:10%">번호</th>
					<th class="text-center" style="width:10%">작성자</th>
					<th class="text-center" style="width:10%">제목</th>
					<th class="text-center" style="width:10%">내용</th>
					<th class="text-center" style="width:10%">작성일</th>
					<th class="text-center" style="width:10%">관리</th>
					<th class="text-center" style="width:10%">답변</th>
				</tr>
			</thead>
			<!-- 게시글 목록 출력 -->
			<tbody>
				<c:forEach var="qna" items="${qnaList}">
					<tr>
						<td class="text-center" style="width:10%">${qna.bno}</td>
						<td class="text-center" style="width:10%">${qna.userid}</td>
						<td class="text-center" style="width:10%">${qna.title}</td>
						<td class="text-center" style="width:10%">${qna.content}</td>
						<td class="text-center" style="width:10%">${qna.writeDate}</td>
						<td class="text-center" style="width:10%">
							<a href="deleteQna.do?bno=${qna.bno}">삭제</a>
						</td>
						<td class="text-center" style="width:10%">
							<a href="qnaReWrite.do?bno=${qna.bno}">답변</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>