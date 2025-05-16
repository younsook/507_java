package 자바_2장_데이터활용;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		int nc = c;
		System.out.println("nc="+nc);
		c ^= (1 << 5);
		System.out.println(c);
		nc = c;
		System.out.println(nc);
		
		int a=10;
		int b=20;
		int max=(a>b)? a:b; //3항연산자. ()괄호 1항 ? 물음표 a 이냐? b 이냐?
		System.out.println(max);
		
		byte i=10;
		byte j=20;
		//byte k=i+j; // 자바에서 덧셈은 int 정수 기반 결과를 만든다. k=i+j;  에러임.
		//byte k=(byte)(i+j);
	}

}
