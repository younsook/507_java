package 자바_2장_데이터활용;

public class Test2 {
	// main 입력 후 ctrl + space = 자동완성 됨.
	public static void main(String[] args) {
		// 데이터 타입 : int, short, byte, long 
		int depositAmount;
		depositAmount = 50000;
		//sysout 입력 후 ctrl + space
		System.out.println(depositAmount);
		boolean isMarried = false;
		isMarried = true;
		System.out.println("inMarried = "+ isMarried);
		char ch = 'A';
		int num = ch;
		num = num + 1; //66
		ch = (char)num; //4바이트를 2바이트 저장하려고 하니 정보 오류발생 > (char)num 으로 바꾸기.
		//type casting 이라고 한다. 
		//System.out.println("num = " + num); //66 
		System.out.print("\n\tnum = " + ch); //B 
		
		//String greeting = "good morning";
		//long d = 2147483648;
		
		
	}

	
}
