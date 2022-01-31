package com.example.demo.vo;

import org.springframework.stereotype.Component;

@Component
public class RecordVO {
	
	private int id;
	private String isbn;
	private String uid;
	private String title;
	private String author;
	private String publisher;
	private String imageUrl;
	private String rent_date;
	private String return_date;
	private int reserve;
	private String delivert;
	public RecordVO() {}
	public RecordVO(int id, String isbn, String uid, String title, String author, String publisher, String imageUrl,
			String rent_date, String return_date, int reserve, String delivert) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.uid = uid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.imageUrl = imageUrl;
		this.rent_date = rent_date;
		this.return_date = return_date;
		this.reserve = reserve;
		this.delivert = delivert;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getRent_date() {
		return rent_date;
	}
	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public String getDelivert() {
		return delivert;
	}
	public void setDelivert(String delivert) {
		this.delivert = delivert;
	}
	
}
