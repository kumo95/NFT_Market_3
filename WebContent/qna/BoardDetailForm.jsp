<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<html>
<head>
	<title>�� �󼼺���</title>
	
	<style type="text/css">
		#wrap {
			width: 800px;
			margin: 0 auto 0 auto;
		}
	
		#detailBoard{
			text-align :center;
		}
		
		#title{
			height : 16;
			font-family :'����';
			font-size : 12;
			text-align :center;
		}
	</style>
	
	<script type="text/javascript">
		function changeView(value)
		{
			if(value == 0)	
				location.href="BoardListAction.bo?page=${pageNum}";
			else if(value == 1)
				location.href='BoardReplyFormAction.bo?no=${qna.no}&page=${pageNum}';
		}
		
		function doAction(value)
		{
			if(value == 0) alert("������ư Ŭ��"); // ����
			else if(value == 1) // ����
				location.href="BoardDeleteAction.bo?no=${qna.no}";
		}
	</script>
</head>
<body>

<div id="wrap">
	<br><br>
	<div id="board">
		<table id="detailBoard" width="800" border="3" bordercolor="lightgray">
		
			<tr>
				<td id="title">�ۼ���</td>
				<td>${qna.writeDate}</td>
			</tr>
			<tr>
				<td id="title">�ۼ���</td>
				<td>${qna.userid}</td>
			</tr>
			<tr>
				<td id="title">
					�� ��
				</td>
				<td>
					${qna.title}
				</td>		
			</tr>
			<tr>
				<td id="title">
					�� ��
				</td>
				<td>
					${qna.content}
				</td>		
			</tr>
			<tr>
				<td id="title">
					÷������
				</td>
				<td>
					<a href='FileDownloadAction.bo?file_name=${qna.files}'>${qna.files}</a>
				</td>	
			</tr>
	
			<tr align="center" valign="middle">
				<td colspan="5">
				<c:if test="${sessionScope.sessionID !=null}">
					<c:if test="${sessionScope.sessionID == qna.userid}">
						<input type="button" value="����" onclick="doAction(0)">
						<input type="button" value="����" onclick="doAction(1)">
					</c:if>
						<input type="button" value="���" onclick="changeView(1)" >
				</c:if>		
					<input type="button" value="���" onclick="changeView(0)">			
				<!-- javascript:location.href='BoardListAction.bo?page=${pageNum}' -->
				</td> 
			</tr>
		</table>
	</div>
</div>	

</body>
</html>