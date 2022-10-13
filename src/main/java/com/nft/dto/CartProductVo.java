package com.nft.dto;

public class CartProductVo {

	private String userid;
	private String creator;
	private String unique_no;
	private String nftUrl;
	private String p_name;
	private Double price;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUnique_no() {
		return unique_no;
	}
	public void setUnique_no(String unique_no) {
		this.unique_no = unique_no;
	}
	public String getNftUrl() {
		return nftUrl;
	}
	public void setNftUrl(String nftUrl) {
		this.nftUrl = nftUrl;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "CartProductVo [userid=" + userid + ", creator=" + creator + ", unique_no=" + unique_no + ", nftUrl="
				+ nftUrl + ", p_name=" + p_name + ", price=" + price + "]";
	}
	
	
	
	
	
}
