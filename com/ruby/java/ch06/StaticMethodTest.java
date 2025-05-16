package com.ruby.java.ch06;

public class StaticMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethodTest.print1();
		StaticMethodTest exem = new StaticMethodTest();
		exem.print2();
	}
	
	public static void print1() {
		System.out.println("Hello");
	}
	
	public void print2() {
		System.out.println("java");
	}

}
