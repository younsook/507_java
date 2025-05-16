package com.ruby.java.ch05;

public class Test03_2실습 {
	
	public static void main(String[] args) {
		
		System.out.println(addNumber(1));
		System.out.println(addNumber(1,2));
		System.out.println(addNumber(1,2,3));
		System.out.println(addNumber(1,2,3,4));
	}

	// 가변길이인자사용 인자 출력 
	// 확장 for문 사용, sum 구하기.
	// 합출력
	
	private static int addNumber(int...v) {
		System.out.print(v.length+" : ");
		int sum = 0;
		for (int x : v) {
			sum += x;
			System.out.print(x +" ");
		}
		System.out.print("→");
		return sum;
		
	}
	
	
	
	
	
	
	
	

	

	
	
//	private static int addNumber(int...v) {
//		System.out.print(v.length + ":");
//		int sum = 0;
//		for(int xx : v) {
//			sum += xx; //sum = sum + xx;
//			System.out.print(xx + " ");
//		}
//		System.out.print("합 → ");
//		return sum;
//	}
	

	
//	private static int addNumber(int...v) {
//		System.out.print(v.length+" : ");
//		int sum = 0;
//		for(int x : v) {
//			sum += x;
//			System.out.print(x+" ");
//		}
//			System.out.print("==>");
//		return sum;
//	}
//	

	
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
