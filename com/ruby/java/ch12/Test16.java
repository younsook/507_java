package com.ruby.java.ch12;
//12 입출력 작업하기
// 역직렬화 608p
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt"))){
			UserBean user = (UserBean) in.readObject();
			System.out.println(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
