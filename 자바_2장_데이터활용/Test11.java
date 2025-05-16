package 자바_2장_데이터활용;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 42;
		//String bnum = Integer.toBinaryString(num); //2진법 함수
		String st = Integer.toHexString(num); //16진법 함수 
		System.out.println(st);
		// 101010  =  32+8+2=42 //2진법 함수
		//2a  10=a 이기때문
	}

}
