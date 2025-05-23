package com.ruby.java.ch11.exception;
/*
 * 자료구조에서 사용할 예외처리 > stack과 queue에서 사용 
 */
class NagativeNumberException extends Exception {
	public NagativeNumberException() {
		super("음수는 허용하지 않습니다");//예외 발생시에 출력되는 위치를 확인 필요 
	}
}

public class Test05 {

	int battery = 0;

	void charge(int time) { //멤버 함수
		//Test05의 멤버함수이므로 new를 반드시해줘야함.

		if (time < 0) {
			time = 0;
			try {
				throw new NagativeNumberException();
			} catch (NagativeNumberException e) { // 내가만든 예외를 발생시킨다.
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		battery += time;
		System.out.println("현재 배터리 : " + battery);

	}

	public static void main(String[] args) { //멤버 함수 
		//static 클래스메소드 : JVM 에서 바로 호출 클래스 객체를 만들지 않아도.

		Test05 test = new Test05(); //반드시 객체를 만들어야한다. 객체마다 부르기위해. 여기서 new 한다. 
		test.charge(30);
		test.charge(20);
		test.charge(-10);
	}
}
