package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.vo.NoticeVO;

@Mapper
public interface NoticeMapper {
	    public int noticeListCount();
	    public List<NoticeVO> noticeList(NoticeVO notice);
	    public NoticeVO noticeOne(String notice_id);
	    public int noticeInsert(NoticeVO notice);
	    public int noticeUpdate(NoticeVO notice);
	    public int noticeDelete(String notice_id);
}

