package com.spring.ch_03.study_02;


public class MagicBean {
	
	private String magic = "ok";
	
	public String getMagic() {
		return magic;
	}

	public void setMagic(String magic) {
		this.magic = magic;
	}

	public void work() {
		System.out.println("do it");
	}
}
