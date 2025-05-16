package com.ruby.java.ch04배열;

public class 실습_4_2_배열생성최대값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1차원 배열 생성 및 초기화
		/*
		 * 정수 1차원 배열 price를 선언하고 5개 값으로 초기화:
		 * 49, 91, 87, 67, 73
		 */
		
        // for문을 사용한 최대값 찾기
		/*
		 * 최대값 변수를 priceMax로 선언한 후에 for 문을 사용하여 최대값을 찾는다
		 * 배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
		 * [1,2,3,4,5]
		 * 최대값 출력은 다음과 같다
		 * 최대값 = **
		 * 
		 */
		
		//1차원 배열 생성 및 초기화
		int[] price = {49, 91, 87, 67, 73};
		
		// for문을 사용한 최대값 찾기
		int pMax = 0;
		for(int i=0;i<price.length;i++) {
			if(pMax < price[i]) {
				pMax = price[i];	
			}
		}
		System.out.println("최대값 = "+pMax);
		
		// 배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다: [1,2,3,4,5]
		
		System.out.print("[");
		int count = 0;
		for(int j : price) {
			System.out.print(j);
			count++;
			if(count < price.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		

		
		/*
		// [11, 22, 33, 19, 29] 이렇게 출력하기.
		System.out.print("[");
		for(int i=0; i<5; i++) {
			if (i==4) {
				System.out.print(arr[i]);
			}else {
			System.out.print(arr[i]+", ");
			} //if
		} //for
		System.out.println("]");
		 */
		/*
		System.out.print("[");
		int count = 0;
		for (int j : price) {
		    System.out.print(j);
		    count++;
		    if (count < price.length) {
		        System.out.print(", ");
		    }
		}
		System.out.println("]");
		*/
		
	}

}
