<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="qna/style.css">
<title>관리자 1대1문의 목록</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[관리자 1대1문의 목록]</small></h4>
<!-- 게시판 검색 기능 구현 -->
	<%-- <div class="search">
		<form action="qnaList.do">
				<select name="column">
					<option ${(param.column=="bno")?"selected":""} value="bno">번호</option>
					<option ${(param.column=="title")?"selected":""} value="title">제목</option>
					<option ${(param.column=="content")?"selected":""} value="content">내용</option>
				</select> 
				<input type="text" name="keyword" value="${param.keyword}"> 
				<input type="submit" value="검색">
		</form>
	</div> --%>

<!-- 게시판 리스트 기능 구현 -->
	<table class="list">	
		<thead class="thead-dark">
			<tr>
				<th class="table-primary">번호</th>
				<th scope="col">작성자</th>
				<th scope="col">제목</th>
				<th scope="col">내용</th>
				<th scope="col">파일</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
				<th scope="col">관리</th>
				<th scope="col">답변</th>
			</tr>	
		</thead>	
		<%-- 	<c:if test="${empty qnaList or qnaList.size()==0 }" >
               <tr>
                  <td colspan="6" class="text-center"> 작성된 글이 없습니다.</td>
               </tr>
             </c:if>  --%>
		<!-- 게시글 목록 출력 -->
		<tbody>
			<c:forEach var="qna" items="${qnaList}">
				<tr>
					<td>${qna.bno}</td>
					<td>${qna.userid}</td>
					<td><a href="qna?bno=${qna.bno}">${qna.title}</a></td>
					<td>${qna.content}</td>
					<td><a href="qna?bno=${qna.bno}">${qna.files}</a></td>
					<td>${qna.count}</td>
					<td>${qna.writeDate}</td>
					<td><a href="deleteQna.do?bno=${qna.bno}">삭제</a></td>
					<td><a href="qnaReWrite.do?bno=${qna.bno}">답변</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<%-- <tr>
			<td>
				<c:set var="page" value="${(param.p)?1:param.p}"></c:set> 
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
				</c:if>
			</td>
		</tr> --%>
		
	<br>
	
	<!-- 현재 페이지 / 총 페이지 -->
<%-- 	<table>
		<tr>
			<td style="border:white; text-align:right; padding-right:20px">
				<div><span>${(empty param.p)?1:param.p}</span>/${lastNum} pages</div>
			</td>
		</tr>
	</table> --%>

<!-- 페이지 기능 구현 -->
<!-- 페이징 : 디비에서 전페 페이지 수 조회-->
<!-- 페이지 번호 -->

<%-- <div>게시물 수 : ${count}</div>
<div>페이지 시작번호 : ${startNum}</div>  --%>

<!-- 끝 페이지 번호 : lastNum -->
<!-- lastNum = Math.cell(전체 게시물/한페이지당 게시물수) -->
<!-- count/5 = Math.cell(32/5) = 6.xx =7 -->

<!-- 게시물 수/ 페이지 번호 / 전체 페이지 끝번호 -->
<!-- 이전페이지, 다음페이지 링크 설정 -->

<%-- <c:set var="page" value="${(param.p)?1:param.p}"></c:set>
<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
<c:set var="lastNum" value="${Math.cell(count/10)}"></c:set>
<c:set var="lastNum" value="${fn:substringBefore(Math.cell(count/10), '.')}"></c:set>

<div>게시물 수 : ${count}</div>
<div>페이지 번호 : ${page}</div>
<div>페이지 시작번호 : ${startNum}</div>
<div>전체 페이지 끝 번호 : ${lastNum}</div>
 --%>
<!-- 이전페이지, 다음페이지 링크 설정 -->
<!-- 이전 페이지 링크를 생성하는 경우 : 시작번호-1 > 0  -->
<!-- 6 7 8 9 10 -->
<%-- <c:if test="${startNum-1>0}">
	<a href="?p=${startNum-1}">이전
	</a>
</c:if> --%>

<!-- 이전 페이지 링크를 생성하지 못하는 경우 : 시작번호-1 <= 0 -->
<!-- 1 2 3 4 5 -->
<%-- <c:if test="${startNum-1<=0}">
	<a href="?p=${startNum-1}">
		<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
	</a>
</c:if>

<c:forEach var="i" begin="0" end="4">
	<a href="?p=${i+startNum}&column=${param.column}&keyword=${param.keyword}">${i+startNum}</a>
</c:forEach>
 --%>
<!-- 1 6 11 16 -->
<%-- <c:if test="${startNum+4} < lastNum">
	<a href="?p=${startNum+5}">다음</a>
</c:if>
<c:if test="${startNum+4} >= lastNum">
	<a href="?p=${startNum+5}">
		<span onclick="alert('다음 페이지가 없습니다.');">다음</span>
	</a>
</c:if>

 --%>



<!-- ===================================================== -->
<!-- 페이지 수 -->
<!-- 시작번호 : startNum -->
<!-- 끝번호 : lastNum -->
<!-- startNum = page - (page-1) % page표시개수; -->
<%-- <c:set var="page" value="${param.p}"></c:set>
<c:set var="startNum" value="${page-(page-1)%5}"></c:set>


<!-- ===================================================== -->
<!-- 페이지 시작번호 : ?p=3 => 3-(3-1)%5 = 1 -->
<%-- <c:set var="page" value="${param.p}"></c:set>
<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
<!-- 처음 5개 페이지 링크 표시 -->
<c:forEach var="i" begin="0" end="4">
	<a href="?p=${i+startNum}">${i+startNum}</a>
</c:forEach>	
 --%>
<!-- ================================================== -->
<!-- 처음 5개 페이지 링크 표시 -->	
<%-- <c:forEach var="i" begin="0" end="4">
	<a href="?p=${i+1}">${i+1}</a>
</c:forEach> --%>
	
<!-- <a href="?=1">1</a>
<a href="?=2">2</a>
<a href="?=3">3</a>
<a href="?=4">4</a>
<a href="?=5">5</a> -->





</body>
</html>