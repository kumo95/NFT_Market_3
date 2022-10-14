/**
 * 
 */

// 이메일 인증받기 기능
function sendEmail(){
	if(document.frm.e_wallet.value=== ""){
		alert("이메일을 입력해주세요.");
		return;
	}	
	/* window.open을 사용해서 새로운 창을 열고 아이디찾기 실행 */
/*	var url = "sendEmail.do?e_wallet="+ document.frm.e_wallet.value
	location.href = url;*/
	var url = "sendEmail.do";
	url = url + "?userid=" + document.frm.userid.value;
	url = url + "&name=" + document.frm.name.value;
	url = url + "&birth=" + document.frm.birth.value;
	url = url + "&e_wallet=" + document.frm.e_wallet.value;
	url = url + "&phone=" + document.frm.phone.value;
	url = url + "&idColorControll=" + document.frm.idColorControll.value;
	url = url + "&emailColorControll=" + document.frm.emailColorControll.value;
	location.href = url;
	
}

function findIdEmail(){
	if(document.frmFindId.name.value===""){
		alert("이름을 입력해주세요.");
		return;
	}
	if(document.frmFindId.phone.value===""){
		alert("핸드폰을 입력해주세요.");
		return;
	}
	if(document.frmFindId.e_wallet.value===""){
		alert("이메일을 입력해주세요.");
		return;
	}
	if(document.frmFindId.emailAgree.value != 1){
		alert("이메일을 체크해주세요.");
		return;
	}	
	
	var url = "findIdEmail.do?name=" + document.frmFindId.name.value;
	url = url + "&phone="  + document.frmFindId.phone.value;
	url = url + "&e_wallet="  + document.frmFindId.e_wallet.value;
	url = url + "&emailAgree="  + document.frmFindId.emailAgree.value;
	location.href = url;
}

function findPwdEmail(){
	if(document.frmFindPwd.userid.value===""){
		alert("아이디를 입력해주세요.");
		return;
	}
	if(document.frmFindPwd.phone2.value===""){
		alert("핸드폰을 입력해주세요.");
		return;
	}
	if(document.frmFindPwd.e_wallet2.value===""){
		alert("이메일을 입력해주세요.");
		return;
	}
	if(document.frmFindPwd.emailAgree2.value != 1){
		alert("이메일을 체크해주세요.");
		return;
	}	
	
	var url = "findPwdEmail.do?userid=" + document.frmFindPwd.userid.value;
	url = url + "&phone2="  + document.frmFindPwd.phone2.value;
	url = url + "&e_wallet2="  + document.frmFindPwd.e_wallet2.value;
	url = url + "&emailAgree2="  + document.frmFindPwd.emailAgree2.value;
	location.href = url;
}