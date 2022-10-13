<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>결제페이지</title>
  <link href="css/order.css" type="text/css" rel="stylesheet" />
</head>

<body>

  <!--비밀번호-->
  <div class="align">
    <h3>비밀번호를 입력하세요</h3>
    <form>
      <div class="form__field">
        <input type="password" class="form__input" pattern=".{6,}" required>
        <span class="icon"></span>
      </div>
    </form>
    <p>비밀번호 확인 후 결제하기 버튼을 클릭하세요</p>
    <input class="button1" type="button" value="비밀번호 확인">
  </div>


<section>
  <div class="container">

    <div class="title">결제페이지</div>

    <table class="board_list">
      <colgroup>
        <col width="15%" />
        <col width="*" />
        <col width="15%" />
        <col width="15%" />
        <col width="15%" />
      </colgroup>
      <thead>
        <tr>
          <th scope="col">상품명</th>
          <th scope="col">이미지</th>
          <th scope="col">수량</th>
          <th scope="col">금액</th>
          <th scope="col">판매자</th>
        </tr>
      </thead>
      <tbody>
        <tr th:if="${#lists.size(list)} > 0" th:each="list : ${list}">
                <td th:text="${list.boardIdx}"></td>
                <td class="title" th:text="${list.title}"></td>
                <td th:text="${#temporals.format(list.createdDatetime, 'yyyy-MM-dd HH:mm::ss')}"></td>
            </tr> 
            <tr th:unless="${#lists.size(list)} > 0">
                <td colspan="5">조회된 결과가 없습니다.</td>
            </tr>
        </tbody>
    </table>

    <div class="button2">
      <input type="button" value="쇼핑계속하기">
      <input type="button" value="결제하기">
    </div>
</div>
</section>
</body>
</html>