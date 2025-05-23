
package com.ruby.java.ch11.exception;

//catch된 객체를 출력하는 실습
public class Test01 {

	public static void main(String[] args) {
		int arr2[] = new int[3];
//		arr2[3] = 0;
		
//		int n = 10;
//		n = n/0;

		String st = "hello";
//		st = null;
//		System.out.println(st.length()); //예외 발생 > JVM처리 - 종료

		try {
			String s = new String("java");
			int len = s.length();
//			s = null;
			s.length(); // new NullPointerException() > throw 던지기 하는거야.받는것은 catch 로 간다. 1.
			int arr[] = new int[3];
			arr[3] = 30; // new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		}
		
		 catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다
			 //상위 예외 처리 후 하위 예외 처리불가. 에러남. 하위 ArrayIndexOut...등 먼저실행해줘야함.
			System.out.println("Exception 처리"); 
		 }
//		  catch는 해당되는거 모두 실행.
		 
		catch (ArrayIndexOutOfBoundsException e1) {
			e1.getMessage(); //Throwable 인터페이스
			e1.printStackTrace();// 교재 542
			System.out.println(e1.getMessage());// 교재 542
		} 
		catch (NullPointerException e2) { // 예외를 프린트로 찍었어. 2.
			//e2.
			e2.printStackTrace();
			System.out.print(e2.getMessage());
			System.out.println();
		} 
		catch (Exception e) {// 순서상 마지막에 와야 한다.  이유는? upcasting 가능, downcasting 불가.
			//runtime 보다 위에 있기때문에. 맨위에 있으면 에러남.(업캐스팅,다운캐스팅 개념알기) e 로 받을수있다.	
			System.out.println("오류 발생 : " + e);// e.toString()
		} 
		finally {// try block에서 할당된 자원의 해제 처리 finally는 무조건 실행함.
			System.out.println("GOOD");
		}
	}
}