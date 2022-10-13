package com.nft.dto;

import java.sql.Date;

public class ProductVo {
	
	private String creator;
	private String owner;
	private String unique_no;
	private String p_name;
	// private int price;
	private Double price;
	private String nftUrl;
	private String description;
	private int edition;
	private Date reg_date;
	
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getUnique_no() {
		return unique_no;
	}
	public void setUnique_no(String unique_no) {
		this.unique_no = unique_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNftUrl() {
		return nftUrl;
	}
	public void setNftUrl(String nftUrl) {
		this.nftUrl = nftUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
	@Override
	public String toString() {
		return "ProductVo [creator=" + creator + ", owner=" + owner + ", unique_no=" + unique_no + ", p_name=" + p_name
				+ ", price=" + price + ", nftUrl=" + nftUrl + ", description=" + description + ", edition=" + edition
				+ ", reg_date=" + reg_date + "]";
	}

	
	
}

	