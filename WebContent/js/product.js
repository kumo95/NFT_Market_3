/**
 * 
 */

function checkProduct() {
	if(document.frm.creator.value.length===0){
		alert("창조자(userid)를 입력하세요.");
		frm.creator.focus();
		return false;
	}
	if(document.frm.owner.value.length===0){
		alert("소유자(userid)를 입력하세요.");
		frm.owner.focus();
		return false;
	}
	if(document.frm.p_name.value.length===0){
		alert("상품명을 입력하세요.");
		frm.p_name.focus();
		return false;
	}
	if(document.frm.price.value.length===0){
		alert("가격을 입력하세요.");
		frm.price.focus();
		return false;
	}
	if(isNaN(document.frm.price.value)){
		alert("이더리움 가격을 입력하세요.");
		frm.price.focus();
		return false;
	}
	if(document.frm.nftUrl.value.length===0 && document.frm.newNftUrl.value.length===0){
		alert("파일을 업로드 하세요");
		frm.nftUrl.focus();
		return false;
	}
	if(document.frm.edition.value.length===0){
		alert("에디션 생성");
		frm.edition.focus();
		return false;
	}
	if(document.frm.reg_date.value.length===0){
		alert("등록 날짜를 입력하세요 예시)2022-10-16");
		frm.reg_date.focus();
		return false;
	}
	return true;
}