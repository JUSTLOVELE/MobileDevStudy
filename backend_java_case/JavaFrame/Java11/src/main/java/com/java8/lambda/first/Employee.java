package com.java8.lambda.first;

public class Employee {

	private String name;
	
	private Integer age;
	
	private double salary;
			
	private int id;
	
	private Status status;
	
	public Employee() {
		
	}
	
	public enum Status{
		FREE,
		BUSY,
		VOCATION;
	}
	
	public Employee(int id) {
		this.id = id;
	}
	
	public Employee(int id, int age) {
		this.id = id;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", id=" + id + ", status=" + status
				+ "]";
	}
	
	public Employee(int id, String name, int age, double salary, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public Employee(int id, String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
