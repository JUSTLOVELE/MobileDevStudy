package com.shiro.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {
	
	private final static Log _log = LogFactory.getLog(ShiroHandler.class);

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password) {
		
		Subject currentUser = SecurityUtils.getSubject();
		
		if(!currentUser.isAuthenticated()) {
			
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			
			try {
				//和login里面的hashCode一样
				_log.info(token.hashCode());
				currentUser.login(token);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		
		return "redirect:/list.jsp";
	}
}
