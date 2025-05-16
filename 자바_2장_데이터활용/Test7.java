package 자바_2장_데이터활용;

public class Test7 {
	public static void main(String[] args) {
		int a = 10;
		int b,c;
		
		b = a++; // a를 먼저 b에 준다 = 10
		c = ++a; // ++ 한 a를 c에 준다. = 12
		System.out.println("a=" + a+", b="+b+", c="+c);
		
		int num = -a; //negation 연산자 (부호연산자)
		System.out.println("num="+num);
		short e = 10;
		short f = (short) -e; //negation 연산 결과는 int 숫자이기때문. =-e; 는 에러.
		
		boolean isOn = false;
		boolean result = !isOn; //부정 연산자
		while (!isOn) {
			
		}
		
	}

}
