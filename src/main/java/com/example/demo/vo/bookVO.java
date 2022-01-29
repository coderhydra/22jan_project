package com.example.demo.vo;

public class bookVO {

	private String title;
	private String author;
	private String publisher;
	private String data_type;
	private String index;
	private String file_url;
	private String ndl_bib_no;
	private String publisher_year;
	private int qty;

	public bookVO() {}
	public bookVO(String title, String author, String publisher, String data_type, String index, String file_url,
			String ndl_bib_no, String publisher_year, int qty) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.data_type = data_type;
		this.index = index;
		this.file_url = file_url;
		this.ndl_bib_no = ndl_bib_no;
		this.publisher_year = publisher_year;
		this.qty = qty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getNdl_bib_no() {
		return ndl_bib_no;
	}
	public void setNdl_bib_no(String ndl_bib_no) {
		this.ndl_bib_no = ndl_bib_no;
	}
	public String getPublisher_year() {
		return publisher_year;
	}
	public void setPublisher_year(String publisher_year) {
		this.publisher_year = publisher_year;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}// end C
