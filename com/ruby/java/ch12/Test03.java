package com.ruby.java.ch12;
//12 입출력 작업하기
//필터 스트림 활용 BufferedReader / BufferedWriter 509p
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println("Hello" + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
