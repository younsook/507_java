package com.ruby.java.ch06;

public class ThisTest2 {
	
	private String name;


	public void setName(String name) {
		this.name = name; //name = name; 이경우 null 됨.  값을 반환하지않음.
	}
	
	public String getName() {
		return name;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisTest2 exam = new ThisTest2(); //값을초기화함.
		exam.setName("Amy");
		System.out.println(exam.getName());

	}

}
