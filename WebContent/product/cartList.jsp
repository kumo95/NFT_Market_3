<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>장바구니</title>
	<link rel="stylesheet" type="text/css" href="css/cart.css" />
	<script type="text/javascript" src="js/cart.js"></script>  
</head>

<%@ include file="../header.jsp" %>

<body>
<div class="container">
    <div class="cart">
    <form name="orderform" id="orderform" method="post" class="orderform"  onsubmit="return false;">
        <div class="right-align basketrowcmd">
            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a>
            <a href="removeAllCart.do?userid=${loginUser.userid}" class="abutton" onclick="javascript:basket.delAllItem();">장바구니비우기</a>
        </div>
		
		<div class="bigtext left-align sumcount buttongroup">${loginUser.userid} 장바구니</div>
        <div class="bigtext left-align sumcount" id="sum_p_num">상품갯수: ${size}개</div>
        <!-- <div class="bigtext left-align box blue summoney" id="sum_p_price">합계금액: </div> -->
    
            <input type="hidden" name="cmd" value="order">
            <div class="basketdiv" id="basket">
                <div class="row head">
                    <div class="subdiv">
                        <div class="check">선택</div>
                        <div class="img">상품</div>
                        <div class="pname">상품명</div>
                    </div>
                    <div class="subdiv">
                        <div class="num"></div>
                        <div class="basketprice">가격</div>
                        <div class="sum"></div>
                    </div> 
                    <div class="subdiv">
                        <div class="basketcmd">삭제</div>
                    </div>
                    <div class="split"></div>
                </div>
                
			<c:forEach var="cartList" items="${cartList}">        
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="260" checked onclick="javascript:basket.checkItem();">&nbsp;</div>
                        <div class="img" ><img src="upload/${cartList.nftUrl}" width="130"></div>
                        <div class="pname">
                        	<a style="color: inherit; text-decoration: none;" href="productDetail.do?unique_no=${cartList.unique_no}">
                            ${cartList.p_name}
                            </a>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="num"><!--<input type="text" class="p_num" value="">--></div>
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="${cartList.price}">${cartList.price}</div>
                        <div class="sum"></div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="removeCart.do?unique_no=${cartList.unique_no}&userid=${cartList.userid}" class="abutton">삭제</a></div>
                    </div>  
                </div>
			</c:forEach> 
            </div>

            <div>
                <div class="cart_information">
                    장바구니 상품은 최대 30일간 저장됩니다.
                    <br><br>장바구니에는 최대 100개의 상품을 보관할 수 있습니다.
                    <br><br>가격, 수량 정보가 변경된 경우 주문이 불가할 수 있습니다.
                </div>
            </div>
            <div id="goorder" class="">
                <div class="buttongroup center-align cmd">
                    <a href="productList.do">다른 NFT상품 보러가기</a>
                    <a href="javascript:void(0);">선택한 상품 주문</a>
                </div>
            </div>
        </form>
        </div>
      </div>
</body>

<%@ include file="../footer.jsp" %>
</html>