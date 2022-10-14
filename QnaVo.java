package com.nft.dto;

import java.sql.Date;

public class QnaVo {
	
	private int no;
	private String userid;
	private String email;
	private String pass;
	private String title;
	private String content;
	private String files;
	private Date writeDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "QnaVo [no=" + no + ", userid=" + userid + ", email=" + email + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", files=" + files + ", writeDate=" + writeDate + "]";
	}
	
}