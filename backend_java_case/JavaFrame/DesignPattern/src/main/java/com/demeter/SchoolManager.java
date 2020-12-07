package com.demeter;

import java.util.ArrayList;
import java.util.List;

public class SchoolManager {

	public List<Empolyee> getAllEmpolyee() {
		
		List<Empolyee> list = new ArrayList<Empolyee>();
		
		for(int i=0; i<5; i++) {
			
			Empolyee emp = new Empolyee();
			emp.setId("学院总部员工id = " + i);
			list.add(emp);
		}
		
		return list;
	}
	
	public void prinAllEmployee(CollegeManager sub) {
		//获取到学院员工
		for(CollegeEmpolyee c: sub.getAllEmpolyee()) {
			System.out.println(c.getId());
		}
		//获取到学校总部员工
		for(Empolyee e: this.getAllEmpolyee()) {
			System.out.println(e.getId());
		}
	}
}
