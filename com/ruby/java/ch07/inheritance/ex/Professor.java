package com.ruby.java.ch07.inheritance.ex;

public class Professor extends Person {
	private String subject;
	
	public Professor() {
		super(); // 부모 클래스(Person)의 생성자 호출, 반드시 첫 줄
		System.out.println("Professor 생성자 실행");
	}
	
	public Professor(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
		System.out.println("Professor(name,age,subject) 생성자 실행!");
	}

	
	public String getSubject() {
		return subject;
	}
	
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public String toString() {
		return this.getName()+":"+this.getAge()+subject;
	}

}
