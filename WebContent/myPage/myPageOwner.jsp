<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- css 이름을 변경해주세요. -->
    <link rel="stylesheet" href="css/myPage_base.css">
    <title>마이페이지</title>

</head>
<%@ include file="../header.jsp" %>
<body>
    <div class="div-userinfo">
        <div>
            <h2 id="title-mypage">MyPage</h2>
        </div>
        <div class="div-icon-Content">
            <div class="icon-area">
                <img src="images/userIcon.png" alt="not found" id="userIcon">
            </div>
            <div class="description-area">
                <div>
                    <strong>${loginUser.name}</strong>
                    <a href="updateMember.do">정보변경</a>
                </div>
                <br>
                <br>
                <div class="artwortk-area">
                    등록 작품 : <a href="">${createArtwork}</a> 개
                </div>
                <br>
                <div class="artwortk-area">
                    구매 작품 : <a href="">${purchaseArtwork}</a> 개
                </div>
                <br>
                <div class="artwortk-area">
                    판매 작품 : <a href="">${saleArtwork}</a> 개
                </div>
            </div>
            <div class="community-area">
                <div>
                    <div><img src="images/post.png" alt="not found" class="community-icons"></div>
                    <div>작성글</div>
                    <div>${comPost}</div>
                </div>
                <div>
                    <div><img src="images/comment.png" alt="not found" class="community-icons"></div>
                    <div>댓글</div>
                    <div>${comment}</div>
                </div>
                <div>
                    <div><img src="images/like.png" alt="not found" class="community-icons"></div>
                    <div>좋아요</div>
                    <div>${like}</div>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <div class="div-nav-Content">
        <div class="navbar-area">
            <!-- 모든 myPage의 목록은 동일해야합니다. -->
            <h2 class="navbar-items" id="title-navbar">나의 NFT 컬렉션</h2>
            <a class="navbar-items" href="">개인정보</a>
            <a class="navbar-items" href="creatorProduct.do?creator=${loginUser.userid}">나의NFT</a>
            <a class="navbar-items" href="ownerProduct.do?owner=${loginUser.userid}">판매NFT</a>
            <a class="navbar-items" href="cartList.do?userid=${loginUser.userid}">장바구니</a>
            <a class="navbar-items" href="">즐겨찾기</a>
            <a class="navbar-items" href="">최근 본 상품</a>
            <a class="navbar-items" href="">1:1문의</a>
            <a class="navbar-items" href="">게시글</a>
            <a class="navbar-items" href="">댓글</a>
        </div>
        <div class="content-area">
            
            <div class="content-title-list">
                    <h2>판매 NFT</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>상품</th>
                            <th>상품명</th>
                            <th>금액</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>등록날짜</th>
                            <th>판매등록</th>
                        </tr>

                 <c:forEach var="List" items="${List}">  
                        <tr>
                            <td><img src="upload/${List.nftUrl}" width="60"></td>
                            <td>${List.p_name}</td>
                            <td>${List.price}</td>
                            <td>${List.unique_no}</td>
                            <td>${List.creator}</td>
                            <td>${List.reg_date}</td>
                            <td><a href="#">판매등록</a></td>
                        </tr>
                 </c:forEach>

                    </table>
                </form>
            </div>
            
            
    </div>    
</body>

<%@ include file="../footer.jsp" %>
</html>