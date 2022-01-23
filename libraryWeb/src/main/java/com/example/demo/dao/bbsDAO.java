package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.bbsMapper;
import com.example.demo.vo.bbsVO;

@Repository 
public class bbsDAO {
	
	@Autowired
  private bbsMapper bm;


  public List<bbsVO> getUserList() {
     return bm.getUserList();
  }
}
