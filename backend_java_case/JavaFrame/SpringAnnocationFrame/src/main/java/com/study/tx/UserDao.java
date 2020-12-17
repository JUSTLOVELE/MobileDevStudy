package com.study.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert() {
		
		String sql = "insert into user(id, name, age) values('1', 'zs', 18)";
		jdbcTemplate.update(sql);
	}
}
