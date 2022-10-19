package com.nft.dto;

import java.sql.Date;

public class QnaVo {
	
	private int bno;  			// 번호
	private String userid; 		// 작성자 id
	private String pass;
	private String title; 		// 제목
	private String content; 	// 내용
	private String files; 		// 첨부파일 이름
	private int count;
	private Date writeDate;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "QnaVo [bno=" + bno + ", userid=" + userid + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", files=" + files + ", count=" + count + ", writeDate=" + writeDate + "]";
	}
	
}