<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>

<form action="makeFile.do" method="post" enctype="multipart/form-data" name="frm">
 	<div>
      <div>
      파일 업로드 : <input type="file" name="nftUrl"><br>
      </div>
    </div>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>

</body>
</html>