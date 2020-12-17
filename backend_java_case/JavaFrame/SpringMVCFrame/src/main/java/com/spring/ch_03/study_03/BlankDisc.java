package com.spring.ch_03.study_03;

import com.spring.ch_02.study_01.CompactDisc;

public class BlankDisc implements CompactDisc{

	private String title;
	private String artist;
	
	public BlankDisc(String title, String artist){
		this.title = title;
		this.artist = artist;
	}
	
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing " + title + " by " + artist);
	}
}
