package 자바_3장_배열;

public class Test33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int []arr = new int[4];
		/*
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		 */
		
		//객체 배열을 만들고 초기화
		int []arr = {10, 20, 30, 40, 50, 60};
		for (int i=0; i<arr.length; i++) {
			// 변수 i의 범위 : scope는 for문 내로 국한
			System.out.print(arr[i]+" ");
		}
		
		//int []score;
		//score = new int[]{1,2,3,4,5};
		
		
		arr = new int[]{10, 20, 30};
		System.out.println("\n");
		for(int i=0; i<10; i++) {
			System.out.print(arr[i] +" ");
		}
		
		
		
		
		
		
		
	}

}
