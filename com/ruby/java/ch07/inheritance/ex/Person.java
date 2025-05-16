package com.ruby.java.ch07.inheritance.ex;

public class Person {
	
	private String name;
	private int age;
	
	
	public Person() {
		super(); // 부모 클래스(Person)의 생성자 호출, 반드시 첫 줄
//		System.out.println("Person 생성자 실행1");
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "name:"+name+" | age:"+age;
	}
	
}
