package com.example.demo.vo;

public class NoticeVO {

  private String notice_id;
  private String notice_title;
  private String notice_coments;
  private String use_yn;
  private String mod_date;
  private int startIndex;
  private int cntPerPage;
  
  public NoticeVO() {}

	public NoticeVO(String notice_id, String notice_title, String notice_coments, String use_yn, String mod_date,
			int startIndex, int cntPerPage) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_coments = notice_coments;
		this.use_yn = use_yn;
		this.mod_date = mod_date;
		this.startIndex = startIndex;
		this.cntPerPage = cntPerPage;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_coments() {
		return notice_coments;
	}

	public void setNotice_coments(String notice_coments) {
		this.notice_coments = notice_coments;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getMod_date() {
		return mod_date;
	}

	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
  
  
  
}
