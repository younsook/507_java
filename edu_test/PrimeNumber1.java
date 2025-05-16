package edu_test;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Number[0:exit]:");
			int num = sc.nextInt();
			if (num == 0) break;
			if (isPrime(num)==true)
				System.out.println(num + " is a Prime.");
			else
				System.out.println(num + " is not a Prime.");
		}
		sc.close();
		System.out.println("Done!");
		//int bill = scanner.nextInt();
	}
	
	// num이 소수면 true, 그렇지 않으면 false를 리턴
	public static boolean isPrime(int num) {
		//55를 입력하고 소수를 구하라한다면, 2~54까지 나누는 식을 만들어 본다.
		for(int i=2; i<num; i++) {
			if(num%2 == 0)  return false;
		} //for
		return false;
		
	
	}//boolean

}
