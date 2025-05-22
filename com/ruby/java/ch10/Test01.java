package com.ruby.java.ch10;
//제네릭이란? 467p
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("북경"); list.add("상해"); 
		list.add("서울"); list.add("도쿄"); list.add("뉴욕"); 
		list.add("런던"); list.add("로마"); list.add("방콕"); 
		list.add("북경"); list.add("도쿄"); list.add("서울"); 
		
		for(int i =0; i< list.size(); i++) {
//			System.out.println(list.get(i));
		}
		
		System.out.println("1 : "+list.toString());
		
		//void add(int index, E element)
		list.add(1, "LA"); print(2, list);
		
		//int indexOf
		System.out.println("3 : "+list.indexOf("서울"));
		System.out.println("4 : "+list.lastIndexOf("서울"));
		
		//boolean
		list.remove("LA"); print(5, list);
		
		//E
		list.remove(2); print(6, list);
		
		//boolean contains
		System.out.println("7 : "+list.contains("LA"));
		
		//object
		Object obj[] = list.toArray();
		System.out.println("8 : "+Arrays.toString(obj));
		
		//T[]
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : "+ Arrays.toString(cities));
		
		//clear
		list.clear(); print(10, list);
		
		//isEmpty
		System.out.println("11 : "+list.isEmpty());
		
		list.add("파리");
		list.add("방콕");
		list.add("LA");
		
		//Arrays
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");
		print(12, list2);
		
		//addAll
		list.addAll(list2); print(13, list);
		
		//containsAll
		System.out.println("14 : "+list.containsAll(list2));
		
		//retainAll
		list.retainAll(list2); print(15, list);
		
		//removeAll
		list.removeAll(list2); print(16, list);

		
	}

	private static void print(int n, List<String> list) {
		// TODO Auto-generated method stub
		System.out.println(n+" : "+list);
		
	}

}
