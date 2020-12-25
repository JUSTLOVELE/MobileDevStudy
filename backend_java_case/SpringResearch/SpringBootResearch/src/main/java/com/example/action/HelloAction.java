package com.example.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@RequestMapping("helloAction")
public class HelloAction {

	@GetMapping("/aspectTestCase02")
	public String aspectTestCase02() {
		return "hello2";
	}


	@GetMapping("/aspectTestCase01")
	public String aspectTestCase01() {
		return "hello";
	}

	@GetMapping("/hello")
	//@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
