package com.ruby.java.ch04배열;

import java.util.Random;

public class 실습_4_5_행렬연산_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = new int[3][5];
		int[][] B = new int[3][5];
		int[][] C = new int[3][5];
		int[][] D = new int[5][4];
		int[][] E = new int[3][4];
		Random rd = new Random();
		
		System.out.println("표 A: ");
		for (int i=0;i<A.length;i++) {
			for (int j=0;j<A[i].length;j++) {
				A[i][j] = rd.nextInt(101);
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("표 B: ");
		for (int i=0;i<B.length;i++) {
			for (int j=0;j<B[i].length;j++) {
				B[i][j] = rd.nextInt(101);
				System.out.print(B[i][j]+"\t");
			}
			System.out.println();
		}
		
//		3. C = A + B
//		A와 B의 각 자리에 있는 값을 더해서 C라는 새로운 표를 만든다.
//		예: C[0][0] = A[0][0] + B[0][0]
		System.out.println("표 C = A + B: ");
		for (int i=0;i<C.length;i++) {
			for (int j=0;j<C[i].length;j++) {
				C[i][j] += A[i][j] + B[i][j];
				System.out.print(C[i][j]+"\t");
			}
			System.out.println();
		}
		
//		4. 5줄 4칸짜리 표 D를 만든다.
//		D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자.

		System.out.println("표 D[5][4]:");
		for (int i=0; i<D.length;i++) {
			for (int j=0; j<D[i].length;j++) {
				D[i][j] = rd.nextInt(0,101);
				System.out.print(D[i][j]+"\t");
			}
			System.out.println();
		}
		
//		5. E = A × D (행렬 곱셈)
//		A(3x5)와 D(5x4)를 곱해서 E(3x4)라는 표를 만든다.
//		E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]	
		System.out.println("표 E = A × D (행렬 곱셈):");
		for (int i=0;i<E.length;i++) {
			for (int j=0;j<E[i].length;j++) {
				E[i][j] += A[i][j] * D[i][j];
				System.out.print(E[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
