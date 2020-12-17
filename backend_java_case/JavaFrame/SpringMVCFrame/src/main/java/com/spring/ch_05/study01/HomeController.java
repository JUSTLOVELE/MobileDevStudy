package com.spring.ch_05.study01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ex_01_HomeController的home()方法能够映射到对"/"和"/homepage"的get请求
 * @author Administrator
 *
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET)
	public String home(){
		return "redirect:home";
	}
}
