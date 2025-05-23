package com.ruby.java.ch12;
//12 입출력 작업하기
//파일 입출력 560p
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fi = new FileInputStream("a.txt");
				FileOutputStream fo = new FileOutputStream("b.txt");){
			int c = 0;
			while((c=fi.read()) != -1) {
				fo.write(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
