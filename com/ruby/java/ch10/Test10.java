package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {

	public static void main(String[] args) {
		// 5개를 뽑는다.
		lotto_generator(5);		
	}

	private static void lotto_generator(int n) {
		// TODO Auto-generated method stub
		Random number = new Random(19820622); //시드번호를 넣고 돌려본다.
		
		//밖에서 출력시 같은값을 5번 돈다.
//		HashSet<Integer> lotto = null;
//		lotto = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) {
			//해시객체를 생성한다.
			HashSet<Integer> lotto = new HashSet<Integer>();

			
//			for(int j=0; lotto.size()<=6;j++) {
//				//1~45
//				lotto.add(number.nextInt(45)+1); 	 
//			}
			
			while(lotto.size()<6) {
				lotto.add(number.nextInt(45)+1);
			}
			
			List<Integer> L = new ArrayList<Integer>(lotto);
//			List<Integer> L2 = new ArrayList<Integer>(lotto);
			//sort 정렬
			Collections.sort(L);
			System.out.println(L);
			
			System.out.println("-".repeat(10));
//			Collections.sort(L2);
//			System.out.println(L2);
		}
		
	}

}
