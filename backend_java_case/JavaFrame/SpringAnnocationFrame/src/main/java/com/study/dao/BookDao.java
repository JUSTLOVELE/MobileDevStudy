package com.study.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	private String label = "1";
	
	public BookDao() {
		
	}
	
	public BookDao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "BookDao [label=" + label + "]";
	}
	
	
}
