package com.ruby.java.ch07.inheritance.ex;

public class Employee extends Person{ //클래스명은 항상 대문자 시작

	private String dept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("Employee 생성자");
	}


	public Employee(String name, int age, String dept) {
		// TODO Auto-generated constructor stub
		super.setName(name);
		super.setAge(age);
		this.dept = dept;
	}






	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
		return this.getName()+":"+this.getAge()+":"+dept;
	}

}
