package com.nft.dto;

import java.sql.Date;

public class QnaVo {
	
	private int no;  			// 번호
	private String userid; 		// 작성자 id
	private String title; 		// 제목
	private String content; 	// 내용
	private String files; 		// 첨부파일 이름
	private int re_ref; 		// 글 그룹 번호
	private int re_lev; 		// 답변글 깊이
	private int re_seq; 		// 답변글 순서
	private int count; 			// 조회수
	private Date writeDate; 	// 작성일
	private int parent; 		// 부모글 번호
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
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
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
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "QnaVo [no=" + no + ", userid=" + userid + ", title=" + title + ", content=" + content + ", files="
				+ files + ", re_ref=" + re_ref + ", re_lev=" + re_lev + ", re_seq=" + re_seq + ", count=" + count
				+ ", writeDate=" + writeDate + ", parent=" + parent + "]";
	}
}