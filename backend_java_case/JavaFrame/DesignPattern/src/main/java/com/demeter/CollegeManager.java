package com.demeter;

import java.util.ArrayList;
import java.util.List;

//管理学院员工的管理类
public class CollegeManager {

	public List<CollegeEmpolyee> getAllEmpolyee() {
		
		List<CollegeEmpolyee> list = new ArrayList<CollegeEmpolyee>();
		
		for(int i=0; i<10; i++) {
			//新增10个员工到list
			CollegeEmpolyee emp = new CollegeEmpolyee();
			emp.setId("学院员工id = " + i);
			list.add(emp);
		}
		
		return list;
	}
}
