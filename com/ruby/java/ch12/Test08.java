package com.ruby.java.ch12;
// 프로퍼티 파일 590p
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Reader reader = new FileReader("user.properties")){
			Properties user = new Properties();
			user.load(reader);
			
			System.out.println(user.getProperty("id"));
			System.out.println(user.getProperty("name"));
			System.out.println(user.getProperty("password"));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
