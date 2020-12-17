package com.study.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * ����ʽ����:
 * 	�����:
 * 	 1.�����������
 * 	 2.��������Դ
 *   3.����@Transactional��ʾ�����񷽷�
 *   4.@EnableTransactionManagement ��������ע������������
 *   5.�����������������������
 * 		
 * 
 * @author Administrator
 *
 */
@EnableTransactionManagement
@ComponentScan("com.study.tx")
@Configuration
public class TxConfig {
	
	//ע�������������������
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	//����Դ
	@Bean
	public DataSource dataSource() throws Exception {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		//Spring��@Configuration������⴦���������м�����ķ���,��ε��ö�ֻ�Ǵ������������
		return new JdbcTemplate(dataSource);
	}
	
}
