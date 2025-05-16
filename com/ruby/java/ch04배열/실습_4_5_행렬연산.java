package com.ruby.java.ch04배열;
/*
 * 2차원 배열과 행렬 연산
 * 
 * 학습 목표
 *  1) 2차원 배열 만들기
 *  2) 난수로 배열 값 채우기
 *  3) 배열 간 덧셈, 곱셈, 전치(transpose) 개념 익히기
 *  4) 두 배열이 같은지 비교하기
 *  5) 배열을 테이블 형태로 출력하기
 *  
 *  구체적 설명:

1. 3줄 5칸짜리 표 A를 만든다.

	A[3][5]는 3명의 학생이 5과목 시험 본 점수표라고 생각하자.

	점수는 0~99 사이의 무작위 숫자로 채운다.

2. 같은 크기의 표 B도 만들어서 무작위 점수로 채운다.

3. C = A + B

	A와 B의 각 자리에 있는 값을 더해서 C라는 새로운 표를 만든다.

	예: C[0][0] = A[0][0] + B[0][0]

4. 5줄 4칸짜리 표 D를 만든다.

	D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자.

5. E = A × D (행렬 곱셈)

	A(3x5)와 D(5x4)를 곱해서 E(3x4)라는 표를 만든다.

	E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]

6. F = D의 전치 행렬 (Transpose)

	D[5][4]의 전치는 F[4][5]가 된다.

	행과 열의 위치를 바꾼 표이다.

7. G = A × F (A 곱하기 D의 전치 행렬)

	A[3][5] × F[5][4] → G[3][4]

8. E와 G가 같은지 비교

	Arrays.deepEquals(E, G) 같은 방법으로 E와 G가 완전히 같은지 확인한다.
9. 2차원 배열을 테이블 형태로 출력한다 

 */

import java.util.Random;

public class 실습_4_5_행렬연산 {
    public static void main(String[] args) {
    	/*
    	 * 1. 3줄 5칸짜리 표 A를 만든다.
    	 * A[3][5]는 3명의 학생이 5과목 시험 본 점수표라고 생각하자.
    	 * 점수는 0~99 사이의 무작위 숫자로 채운다.
    	 * 2. 같은 크기의 표 B도 만들어서 무작위 점수로 채운다.
    	 */
 
        int[][] A = new int[3][5];  // 3명의 학생이 5과목
        int[][] B = new int[3][5];  // 3명의 학생이 5과목
        int[][] C = new int[3][5];  // 결과 배열
        int[][] D = new int[5][4];  // D[5][4]는 예를 들어 과목별 프로젝트 점수
        int[][] E = new int[3][4];  // 결과 행렬: 3명 × 4개 프로젝트
        int[][] F = new int[4][5];  // 전치 행렬: 4행 5열
        int[][] G = new int[3][4];  // 결과: 3행 4열
        Random rd = new Random(); 

        // A배열에 난수 채우기
        // B배열에 난수 채우기
        for (int i = 0; i < A.length; i++) {          // 학생 수 (3명)
            for (int j = 0; j < A[i].length; j++) {   // 과목 수 (5과목)
                A[i][j] = rd.nextInt(100);  // 0~99 난수
                B[i][j] = rd.nextInt(100);  // 0~99 난수
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // 출력 표 A
        System.out.println("표 A:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println(); 
        }

        // 출력 표 B
        System.out.println("표 B:");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }
        
        //3. C = A + B
        //A와 B의 각 자리에 있는 값을 더해서 C라는 새로운 표를 만든다.
        //예: C[0][0] = A[0][0] + B[0][0]
        // 출력 표 C
        System.out.println("표 C:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
            	C[i][j] = A[i][j] + B[i][j];
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();  // 줄 바꿈
        }
        
       // 4. 5줄 4칸짜리 표 D를 만든다.
       //D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자.
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                D[i][j] = rd.nextInt(100);  // 0~99 점수
            }
        }
        
        //5. E = A × D (행렬 곱셈)
        //A(3x5)와 D(5x4)를 곱해서 E(3x4)라는 표를 만든다.
        //E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]
        // 결과 행렬: 3명 × 4개 프로젝트
        System.out.println("표 E:");
        for (int i = 0; i < 3; i++) {         // A의 행
            for (int j = 0; j < 4; j++) {     // D의 열
                E[i][j] = 0;
                for (int k = 0; k < 5; k++) { // A의 열 = D의 행
                    E[i][j] += A[i][k] * D[k][j];          
                }
                System.out.print(E[i][j] + "\t");
            }
            System.out.println();
        }
        
        //6. F = D의 전치 행렬 (Transpose)
        //D[5][4]의 전치는 F[4][5]가 된다.
        //행과 열의 위치를 바꾼 표이다.
        
        
        System.out.println("표 F:");
        for (int i = 0; i < D.length; i++) {         // D의 행
            for (int j = 0; j < D[i].length; j++) {  // D의 열
                F[j][i] = D[i][j];                   // 전치: 행과 열을 바꿈
                System.out.print(F[j][i] + "\t");
            }
            System.out.println();
        }
        
        
        //7. G = A × F (A 곱하기 D의 전치 행렬)
        //A[3][5] × F[5][4] → G[3][4]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                G[i][j] = 0;
                for (int k = 0; k < 5; k++) {
                    G[i][j] += A[i][k] * F[j][k];  // A[3][5] × F[4][5]   
                }
            }
        }
        //D	5×4	원본 프로젝트 점수
        //F	4×5	D의 전치
        //G	3×4	A × F (D의 전치와 곱)
        System.out.println("G = A × F:");
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                System.out.printf(G[i][j] + "\t");
            }
            System.out.println();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        

    }
}


