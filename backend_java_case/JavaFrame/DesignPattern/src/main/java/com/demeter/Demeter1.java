package com.demeter;

public class Demeter1 {

	//迪米特法则
	public static void main(String[] args) {
		
		SchoolManager schoolManager = new SchoolManager();
		schoolManager.prinAllEmployee(new CollegeManager());
	}
}
