package com.example.demo.svc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.userDAO;
import com.example.demo.util.Cart;
import com.example.demo.vo.userVO;

@Service
public class userSVC {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private userDAO dao;
	
	@Autowired
	public userVO user;
	
	@Autowired 
	public userSVC(@Qualifier("userDao") userDAO dao) {
		this.dao = dao;
	}
	public boolean login(String uid ,String pwd) {
		user = dao.select(uid);
		if( user.getUid().equals(uid) && user.getPwd().equals(pwd)) {
			//로그인 성공시 세션에 아이디 저장
			session.setAttribute("uid", uid);
			// 장바구니 없으면 장바구니 추가
			if( session.getAttribute("cart") == null ) { 
				session.setAttribute("cart", new Cart());
				System.err.println("유저서비스에서 카트주기");

			}
			return true;
		}
		return false;
	}
	public boolean signup(userVO u) {
		return dao.insert(u);
	}
}