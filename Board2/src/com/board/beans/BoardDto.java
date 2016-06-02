package com.board.beans;

public class BoardDto {

    private int bseq = 0;
    private String title  = null;
    private String content  = null;
    private String img_path  = null;
    private String img_oname  = null;
    private String img_name  = null;
    private String regid  = "LGS";
    private String regdate  = null;
    
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
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
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getImg_oname() {
		return img_oname;
	}
	public void setImg_oname(String img_oname) {
		this.img_oname = img_oname;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
