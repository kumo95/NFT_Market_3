<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage_main.css">
<title>마이페이지</title>
</head>
<body>
    <div>
        <h1 style="text-align: center;">헤더</h1>
    </div>
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
                    <strong>userName</strong>
                    <a href="">회원정보변경</a>
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
            <a class="navbar-items" href="">나의NFT</a>
            <a class="navbar-items" href="">판매NFT</a>
            <a class="navbar-items" href="">장바구니</a>
            <a class="navbar-items" href="">즐겨찾기</a>
            <a class="navbar-items" href="">최근 본 상품</a>
            <a class="navbar-items" href="">1:1문의</a>
            <a class="navbar-items" href="">게시글</a>
            <a class="navbar-items" href="">댓글</a>
        </div>
        <div class="content-area">
            <div>
                <div class="content-title-list">
                    <h2>나의 NFT</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>상품</th>
                            <th>NFT 넘버</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>소유자</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>nftNum</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="등록"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>nftNum</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="등록"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>nftNum</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="등록"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>nftNum</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="등록"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>판매 NFT</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>상품</th>
                            <th>금액</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>소유자</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="수정"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="수정"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="수정"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="수정"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>장바구니</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table" id="cart-table">
                        <tr>
                            <th class="checkbox-area"><input type="checkbox"></th>
                            <th>상품</th>
                            <th>금액</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>소유자</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                    </table>
                    <div id="cart-button">
                        <input type="button" value="선택삭제" name="">
                        <input type="submit" value="결제하기" name="">
                    </div>
                    <br>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>즐겨찾기</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th class="checkbox-area"><input type="checkbox"></th>
                            <th>상품</th>
                            <th>금액</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>소유자</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td class="checkbox-area"><input type="checkbox"></td>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>최근 본 상품</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>상품</th>
                            <th>금액</th>
                            <th>고유번호</th>
                            <th>창조자</th>
                            <th>소유자</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="구매"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="구매"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="구매"></td>
                        </tr>
                        <tr>
                            <td>productName</td>
                            <td>price</td>
                            <td>serialNum</td>
                            <td>maker</td>
                            <td>owner</td>
                            <td><input type="button" value="구매"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>1:1 문의</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>등록일자</th>
                            <th>문의제목</th>
                            <th>상태</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>환불은 가능한가요?</td>
                            <td>답변완료</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>비밀번호 변경이 실패해요.</td>
                            <td>답변완료</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>게시글이 사라졌어요.</td>
                            <td>답변완료</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>우리집 강아지는 복슬강아지~ 학교갔다 돌아오면 멍멍멍</td>
                            <td>답변완료</td>
                            <td><input type="button" value="삭제"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>게시글</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>등록일자</th>
                            <th>게시글명</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>post 1</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>post 2</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>post 3</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>post 4</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <div class="content-title-list">
                    <h2>댓글</h2>
                    <a href="">상세페이지</a>
                </div>
                <form>
                    <table class="mypage-table">
                        <tr>
                            <th>등록일자</th>
                            <th>댓글내용</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>무플방지4</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>무플방지3</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>무플방지2</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                        <tr>
                            <td>2022-01-01</td>
                            <td>무플방지1</td>
                            <td><input type="button" value="수정"> /
                                <input type="button" value="삭제"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <hr>
    <div>
        <h1 style="text-align: center;">푸터</h1>
    </div>

</body>
</html>