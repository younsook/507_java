package com.ruby.java.ch08;

//내부적으로 enum 클래스의 상속을 받아서 사용.
enum Status {
	//만들어진 열거형 데이터를 많이 가져다 쓴다.
	READY, SEND, COMPLETE, CLOSE
}

public class EnumTest01 {
	public static void main(String[] args) {
		Status work = null;
		int n = 2;
		
		switch (n) {
		case 1:
			work = Status.READY;
			break;

		case 2:
			work = Status.SEND;
			break;

		case 3:
			work = Status.COMPLETE;
			break;

		case 4:
			work = Status.CLOSE;
			break;
		}
		System.out.println("현재 작업 상태 : "+ work);
		
		
		
		}
	}
