package com.spring.ch_03.study_03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.ch_02.study_01.CompactDisc;

@Component
public class BlankDisc_2 implements CompactDisc{

	private String title;
	private String artist;
	
	/**
	 * ���ͨ�����ɨ�贴��bean�Ļ�,��ע�����Ժ͹���������ʱ,���ǿ���ʹ��@Valueע��
	 * @param title
	 * @param artist
	 */
	public BlankDisc_2(@Value("#{systemProperties['blankDisc.title']}")String title, 
			           @Value("#{systemProperties['blankDisc.artist']}")String artist){
		this.title = title;
		this.artist = artist;
	}
	
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing " + title + " by " + artist);
	}
}
