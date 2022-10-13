<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>커뮤니티 글 쓰기</title>
    <link rel="stylesheet" th:href="@{/css/style.css}" href="community_writing.css"></link>
</head>
<body>
    
    <div class="container">
        <form id="frm" name="frm" method="post" action="/board/insertBoard.do">
            <div>커뮤니티에 등록할 글을 작성해주세요.</div>
            
            <table class="board_detail">
                <tr>
                    <td><input type="text" id="title" name="title" placeholder="제목을 입력해주세요"></td>
                </tr>
                <tr>
                    <td><input type="file" name="SelectFile"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea rows="10" cols="100" id="contents" name="contents"  placeholder="내용을 입력해주세요"></textarea>
                    </td>
                </tr>
            </table>
            <input type="submit" id="submit" value="등록하기" class="btn">
        </form>
    </div>
</body>
</html>