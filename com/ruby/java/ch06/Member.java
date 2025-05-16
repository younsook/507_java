package com.ruby.java.ch06;


public class Member {
	private String name;
	private int age;
	
	public Member() {
		this("guest");
	}
	
	public Member(String name) {
		this(name, 0);
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public String toString() {
		return name +" : "+age;
	}
	
	public static void main(String[] args) {
		
		Member m1 = new Member(); //new연산자로 생성자를 호출해준다. heap영역에 만들어주고, stack영역에 주소로 연결
		Member m2 =new Member("Amy");
		Member m3 =new Member("Amy", 23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
	}

}
