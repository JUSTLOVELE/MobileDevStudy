package com.study.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color>{

	@Override
	public Color getObject() throws Exception {
		
		System.out.println("ColorFactoryBean getObject ");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		//注意下返回类型是color而不是ColorFactoryBean
		return Color.class;
	}

	/**
	 * 是不是单例
	 * true : 这个bean是单例,在容器中保存一份
	 * false : 多实例,每次获取实例一次
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
