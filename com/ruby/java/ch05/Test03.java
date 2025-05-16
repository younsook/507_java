package com.ruby.java.ch05;

public class Test03 {
	
	public static void main(String[] args) {
		
		System.out.println(addNumber(1));
		System.out.println(addNumber(1,2));
		System.out.println(addNumber(1,2,3));
		System.out.println(addNumber(1,2,3,4));
	}
	
	/*
	 오버로딩 방법 구현
	private static int addNumber(int x, int y ) {
		int sum = x + y;
		return sum;
	}
	private static int addNumber(int x, int y, int n ) {
		int sum = x + y + n;
		return sum;
	}*/
	
	//메서드 : 동작을 표현한것, 동작을 위한 실행문
	private static int addNumber(int...v) {
		System.out.print(v.length+" : ");
		int sum = 0;
		for(int x : v) {
			sum += x;
			System.out.print(x+" ");
		}
			System.out.print("==>");
		return sum;
	}
	
	
	
	
	
	/*
	// 같은 결과 값을 낸다. 방법 1
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("합:"+addNumber(1,2));
	}
	private static int addNumber(int x, int y ) {
		return x + y;
	}
	 */
	
	/*
	 // 방법 2
	public static void main(String[] args) {
		// 
		int a = addNumber(1,2);
		System.out.println("합:"+a);
	}
	private static int addNumber(int x, int y ) {
		int sum = x + y;
		return sum;
	}
	 */
}
