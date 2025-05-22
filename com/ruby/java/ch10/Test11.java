package com.ruby.java.ch10;

import java.util.HashSet;
import java.util.Iterator;

class User {
	String ssn;
	String name;
	User(String ssn, String name){
		this.ssn = ssn;
		this.name = name;
	}
	public String toString() {
		return ssn+" : "+name;
	}
	
	public int hashCode() {
		return Integer.parseInt(ssn);
	}
	//ssn 시리얼 넘버가 같으면 같은객체로 본다. u1에 값이 있고 u2에 값이 같은것을 판단하는것이 equals(오버라이딩에서 많이사용) , hashCode() 와 함께본다.
	public boolean equals(Object obj) {
		boolean result = false;
		User u = (User) obj;
		if(this.ssn.equals(u.ssn))
			return true;
		return result;
	}
}
public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User("123", "김푸름");
		User u2 = new User("123", "김푸름");
		
		HashSet<User> users = new HashSet<User>();
		
		users.add(u1);
		users.add(u2);
		
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
