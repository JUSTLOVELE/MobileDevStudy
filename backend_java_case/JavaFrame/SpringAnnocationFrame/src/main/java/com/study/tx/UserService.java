package com.study.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//¿ªÆôÊÂÎñ
	@Transactional
	public void insertUser() {
		userDao.insert();
		System.out.println("insert successfully");
		System.out.println(1/0);
	}
}
