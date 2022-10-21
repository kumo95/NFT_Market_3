<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>회원들이 보는 공지사항 목록</title>
<link rel="stylesheet" type="text/css" href="../index/css/header.css">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h4 align="center"><small>[공지사항 목록]</small></h4>
	<table class="table table-hover">
			<thead class="thead-light">	
				<tr>
					<th class="text-center" style="width:10%">번호</th>
					<th class="text-center" style="width:10%">제목</th>
					<th class="text-center" style="width:10%">내용</th>
					<th class="text-center" style="width:10%">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeList}">
					<tr>
						<td class="text-center" style="width:10%">${notice.no}</td>
						<td class="text-center" style="width:10%">${notice.title}</td>
						<td class="text-center" style="width:10%">${notice.content}</td>
						<td class="text-center" style="width:10%">${notice.writeDate}</td>
				</c:forEach>
			</tbody>
	</table>
<jsp:include page="../footer.jsp"/>	
</body>
</html>