<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 페이지</title>
</head>
<body>
	<h2>1대1문의 답변글 작성</h2>
	<form action="../qnaReWrite.do" method="post">
		<!-- 답변글 처리 페이지로 자료를 전달 -->
		<table>
			<tr>
				<td>작성자</td>
				<td>관리자</td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="[답변]"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<!-- form에서 사용자로부터 입력 받지 않고 데이터를 넘김 -->
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소" >
					<input type="button" value="목록" onclick="location.href='qnaList.do'">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>