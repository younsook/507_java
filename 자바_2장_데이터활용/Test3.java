package 자바_2장_데이터활용;

public class Test3 {
	public static void main(String[] args) {
		long totalSales;
		// L은 long int literal 로 인식하게 한다.
		totalSales = 2147483648L; //(마지막에 L을 안붙이면)단순 숫자는 int literal로 인식한다.
		System.out.println(totalSales);
		
		float exchangeRate = (float) 1134.50; //type casting 한다.// = 1134.50f 와 동일 //(float) 1134.50
		
		
		String name = "Amy";
		String greet = "Hello, how are you! i am fine ~~~~";
		System.out.println("greet의 길이 =" + greet.length());
		System.out.println("greet 변수 길이 =" + greet.length());
	}
}
