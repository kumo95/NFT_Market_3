/**
 * 
 */


// id를 입력 후 중복체크 버튼을 눌렀을 때, 동작 함수
function checkId(){

	if(document.frm.userid.value===""){
		alert("아이디를 입력해주세요.");
		return;
	}
	
	var id = document.frm.userid.value;
	if(id.length < 5 || id.length>10){
	    window.alert('비밀번호는 5글자 이상, 10글자 이하만 이용 가능합니다.');
	    return;
	}
	
	
	/* window.open을 사용해서 새로운 창을 열고 중복체크 */
	/*var url = "checkId.do?userid="+ document.frm.userid.value;*/
	/*window.open(url, "_blank_1", "width=450, height=200, menubar=no, resizeable=no");*/
	var url = "sameId.do?userid="+ document.frm.userid.value;
	location.href= url;
}


// checkId.jsp에서 사용 버튼 클릭시, 동작할 함수
 
//만약 개발자도구에서 소스가 안보이는 경우
//1. Network 탭으로 이동하여 Disable cache 체크박스에 체크
//	=> Sources 탭으로 이동하여 F5(새로고침) 
//2. 그래도 안보이면 Console 탭으로 이동 후 console.log 입력 후 엔터
//	=> Sources 탭으로 이동하여 F5(새로고침)
 
function idOk(){
	// 중복체크 창에 입력된 아이디 값을 회원가입창 아이디 입력양식에 삽입
	opener.frm.userid.value = document.frm.userid.value;
	// 중복체크가 완료되었는지 확인하기 위한 목적의 변수에 아이디값 저장
	opener.frm.checkid.value = document.frm.userid.value;
	// 생성된 창 닫기
	self.close();
}

function checkLogin(){
	if(document.frm1.userId.value.length === 0){
		alert('아이디를 입력해주세요');
		frm1.userId.focus();
		return false;
	}
	if(document.frm1.idPwd.value.length === 0){
		alert('암호를 입력해주세요');
		frm1.idPwd.focus();
		return false;
	}
	return true;
}

// 비밀번호와 비밀번호 확인이 맞는지 확인 및 비밀번호 설정값
function checkIdPwd(){
	var pwd = document.frm.idPwd.value;
	var SC = ["!","@","#","$","%"];
	var check_SC = 0;
 
	if(pwd.length < 6 || pwd.length>15){
	    window.alert('비밀번호는 6글자 이상, 15글자 이하만 이용 가능합니다.');
	    document.frm.idPwd.value='';
	}
	for(var i=0;i<SC.length;i++){
	    if(pwd.indexOf(SC[i]) != -1){
	        check_SC = 1;
	    }
	}
	if(check_SC == 0){
	    window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
	    document.frm.idPwd.value='';
	}
	if(document.frm.idPwd.value !='' && document.frm.idPwdCheck.value != ''){
	    if(document.frm.idPwd.value==document.frm.idPwdCheck.value){
	        document.getElementById('checkIdPwd').innerHTML='비밀번호가 일치합니다.'
	        document.getElementById('checkIdPwd').style.color='blue';
	        document.getElementById('checkIdPwd').style.textAlign='right';
	    }
	    else{
	        document.getElementById('checkIdPwd').innerHTML='비밀번호가 일치하지 않습니다.';
	        document.getElementById('checkIdPwd').style.color='red';
	        document.getElementById('checkIdPwd').style.textAlign='right';
	    }
	}
}

// E_wallet 비밀번호와 비밀번호 확인이 맞는지 확인 및 비밀번호 설정값
function checkE_walletPwd(){
	var e_pwd = document.frm.e_walletPwd.value;
    var SC = ["!","@","#","$","%"];
    var check_SC = 0;
 
	if(e_pwd.length < 6 || e_pwd.length>15){
        window.alert('비밀번호는 6글자 이상, 15글자 이하만 이용 가능합니다.');
        document.frm.e_walletPwd.value='';
    }
    for(var i=0;i<SC.length;i++){
        if(e_pwd.indexOf(SC[i]) != -1){
            check_SC = 1;
        }
    }
    if(check_SC == 0){
        window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
        document.frm.e_walletPwd.value='';
    }
    if(document.frm.e_walletPwd.value !='' && document.frm.e_walletPwdCheck.value != ''){
        if(document.frm.e_walletPwd.value==document.frm.e_walletPwdCheck.value){
            document.getElementById('checkE_walletPwd').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('checkE_walletPwd').style.color='blue';
            document.getElementById('checkE_walletPwd').style.textAlign='right';
        }
        else{
            document.getElementById('checkE_walletPwd').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('checkE_walletPwd').style.color='red';
            document.getElementById('checkE_walletPwd').style.textAlign='right';
        }
    }
}


// 입력된 양식에 정상 데이터가 포함되었는지 확인(체크)하는 코드
function checkSignUp(){
	if(document.frm.userid.value.length === 0){
		alert('아이디를 입력해주세요');
		frm.userid.focus();
		return false;
	}
	if(document.frm.checkid.value.length===0){
		alert('중복 체크를 하지 않았습니다.');
		frm.userid.focus();
		return false;
	}
	if(document.frm.idPwd.value.length === 0){
		alert('비밀번호를 입력해주세요');
		frm.idPwd.focus();
		return false;
	}
	if(document.frm.idPwdCheck.value.length === 0){
		alert('비밀번호 확인을 입력해주세요');
		frm.idPwdCheck.focus();
		return false;
	}
	if(document.frm.idPwd.value != document.frm.idPwdCheck.value){
		alert('비밀번호가 일치하지 않습니다.');
		frm.idPwdCheck.focus();
		return false;
	}
	if(document.frm.name.value.length === 0){
		alert('이름을 입력해주세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.birth.value.length === 0){
		alert('생년월일을 입력해주세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.gender.value.length === 0){
		alert('성별을 선택해주세요');
		frm.gender.focus();
		return false;
	}
	if(document.frm.idPwdCheck.value.length === 0){
		alert('암호를 입력해주세요');
		frm.idPwdCheck.focus();
		return false;
	}
	if(document.frm.e_wallet.value.length === 0){
		alert('이메일을 입력해주세요');
		frm.e_wallet.focus();
		return false;
	}
	if(document.frm.e_walletPwd.value.length === 0){
		alert('비밀번호(전자지갑)를 입력해주세요');
		frm.e_walletPwd.focus();
		return false;
	}
	if(document.frm.e_walletPwdCheck.value.length === 0){
		alert('비밀번호 확인(전자지갑)을 입력해주세요');
		frm.e_walletPwd.focus();
		return false;
	}
	if(document.frm.e_walletPwd.value != document.frm.e_walletPwdCheck.value){
		alert('비밀번호(전자지갑)가 일치하지 않습니다.');
		frm.idPwdCheck.focus();
		return false;
	}
	if(document.frm.phone.value.length === 0){
		alert('휴대전화를 입력해주세요');
		frm.phone.focus();
		return false;
	}
	if(document.frm.email_agree.value.length === 0){
		alert('이메일 수신여부를 입력해주세요');
		return false;
	}
	if(document.frm.phone_agree.value.length === 0){
		alert('문자정보 서비스 수신여부를 입력해주세요');
		return false;
	}	
	return true;
}

function checkUpdate(){
	if(document.frm.idPwd.value.length === 0){
		alert('(아이디)현재 비밀번호를 입력해주세요');
		frm.idPwd.focus();
		return false;
	}
	if(document.frm.newIdPwd.value.length === 0){
		alert('(아이디)새 비밀번호를 입력해주세요');
		frm.newIdPwd.focus();
		return false;
	}
	if(document.frm.newIdPwdCheck.value.length === 0){
		alert('(아이디)새 비밀번호 확인을 입력해주세요');
		frm.newIdPwdCheck.focus();
		return false;
	}
	if(document.frm.idPwd.value == document.frm.newIdPwd.value){
		alert('(아이디)기존 비밀번호와 같은 비밀번호는 사용 불가능합니다.');
		frm.newIdPwd.focus();
		return false;
	}
	if(document.frm.newIdPwd.value != document.frm.newIdPwdCheck.value){
		alert('(아이디)새 비밀번호가 일치하지 않습니다.');
		frm.newIdPwd.focus();
		return false;
	}
	if(document.frm.e_walletPwd.value.length === 0){
		alert('(전자지갑)현재 비밀번호를 입력해주세요');
		frm.e_walletPwd.focus();
		return false;
	}
	if(document.frm.newE_walletPwd.value.length === 0){
		alert('(전자지갑)새 비밀번호를 입력해주세요');
		frm.newE_walletPwd.focus();
		return false;
	}
	if(document.frm.newE_walletPwdCheck.value.length === 0){
		alert('(전자지갑)새 비밀번호 확인을 입력해주세요');
		frm.newE_walletPwdCheck.focus();
		return false;
	}
	if(document.frm.e_walletPwd.value == document.frm.newE_walletPwd.value){
		alert('(전자지갑)기존 비밀번호와 같은 비밀번호는 사용 불가능합니다.');
		frm.newE_walletPwd.focus();
		return false;
	}
	if(document.frm.newE_walletPwd.value != document.frm.newE_walletPwdCheck.value){
		alert('(전자지갑)새 비밀번호가 일치하지 않습니다.');
		frm.newE_walletPwd.focus();
		return false;
	}	
	return true;
}
	