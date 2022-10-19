<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원들이 보는 QnA 리스트</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[1대1문의 목록]</small></h4>

<!-- 게시판 검색 기능 구현 -->
	<%-- <div class="search">
		<form action="../qnaList.do">
				<select name="column">
					<option ${(param.column=="bno")?"selected":""} value="bno">번호</option>
					<option ${(param.column=="title")?"selected":""} value="title">제목</option>
					<option ${(param.column=="content")?"selected":""} value="content">내용</option>
				</select> 
				<input type="text" name="keyword" value="${param.keyword}"> 
				<input type="submit" value="검색">
		</form>
	</div> --%>

<div>	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>파일</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<!-- 게시글 목록 출력 -->
		<c:forEach var="qna" items="${qnaList}">
			<tr>
				<td>${qna.bno}</td>
				<td><a href="qna?bno=${qna.bno}">${qna.title}</a></td>
				<td>${qna.content}</td>
				<td>${qna.files}</td>
				<td>${qna.count}</td>
				<td>${qna.writeDate}</td>
			</tr>
		</c:forEach>
	
			<%-- <c:set var="page" value="${(param.p)?1:param.p}"></c:set>
			<c:set var="startNum" value="${page-(page-1)%5}"></c:set> 
			<c:set var="lastNum" value="${Math.cell(count/10)}"></c:set>
			<c:set var="lastNum" value="${fn:substringBefore(Math.cell(count/10), '.')}"></c:set>
					<div>게시물 수 : ${count}</div>
					<div>페이지 번호 : ${page}</div>
					<div>페이지 시작번호 : ${startNum}</div>
					<div>전체 페이지 끝 번호 : ${lastNum}</div> 
				<!--이전 페이지 링크를 생성하는 경우 : (시작번호-1) 값이 0보다 커야함  -->
				<c:if test="${startNum-1>0}">
					<a href="?p=${startNum-1}">이전</a>
				</c:if> 
				<!--이전 페이지 링크를 생성하는 경우 : (시작번호-1) 값이 0보다 작거나 같아야함  -->
				<c:if test="${startNum-1<=0}">
					<a href="?p=${startNum-1}"> 
					<span onclick="alert('이전 페이지가 없습니다.');">이전</span></a>
				</c:if> 
				
				<c:forEach var="i" begin="0" end="4">
					<!-- 마지막 게시물이 있는 페이지까지만 표시 -->
					<c:if test="${(i+startNum) <= lastNum}">
					 	<!-- 해당 페이지인 경우, 스타일(컬러) 지정 -->
						<a style="color:${(page==(i+startNum))?'orange':''}" 
							href="?p=${i+startNum}&column=${param.column}&keyword=${param.keyword}">${i+startNum}
							${i+lastNum}
						</a>
					</c:if>
				</c:forEach> 
				
				
				<c:if test="${startNum+4} < lastNum">
					<a href="?p=${startNum+5}">다음</a>
				</c:if> 
				<!-- 다음 페이지 링크를 생성하지 못하는 경우 : (시작번호+4) 값이 마지막 숫자보다 커야함 -->
				<c:if test="${startNum+4} >= lastNum">
					 <span onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>	 --%>
	</table>
</div>
</body>
</html>