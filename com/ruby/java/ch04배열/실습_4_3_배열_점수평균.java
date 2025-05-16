package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 배열 사용, 난수로 입력된 10명의 성적 평균 구하기
 * Random rd =new Random();
 * score[i] = rd. nextInt(100);//0 ~ 99 정수 생성
 * 
 * 10명 학생의 학점 출력:
 *    ~90 A, ~80 B, ~70 C, ~60 D, 59~ F
 *    출력은 "99점 - A 학점" 등으로 출력한다.
 */
public class 실습_4_3_배열_점수평균 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//학생 10명 성적을 저장할 배열 선언
		int score[] = new int[10];
		Random rd = new Random();
		
		//학생 10명의 성적을 입력(Random : 0~99)
		for (int i=0;i<score.length;i++) {
			score[i]=rd.nextInt(100);
		}
		//학생 개인 성적 출력 (A-F)
		for (int i=0;i<score.length;i++) {
			System.out.print(score[i] +" : ");
			if (score[i] >= 90) System.out.println("A");
			else if(score[i] >= 80) System.out.println("B");
			else if(score[i] >= 70) System.out.println("C");
			else if(score[i] >= 60) System.out.println("D");
			else 					System.out.println("F");
		}
		
	}

}
