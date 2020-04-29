package com.springcloud.entities;

import java.io.Serializable;

public class Payment implements Serializable{

	private String id;
	
	private String serial;
	
	public Payment() {
		
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Payment(String id, String serial) {
		super();
		this.id = id;
		this.serial = serial;
	}
	
	
	
}
