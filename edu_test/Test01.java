package edu_test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//scanner 기억
		Scanner scanner = new Scanner(System.in);
		System.out.println("num:");
		int num = scanner.nextInt();
		
		//1~100까지 홀수합, 짝수합, 전체합 구하기.		
		//짝수 합을 저장할 변수 선언
		int a = 0;
		//홀수 합을 저장할 변수 선언
		int b = 0;
		//전체 합을 저장할 변수 선언
		int c = 0;
		
		//1에서 100까지 for 루프를 돌면서 짝수는 짝수합에 더하고 ijknm
		//홀수는 홀수 합에 더하고, 전체 합에 무조건 더하고

		for(int i=1; i<=num; i++) {
			if(i%2 == 0) { //짝수
				a += i;
			}else {//홀수
				b += i;
			}	 
		}
		//각 합 결과를 출력 
	System.out.println("짝수합:"+a);
	System.out.println("홀수합:"+b);
	System.out.println("전체합:"+(a+b));
	}
}
