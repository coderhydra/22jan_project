package com.example.demo.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.svc.userSVC;
import com.example.demo.vo.userVO;

@Controller
@RequestMapping("/library")
public class cont {
	
	@Autowired
	public userSVC uSvc;
	
	@GetMapping("")
	public String index() {
		return "redirect:/library/login";
	}
		
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@GetMapping("/login")
	public String loginG() {
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String loginP(
			@RequestParam("uid")String uid,
			@RequestParam("pwd")String pwd,
			Model m
			) {
		boolean res = uSvc.login(uid, pwd);
		m.addAttribute("uid",uid);
		System.err.println("login");
		String jstr = String.format("{\"ok\":%b}", res);
		return jstr;
	}
	
	//로그아웃기능
	@GetMapping("/logout")
	@ResponseBody
	public boolean logout(SessionStatus status) {
		status.setComplete(); 
		// 세션에 저장된 모든 데이터를 삭제!
		//바구니 비우기!
		System.out.println("user logout");
		return true;
	}
	
	@GetMapping("/signup")
	public String signUpG() {
		return "join";
	}
	
	@PostMapping("/signup")
	@ResponseBody
	public String signup(userVO u) {
		boolean res = uSvc.signup(u);
		String jstr = String.format("{\"ok\":%b}", res);
		return jstr;
	}
}