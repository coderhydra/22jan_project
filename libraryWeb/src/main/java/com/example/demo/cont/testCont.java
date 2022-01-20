package com.example.demo.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class testCont {

	@GetMapping("/")
	public String test() {
		return "test";
	}
}
