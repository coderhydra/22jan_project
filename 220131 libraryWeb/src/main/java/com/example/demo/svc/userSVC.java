package com.example.demo.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.userDAO;
import com.example.demo.vo.userVO;

@Service
public class userSVC {
	
	private userDAO dao;
	
	@Autowired
	public userVO user;
	
	@Autowired 
	public userSVC(@Qualifier("userDao") userDAO dao) {
		this.dao = dao;
	}
	public boolean login(String uid ,String pwd) {
		user = dao.select(uid);
		if( user.getUid().equals(uid) && user.getPwd().equals(pwd)) return true;
		return false;
	}
	public boolean signup(userVO u) {
		return dao.insert(u);
	}
}