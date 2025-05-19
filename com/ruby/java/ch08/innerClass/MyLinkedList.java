package com.ruby.java.ch08.innerClass;

public class MyLinkedList {

	private Node head = null;

	//내부 클래스 Node : MyLinkedList$Node.class 생성됨.
	private class Node {
		private String data;
		private Node link;
		//생성자
		public Node(String data) {
			this.data = data;		}
	}

	public void add(String data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			//head가 null이면 Node 로 채워. 그대신 next라는 임시 참조변수를 설정해줘야해. myList를 바꾸면안되.
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	//node데이터가 어떻게 들어오는지 디버깅으로 확인하며 이해하기.
	public void remove(String data) {
		// TODO Auto-generated method stub
		// node java, link에서 node servlet null로 연결하기. 그것이 remove
		
		if(head == null) return;
		
		
		
		Node next = head;
		Node pre = null;
		while (next.link != null) {
			
			if (data.equals(next.data)) {
				pre.link = next.link;
				break;
			}
			pre = next;
			next = next.link;
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
