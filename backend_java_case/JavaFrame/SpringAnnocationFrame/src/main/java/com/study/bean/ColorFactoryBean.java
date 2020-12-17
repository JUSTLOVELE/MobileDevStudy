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
		//ע���·���������color������ColorFactoryBean
		return Color.class;
	}

	/**
	 * �ǲ��ǵ���
	 * true : ���bean�ǵ���,�������б���һ��
	 * false : ��ʵ��,ÿ�λ�ȡʵ��һ��
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
