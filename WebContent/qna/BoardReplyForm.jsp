<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>QnA - �亯��</title>
	
	<style type="text/css">
		#title{
			height : 16;
			font-family :'����';
			font-size : 12;
			text-align :center;
		}
	</style>
	
</head>
<body>

	<br>
	<b><font size="6" color="gray">��� �ۼ�</font></b>
	<br>
	
	<form method="post" action="BoardReplyAction.bo?page=${page}" name="boardForm">
	<!-- �θ�� ������ �ѱ��. -->
	<input type="hidden" name="userid" value="${sessionScope.sessionID}">
	<input type="hidden" name="no" value="${qna.no}"/>
	<input type="hidden" name="re_ref" value="${qna.re_ref}"/>

	<table width="700" border="3" bordercolor="lightgray" align="center">
		<tr>
			<td id="title">�ۼ���</td>
			<td>${sessionScope.sessionID}</td>
		</tr>
			<tr>
			<td id="title">
				�� ��
			</td>
			<td>
				<input name="title" type="text" size="70" maxlength="100" value=""/>
			</td>		
		</tr>
		<tr>
			<td id="title">
				�� ��
			</td>
			<td>
				<textarea name="content" cols="72" rows="20">
				</textarea>			
			</td>		
		</tr>

		<tr align="center" valign="middle">
			<td colspan="5">
				<input type="reset" value="�ۼ����" >
				<input type="submit" value="���" >
				<input type="button" value="���" onclick="javascript:history.go(-1)">			
			</td>
		</tr>
	</table>	
	</form>
	
</body>
</html>