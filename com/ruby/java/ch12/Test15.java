package com.ruby.java.ch12;
//Serializable 인터페이스 605p
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean("purum", "오정임", "010-123-4567", "서울");
		
		try(ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("user.txt"))) {
			out.writeObject(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
				
	}
	

}
