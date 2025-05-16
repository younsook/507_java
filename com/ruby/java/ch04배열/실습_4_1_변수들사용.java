package com.ruby.java.ch04배열;
/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수들사용 {
	//5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
	//최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
	public static void main(String[] args) {
		// 변수 5개 선언하기. 값 할당하기.
		/*	int score1 = 49;
		int score2 = 91;
		int score3 = 87;
		int score4 = 67;
		int score5 = 73;
		
		// 최대 점수, 최소, 평균 구하기
		
		int age = (score1+score2+score3+score4+score5)/5;
		
		int max = score1;
		if (max < score2) {
			max = score2;
		}
		if (max < score3) {
			max = score3;
		}
		if (max < score4) {
			max = score4;
		}
		if (max < score5) {
			max = score5;
		}
		
		int min = score1;
		if (min > score2) {
			min = score2;
		}
		if (min > score3) {
			min = score3;
		}
		if (min > score4) {
			min = score4;
		}
		if (min > score5) {
			min = score5;
		}

		
		
		System.out.println("최대 점수"+ max);
		System.out.println("최소 점수"+ min);
		System.out.println("평균 점수"+ age);
*/
		
		/* for문으로 결과안나옴.
		for(int i=0; i< score;i++) {
			if(max < i) {
				max = i;
			}
			if(min > i) {
				min = i;
			}
		}//for	*/
		
		int score1 = 49;
		int score2 = 91;
		int score3 = 87;
		int score4 = 67;
		int score5 = 73;
				
		System.out.println("최대 점수 :"+ max(score1, score2,score3,score4,score5));
		System.out.println("최소 점수 :"+ min(score1, score2,score3,score4,score5));
		System.out.println("평균 점수 :"+ avg(score1, score2,score3,score4,score5));

	}
	static int avg(int...v) {
		int sum =0;
		for(int x : v) {
			sum +=x;
		}
		return sum/v.length;
	}
	static int max(int...v) {
		int smax = 0; //초기값을 선언한다.
		for(int x : v) { //v값을 가져와서 x에 넣는다.
			if (smax < x) { //49가 0보다 크다 
				smax = x ; //smax 는 49이다.
			}
		}
		return smax;
	}
	static int min(int...v) {
		int smin = 100; 
		for(int x : v) {
			if (smin > x) { 
				smin = x;
			}
		}
		return smin;
	}

}

