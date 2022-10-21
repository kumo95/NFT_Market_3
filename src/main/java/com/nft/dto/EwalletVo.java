package com.nft.dto;

public class EwalletVo {
	private String userid;
	private String e_wallet;
	private String e_walletPwd;
	private String privatekey;
	private String publickey;
	private long money;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	public String getPublickey() {
		return publickey;
	}
	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "EwalletVo [userid=" + userid + ", e_wallet=" + e_wallet + ", e_walletPwd=" + e_walletPwd
				+ ", privatekey=" + privatekey + ", publickey=" + publickey + ", money=" + money + "]";
	}
	
}
