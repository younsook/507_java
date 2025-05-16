package 자바_3장_배열;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//행열 출력 1 방법
		int [][]arr=new int[5][5];
		Random rnd = new Random();
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				arr[i][j]=rnd.nextInt(100); //100이하의 난수를
			}
		}
		for (int i=0;i<arr.length;i++) { //2차원 배열에서 행의 길이
			for (int j=0;j<arr[0].length;j++) { // 2차원 배열에서 열의 길이
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		//행열 출력 2 방법
		//2차원 배열에서 확장형 for문 사용
		for (int[] row : arr) { //int[] row는 각 행을 나타낸다.
			for (int v : row) { //row 변수가 각 행이므로 1차원 배열
				System.out.print(v+" ");
			}
			System.out.println();
		}
		
		
	}

}
