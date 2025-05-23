package com.ruby.java.ch12;
//12 입출력 작업하기
import java.io.FileInputStream;
import java.io.FileReader;

public class Test01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fi = new FileInputStream("tt.txt")){
			int c = 0;
			while((c=fi.read()) != -1) {
				System.out.println(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-".repeat(10));
		try(FileReader fr = new FileReader("tt.txt")){
			int c =0;
			while((c=fr.read()) != -1) {
				System.out.println(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//입력 스트림의 차이에 따라 어떻게 출력이 달라지는지 확인해보자.
		//Stream 계열은 1바이트 단위로 읽거나 쓴다.
		//Reader / Writer 계열을 1바이트 이상 단위로 읽거나 쓴다.
		//-영문, 숫자인 경우에는 1바이트 단위
		//-한글의 경우에는 2~3바이트 단위
		
	}

}
