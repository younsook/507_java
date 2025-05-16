package com.ruby.java.ch04배열;

import java.util.Random;

public class 실습_4_5_행렬연산_3 {
	private static Random rd = new Random();
	public static void main(String[] args) {
		
		int[][] A = setMatrixRandom(3,5);
		printMatrix(A, "Matrix A");
		
		int[][] B = setMatrixRandom(3,5);
		printMatrix(B, "Matrix B");
	}
	
	private static int[][] setMatrixRandom(int row, int col){
		int[][] a = new int[col][row];
		for(int i=0; i<a.length;i++) {
			for (int j=0; j<a[0].length;j++) {
				a[i][j] = rd.nextInt(11);
			}
		}
		return a;
	}
	
	private static void printMatrix(int[][] a, String msg) {
		System.out.println(msg);
		System.out.println("-".repeat(15));
		for (int i=0; i<a.length;i++) {
			for (int j=0; j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(15));
	}
}

