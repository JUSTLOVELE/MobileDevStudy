package com.spring.ch_15.study_01;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * ��������������ڲ�����spring�����,���������������Ҫע��spring�������beanʱ,SpringBeanAutowiringSupport��������
 * @author Administrator
 *
 */
@Component
@WebService(serviceName="SpitterService")
public class SpitterServiceEndpoint extends SpringBeanAutowiringSupport {

	@Autowired
	private SpitterService service;
	
	@WebMethod
	public void addSpittle(String name){
		service.addSpittle(name);
	}
	
	@WebMethod
	public void deleteSpittle(String name){
		service.deleteSpittle(name);
	}
	
	@WebMethod
	public String getSpittle(){
		return service.getSpittle();
	}
}
