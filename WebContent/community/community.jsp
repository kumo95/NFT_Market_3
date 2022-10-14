<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>커뮤니티</title>
    <link rel="stylesheet" href="community/community.css"/>
</head>
<body>
    <div class="container">

        <div class="title">커뮤니티 (자유게시판)</div>

        <div class="search_right">
            <form action="searchProduct.do">
                <!-- <select name="column">
                    <option ${(param.column=="title")?"selected":""} value="code">제목</option>
                    <option ${(param.column=="userid")?"selected":""} value="userid">아이디</option>
                </select>
                <div class="search">
                    <input class="search_input" type="text"  name="keyword" value="${param.keyword}" placeholder="검색어 입력">
                    <a href="submit"><img class="search_img" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></a>
                </div> -->
            </form>
        </div>


        <table class="board_list">
            <colgroup>
                <col width="15%"/>
                <col width="*"/>
                <col width="15%"/>
                <col width="15%"/>
                <col width="15%"/>
            </colgroup>
            <thead>
                <tr>
                    <th scope="col">글번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">아이디</th>
                    <th scope="col">조회수</th>
                    <th scope="col">작성일</th>
                </tr>
            </thead>
            <tbody>
                <!-- <tr th:if="${#lists.size(list)} > 0" th:each="list : ${list}">
                    <td th:text="${list.boardIdx}"></td>
                    <td class="title" th:text="${list.title}"></td>
                    <td th:text="${#temporals.format(list.createdDatetime, 
                        'yyyy-MM-dd HH:mm::ss')}"></td>
                </tr> 
                <tr th:unless="${#lists.size(list)} > 0">
                    <td colspan="5">조회된 결과가 없습니다.</td>
                </tr>  -->
            </tbody>
        </table>
        <a href="/board/openBoardWrite.do" class="btn">글 쓰기</a>

        <div class="paging">
            <a href="#" class="bt first">처음 페이지</a> 
            <a href="#" class="bt prev">이전 페이지</a> 
                <a href="#" class="num on">1</a> 
                <a href="#" class="num">2</a> 
                <a href="#" class="num">3</a> 
                <a href="#" class="bt next">다음 페이지</a> 
                <a href="#" class="bt last">마지막 페이지</a>
            </div>
    </div>
</body>
</html>
