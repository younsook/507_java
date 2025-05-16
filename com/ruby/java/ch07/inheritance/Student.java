package com.ruby.java.ch07.inheritance;

public class Student extends Person{
	private String major;
	
	public Student() {
		super(); // 부모 클래스(Person)의 생성자 호출, 반드시 첫 줄
		System.out.println("Student 생성자 실행");
	}
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
		System.out.println("Student(name,age,major) 생성자 실행!");
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return this.getName()+":" +this.getAge()+":"+ major;
	}
}
