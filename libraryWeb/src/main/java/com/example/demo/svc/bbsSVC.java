package com.example.demo.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.bbsDAO;
import com.example.demo.vo.bbsVO;
@Service
public class bbsSVC {
	
	@Autowired
	private bbsDAO dao;
	
  public List<bbsVO> getUserList() {
    return dao.getUserList();
 }

}
