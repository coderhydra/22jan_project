package com.example.demo.vo;

public class bbsVO {

	private int no;
	private String title;
	private String content;
	private String coments;
	private String date;
	private String writer;
	private int cnt;
	private int  page;
	
	public bbsVO() {
		// TODO Auto-generated constructor stub
	}

	public bbsVO(int no, String title, String content, String coments, String date, String writer, int cnt, int page) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.coments = coments;
		this.date = date;
		this.writer = writer;
		this.cnt = cnt;
		this.page = page;
	}

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

	public String getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments = coments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
