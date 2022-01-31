package com.example.demo.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.svc.bbsSVC;
import com.example.demo.svc.userSVC;
import com.example.demo.vo.userVO;

@Controller
@RequestMapping("/library")
public class cont {
	
	@Autowired
	public userSVC uSvc;
	
	@Autowired
	public bbsSVC bSvc;

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
		System.out.println("login");
		String jstr = String.format("{\"ok\":%b}", res);
		return jstr;
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
	
	@GetMapping("/bbs")
	public String bbsG(Model m) {
		m.addAttribute("list",bSvc.getUserList());
		return "bbs";
	}
}
