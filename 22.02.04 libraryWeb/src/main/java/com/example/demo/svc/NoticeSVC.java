package com.example.demo.svc;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NoticeDAO;
import com.example.demo.vo.NoticeVO;

@Service
public class NoticeSVC {
	
	@Autowired
	private HttpSession session;
//	session.setAttribute(null,______);
//	session.getAttribute(null)
	
	@Autowired
	private NoticeDAO noticeDao;
	
	 public int getNoticeListCount() {
     return noticeDao.getNoticeListCount();
 }
  
 public List<NoticeVO> getNoticeList(NoticeVO notice){
     return noticeDao.getNoticeList(notice);
 }
  
 public NoticeVO getNoticeOne(String notice_id) {
     return noticeDao.getNoticeOne(notice_id);
 }
  
 public boolean NoticeInsert(NoticeVO notice) {
     if( noticeDao.NoticeInsert(notice)==1) return true;
	 return false;
     
 }
  
 public boolean NoticeUpdate(NoticeVO notice) {
     if(noticeDao.NoticeUpdate(notice)==1) return true;
     return false;
 }
  
 public boolean NoticeDelete(String notice_id) {
     return noticeDao.NoticeDelete(notice_id);
 }
	
}

