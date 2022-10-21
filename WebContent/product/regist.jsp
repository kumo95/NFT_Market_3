<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품등록</title>
<link rel="stylesheet" type="text/css" href="css/regist.css">
<script type="text/javascript" src="js/product.js"></script>
</head>
<%@ include file="../header.jsp"%>
<body>

	<form action="regist.do" method="post" enctype="multipart/form-data"
		name="frm">
		<div class="container">
			<div class="div1">
				<h1>NFT 상품 등록하기</h1>
			</div>
			<div>
				<div>
					<div>
						창조자 : <input type="text" name="creator"
							value="${loginUser.userid}">
					</div>
				</div>
				<div>
					<div>
						소유자 : <input type="text" name="owner" value="${loginUser.userid}">
					</div>
				</div>
<!-- 				<div>
					<div>
						유니크번호 : <input type="text" name="unique_no">
					</div>
				</div> -->
				<div>
					<div>
						상품 이름 : <input type="text" name="p_name">
					</div>
				</div>
				<div>
					<div>
						가격 : <input type="text" name="price" placeholder="ETH">
					</div>
				</div>
				<div>
					<div>
						기존 파일 사용 : <input type="file" name="nftUrl"><br> 
						<input
							type="hidden" name="newNftUrl" value="${newNftUrl}"> 새로운
						파일 사용 : <input type="button" value="NFT 제작"
							onclick="location.href='makeNFT.do?newNftUrl=${newNftUrl}'"
							style="padding: 0px; width: 80px; height: 25px; font-size: 12px; line-height: 25px;">
						<c:if test="${fileControl==null}">
							선택된 파일 없음
						</c:if>
						<c:if test="${fileControl==1}">
							파일 등록 완료 
						</c:if>
						<br>
					</div>
				</div>
				<div>
					<div>작품 설명</div>
					<textarea id="content" name="description" cols="80" rows="10"
						placeholder="상품 설명을 입력하세요."></textarea>
				</div>
				<div>
					<div>
						에디션 : <input type="text" name="edition">
					</div>
				</div>
				<div>
					<div>
						등록 날짜 : <input type="text" name="reg_date"
							placeholder="(예시) 2022-10-03">
					</div>
				</div>
			</div>
			<div>
				상품을 등록하시겠습니까? <input type="submit" value="등록"
					onclick="return checkProduct()"> <input type="reset"
					value="취소">
			</div>
		</div>
	</form>
</body>
<%@ include file="../footer.jsp"%>
</html>