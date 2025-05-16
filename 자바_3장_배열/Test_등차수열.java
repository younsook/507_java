package 자바_3장_배열;

public class Test_등차수열 {

	public static void main(String[] args) {

		//등차수열을 배열로 구현하기.
		// an = 3+(n-1)2 
		// a1 = 3+(1-1)2
		// arr[i] = 3+(i+1-1)*2
		//결과 [ 3 5 7... ] 형태로 출력 
		
		
		//배열 선언
		int[] arr = new int[10];
				
		System.out.print("[");
		for(int i=0; i<10; i++) {
			//등차수열 구현 an = 3+(n-1)2 
			arr[i] = 3+(i+1-1)*2 ;
			if (i==9) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+", ");
			} //if
		} //for
		System.out.println("]");
	}

}
