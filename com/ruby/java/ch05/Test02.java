package com.ruby.java.ch05;

public class Test02 {
	
	static void jumsu(String name, int...v) {
		System.out.print(name+" : ");
		for (int x : v) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jumsu("홍길동", 98, 85, 88);
		jumsu("김부산", 90, 95, 92);
		jumsu("이양산", 80, 98, 95);
	}

}
