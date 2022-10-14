package com.nft.dto;

import java.sql.Date;

public class NoticeVo {
   private int no;            
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
      return "Vo [no=" + no + ", title=" + title + ", content=" + content + ", files=" + files + ", writeDate="
            + writeDate + "]";
   }       
      

}