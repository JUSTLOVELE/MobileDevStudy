package com.spring.ch_05.study01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ex_01_HomeController��home()�����ܹ�ӳ�䵽��"/"��"/homepage"��get����
 * @author Administrator
 *
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

	/**
	 * �ض���
	 * @return
	 */
	@RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET)
	public String home(){
		return "redirect:home";
	}
}
