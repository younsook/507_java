package com.ruby.java.ch08.innerClass;

import com.ruby.java.ch07.abstraction.Messenger;

public class OuterClassTest {

	public static void main(String[] args) {
		Messenger test = new Messenger() {

			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "test";
			}

			@Override
			public void setMessage(String msg) {
				// TODO Auto-generated method stub
				System.out.println("test에 메시지를 설정합니다. :"+msg);				
			}			
		}; //Messenger test = new Messenger() {
		
		System.out.println(test.getMessage());
		test.setMessage("have a nice day!");
	}

}
