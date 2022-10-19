package com.nft.dto;

//DTO(VO) 사용 장점
//1. 중요한 정보 보안 강화 (필드 직접 접근 차단)
//2. 데이터 관리의 일원화 (객체를 통해서만 데이터 접근) 
//3. 데이터 값 검증 (유용한 값만 사용)


public class MemberVo {
	private String name;
	private String userid;
	private String idPwd;
	private String birth;
	private String gender;
	private String e_wallet;
	private String e_walletPwd;
	private String nationPhone;
	private String phone;
	private int email_agree;
	private int phone_agree;
//	private int admin;

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getIdPwd() {
		return idPwd;
	}



	public void setIdPwd(String idPwd) {
		this.idPwd = idPwd;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getE_wallet() {
		return e_wallet;
	}



	public void setE_wallet(String e_wallet) {
		this.e_wallet = e_wallet;
	}



	public String getE_walletPwd() {
		return e_walletPwd;
	}



	public void setE_walletPwd(String e_walletPwd) {
		this.e_walletPwd = e_walletPwd;
	}



	public String getNationPhone() {
		return nationPhone;
	}



	public void setNationPhone(String nationPhone) {
		this.nationPhone = nationPhone;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public int getEmail_agree() {
		return email_agree;
	}

	
	
	public void setEmail_agree(int email_agree) {
		this.email_agree = email_agree;
	}



	public int getPhone_agree() {
		return phone_agree;
	}



	public void setPhone_agree(int phone_agree) {
		this.phone_agree = phone_agree;
	}


//	public int getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(int admin) {
//		this.admin = admin;
//	}

	@Override
	public String toString() {
		return "MemberVo [name=" + name + ", userid=" + userid + ", idPwd=" + idPwd + ", birth=" + birth + ", gender=" + gender + ","
				+ " email=" + e_wallet + ", emailPwd=" + e_walletPwd + ", nationPhone=" + nationPhone + ", phone=" + phone + ","
				+ " email_agree=" + email_agree + ", phone_agree=" + phone_agree + "]";
	}

	
}
