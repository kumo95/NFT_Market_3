<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세보기</title>
<link rel="stylesheet" type="text/css" href="qna/style.css">

<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[QnA 삭제 상세 페이지]</small></h4>
<table border="1">
	<tr>
		<td style="width: 310px">
			<c:choose>
				<c:when test="${empty qna.files}">
					<img src="image/noimage.jpg">
				</c:when>	
				<c:otherwise>
					<img src="upload/${qna.files}">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
		<table>		
			<tr>
				<td>번호</td>
				<td>${qna.bno}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${qna.userid}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${qna.title}</td>		
			</tr>
			<tr>
				<td>내용</td>
				<td>${qna.content}</td>		
			</tr>
			<tr>
				<td>파일</td>
				<td>${qna.files}</td>		
			</tr>
			<tr>
				<td>조회수</td>
				<td>${qna.count}</td>		
			</tr>
			<tr>
				<td>작성일</td>
				<td>${qna.wireDate}</td>		
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<a href='FileDownloadAction.bo?file_name=${qna.files}'>${qna.files}</a>
				</td>	
			</tr>
		</table>
		<input type="button" value="목록" onclick="location.href='../qnaAdminList.do'">
</table>	
</body>

</body>
</html>