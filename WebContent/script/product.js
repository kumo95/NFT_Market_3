/**
 * 
 */
/* 등호 3개 === 는 타입도 같은지 확인 */
function checkProduct(){
	if(document.frm.name.value.length===0){
		alert("상품명을 입력하세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length===0){
		alert("가격을 입력하세요.");
		frm.price.focus();
		return false;
	}
	/* isNaN(매개변수) 매개변수가 숫자이면 false */
	if(isNaN(document.frm.price.value)){
		alert("숫자로 입력하세요.");
		frm.price.focus();
		return false;
	}
	return true;
}

