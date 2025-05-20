package com.ruby.java.ch08.innerClass;

/*
 * 외부 클래스 구현 
 */
//Node3 내부클래스
class Node3 {
	int data;
	Node3 link;

	public Node3(int data) {
		this.data = data;
		link = null;
	}
}

//연결리스트 구현
class LinkedList3 {
	Node3 first;

	void append(int data) {
		Node3 p = first, q = null;

	}
	//전체 연결 리스트 출력
	void showList() {
		System.out.println();
		Node3 p = first;

	}
	//삽입
	void insert(int data) {
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;
	}

}

public class Test_ch08_연결리스트와배열 {
	static int getList(int[] data) {
		int count = 0;
		int mid = data.length / 2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5;
			count++;
		}
		return count;
	}

	static void showList(int[] data) {
		
//		System.out.println();	
		//1단계 배열의 인덱스 번호를 출력
		for (int i = 0; i < data.length; i++)
			System.out.print("인덱스 " + i + " ");
		
		System.out.println();
		//2단계 각 배열 값 출력
		for (int i = 0; i < data.length; i++) {
			//10보다 작으면 출력
			if (data[i] < 10)
				System.out.print("=> ");
			System.out.print(data[i] + " ");
		}
	}

	static int insertList(int[] data, int count, int x) {
		if(count < data.length) {
			data[count] = x;
			System.out.println("list:"+count);
			return count +1;
		}else {
			System.out.println("배열이 가득 찼다.");
			return count;		
		}
	}

	
	public static void main(String[] args) {
		int[] list = new int[10]; // 0으로 초기화
		int count = 0;
		
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		
		count = insertList(list, count, 3);
		showList(list);
		
		count = insertList(list, count, 7);
		showList(list);
		
		// -----------------------------
		//연결 리스트 글래스 
		LinkedList3 ll = new LinkedList3();
		ll.append(5);
		ll.append(10);
		ll.append(15);
		ll.append(20);
		ll.append(25);
		ll.showList();
		
		
		
		
		
		
		
		
		ll.insert(3);
		ll.showList();
		
		ll.insert(7);
		ll.showList();
	}
}
