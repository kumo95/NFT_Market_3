<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세보기</title>
<style type="text/css">
		#wrap {
			width: 800px;
			margin: 0 auto 0 auto;
		}
	
		#detailQna{
			text-align :center;
		}
		
		#title{
			height : 16;
			font-size : 12;
			text-align :center;
		}
	</style>
	
<!-- 	<script type="text/javascript">
		function changeView(value)
		{
			if(value == 0)	
				location.href="BoardListAction.bo?page=${pageNum}";
			else if(value == 1)
				location.href='BoardReplyFormAction.bo?num=${board.board_num}&page=${pageNum}';
		}
		
		function doAction(value)
		{
			if(value == 0) alert("수정버튼 클릭"); // 수정
			else if(value == 1) // 삭제
				location.href="deleteQna.do?no=${qna.qna_no}";
		}
	</script> -->
</head>
<div id="wrap">
	<br><br>
	<div id="qna">
		<table id="detailQna" width="800" border="3" bordercolor="lightgray">		
			<tr>
				<td id="title">작성일</td>
				<td>${qna.qna_writeDate}</td>
			</tr>
			<tr>
				<td id="title">작성자</td>
				<td>${qna.qna_userid}</td>
			</tr>
			<tr>
				<td id="title">
					제 목
				</td>
				<td>
					${qna.qna_title}
				</td>		
			</tr>
			<tr>
				<td id="title">
					내 용
				</td>
				<td>
					${qna.qna_content}
				</td>		
			</tr>
			<tr>
				<td id="title">
					첨부파일
				</td>
				<td>
					<a href='FileDownloadAction.bo?file_name=${board.board_file}'>${board.board_file}</a>
				</td>	
			</tr>
	
			<tr align="center" valign="middle">
				<td colspan="5">
				<c:if test="${sessionScope.sessionID !=null}">
					<c:if test="${sessionScope.sessionID == board.board_id}">
						<input type="button" value="수정" onclick="doAction(0)">
						<input type="button" value="삭제" onclick="doAction(1)">
					</c:if>
						<input type="button" value="답글" onclick="changeView(1)" >
				</c:if>		
					<input type="button" value="목록" onclick="changeView(0)">			
				</td> <!-- javascript:location.href='BoardListAction.bo?page=${pageNum}' -->
			</tr>
		</table>
	</div>
</div>	
<body>

</body>
</html>