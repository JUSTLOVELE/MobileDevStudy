package com.spring.ch_02.study_02;

import org.springframework.beans.factory.annotation.Autowired;


public class CDPlayer implements MediaPlayer{
	
	private CompactDisc cd;
	
	/**
	 * 也自动装配在方法,但是如果没有的话就是会抛异常,可以设置它的required属性为false
	 * @param cd
	 */
	@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

}
