package 자바_3장_배열;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[3] = 19;
		arr[4] = 29;
		
		//System.out.println(arr[0]);
		
		// 최대값, 최소값, 평균 구하기.
		// 작은값을 두고 루프, 큰값을 두고 루프
		int sum =0;
		int smax = 0;
		int smin = 99;
		
		for (int j=0; j<5; j++) {
			if (smin > arr[j]) {
				smin = arr[j];				
			} //
			if (smax < arr[j]) {
				smax = arr[j];				
			}//
			sum += arr[j];			
		}//
		System.out.println("최대값"+smax);
		System.out.println("최소값"+smin);
		System.out.println("합"+sum);
		

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
		

	
		
		
		
		
		
		
		
		
		
		
	}

}
