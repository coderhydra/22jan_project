package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.NoticeMapper;
import com.example.demo.vo.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private NoticeMapper mapper;
	     
	    public int getNoticeListCount() {
	        return mapper.noticeListCount();
	    }
	     
	    public List<NoticeVO> getNoticeList(NoticeVO notice){
	        return mapper.noticeList(notice);
	    }
	     
	    public NoticeVO getNoticeOne(String notice_id) {
	        return mapper.noticeOne(notice_id);
	    }
	     
	    public int NoticeInsert(NoticeVO notice) {
	        return mapper.noticeInsert(notice);
	    }
	     
	    public int NoticeUpdate(NoticeVO notice) {
	        return mapper.noticeUpdate(notice);
	    }
	     
	    public boolean NoticeDelete(String notice_id) {
	      if( mapper.noticeDelete(notice_id)==1) {
	     	 return true;
	      }
	      return false;
	    }
}
