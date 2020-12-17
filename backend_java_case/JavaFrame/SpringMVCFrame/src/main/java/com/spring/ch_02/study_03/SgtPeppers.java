package com.spring.ch_02.study_03;

import com.spring.ch_02.study_02.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * ���Ҫȡ�Լ�ϲ��������ֵ:@Component("youLikeName")
 * ɨ������������@Bean,��ʵ����������ʱ�����@Bean��ע����ȱ�����
 * @author Administrator
 *
 */
@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Play " + title + "by " + artist);
	}

	/**
	 * ������ʱ���Զ�װ��һ��CompactDisc�����÷�����
	 * ���ַ�ʽ��������ķ�ʽ������
	 * @param compactDisc
	 * @return
	 */
	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc){
		return new CDPlayer(compactDisc);
	}
	
	@Bean
	public CDPlayer cdPlayer(){
		/**
		 * ������CompactDisc��ͨ������sgtPeppers()�õ���,�����������ȫ���,
		 * ��ΪsgtPeppers()�����������@Beanע��,Spring�����������ж����ĵ���,��ȷ��ֱ�ӷ���
		 * �÷�����������bean,������ÿ�ζ��������ʵ�ʵĵ���
		 */
		return new CDPlayer(sgtPeppers());
	}
	
	/**
	 * @bean ע������Spring����������᷵��һ������,�ö���Ҫע��ΪSpringӦ���������е�bean
	 * �������а��������ղ���beanʵ�����߼�
	 * @return
	 */
	@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppers();
	}

}
