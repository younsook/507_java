//함수에 throw절을 추가하는 경우 - 함수내에서 throw할 수 있고 호출하는 코드에서 예외를 반드시 처리해야 한다
package com.ruby.java.ch11.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test04 {
	public static void c() throws Exception {
		System.out.println("c():: 실행"); //2.
		throw(new Exception());
	}
	//throws는 메서드를 호출한 곳으로 예외를 던지는 명령문이기 때문이다.
	public static void b() throws Exception {
		try {
			c(); //2.

		}catch(Exception e) {
			System.out.println("C():: 예외처리"); // 3.
		}

	}
	//*
	public static void main(String[] args) {
		try {
		//Unhandled exception type FileNotFoundException
			FileInputStream fi = new FileInputStream("a.txt");//에러 발생 이유
			int c = fi.read();
			System.out.println((char) c); // 1.h
			b();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*/
/*
	public static void main(String[] args) throws FileNotFoundException, IOException { //throws 그쪽에서 예외를 실행한다.
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
	}
	/*/
}