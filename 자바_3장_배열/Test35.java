package 자바_3장_배열;

public class Test35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {10, 20, 30, 40, 50};
		
		//확장 for문 
		//num은 어떤변수명이든 상관없다.
		//배열의 모든값을 출력할때 사용함. for문안에 if문 넣는경우 사용안됨.
		for(int num : arr) {
			System.out.print(num +" ");
		}
		System.out.println();
		for (int i=0; i<arr.length;i++) {
			if(arr[i]>30)
				System.out.print(arr[i]+" ");
		}
	}

}
