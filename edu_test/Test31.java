package edu_test;
//반복문 중첩 138p
//연습해보기...
import java.util.Scanner;

public class Test31 {

	public static void main(String[] args) {
		
		//scanner 기억
		Scanner scanner = new Scanner(System.in);
		System.out.println("num1:");
		int num1 = scanner.nextInt();
		System.out.println("num2:");
		int num2 = scanner.nextInt();
		
		//min, max 선언해서 변경해보기
		
		if (num1 < num2) {
			// 숫자 두개를 입력받아서 작은수부터 큰수까지 단을 출력하라 5 2 입력하면 2단부터 5단까지 출력하라 
			for(int i=num1; i<=num2; i++) {
				for(int j=1; j<10; j++) {
					System.out.println(i+"*"+j+"="+(i*j));
				}
				System.out.println();
			}
		}else {
			for(int i=num2; i<=num1; i++) {
				for(int j=1; j<10; j++) {
					System.out.println(i+"*"+j+"="+(i*j));
				}
				System.out.println();
			}
			
		} //if
		
		scanner.close();
	}

}
