package chap02;
/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 * train_실습2_4메소드배열전달.java
 */

import java.util.Arrays;
import java.util.Random;
public class MaxOfArrayRand {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	

	static void inputData(int []arr) {//교재 63 - 난수의 생성
		//배열에 저장된 갯수를 저장
		Random rnd = new Random(41); //시드가 41이면 항상 같은 순서의 난수 생성, 시드 없이 실행할 때마다 다른 난수 생성
		for(int i=0;i<arr.length;i++){
			arr[i] = rnd.nextInt(20); //0부터 19까지 중 난수 생성
			//System.out.print(" "+arr[i]+" ");
		}
	}
	private static int findMax(int[] data) {
		//최대값을 리턴한다
		int max= data[0]; //배열 첫번째 값을 지정
		for(int i=0; i<data.length;i++) { //배열을 반복
			//max보다 큰 값이 나오면 max를 그 값으로 바꾼다. 
			if(data[i] > max) {
				max = data[i];
			}
		}
		return max;
	}
	private static boolean findValue(int[] arr, int value) {
		// arr[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for(int i=0; i<arr.length;i++) {
			if(arr[i] == value) {
				return true; //존재하면 true
			}
		}
		return false; //없으면 false로 리턴
	}
	
	private static void reverse(int[] arr) {
		// reverse() 구현
		for (int i=0; i<arr.length / 2; i++) {
			swap(arr, i, arr.length - i -1);
		}
		
	}


	private static void swap(int[] arr, int idx1, int idx2) {
		// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
		int txt = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = txt;
		
	}
	
	private static void showData(String str, int[] arr) {
		// top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		System.out.println("str: "+str);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void main(String[] args) {
		int []arr = new int[10];
		inputData(arr);
		showData("소스데이터",arr);
		int max = findMax(arr);  //구현findMax
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(arr, 3); //구현findValue
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(arr);// 역순으로 출력 64p
		showData("역순 데이터", arr);
				
	}

}
