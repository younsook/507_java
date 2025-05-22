package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("북경"); list.add("상해"); 
		list.add("서울"); list.add("도쿄"); list.add("뉴욕"); 
		
		for(int i =0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("======================");
		
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("======================");
		//확장 for 문
		//for (변수 선언 : 배열 변수명){
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("======================");
		//거꾸로출력
		for(int i = list.size()-1 ; i >= 0 ; i--) {
			System.out.println(list.get(i));
		}
		
		
	}

}
