package com.ruby.java.ch08.polymorphism;

public class cha08_test_내부클래스구현 {
	private Node head;
	
	public cha08_test_내부클래스구현() {//소속된 클래스 생성자
		head = null;
	}
	
	private class Node {//내부클래스
		private String data;
		private Node link;

		public Node(String data) {//내부클래스 생성자
			this.data = data;
			this.link = null;
		}
	}
	public void add(String data) {
		//add하는 알고리즘 > 자료구조 + 알고리즘 =>문제 해결을 위한 논리적 사고 훈련
		Node temp = new Node(data); // 내부클래스 생성자를 부른다.
		Node p = head;
		Node q = null;
		
		if (p == null) {
			head = temp;
			return;
		}
		while (p != null) {
			q = p;
			p = p.link;
		}
		q.link = temp;
		
		

	}
	
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
		Node p = head;
		while (p != null) {
			System.out.print(p.data);
			if (p.link != null) {
				System.out.print(" -> ");
			}
			p = p.link;
		}
		System.out.println();
	}
	
	public void delete(String data) {
		//삭제 구현
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cha08_test_내부클래스구현 myList = new cha08_test_내부클래스구현();
//		myList.printList();

		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		myList.printList();
		
		myList.delete("CSS");
		myList.printList();
	}

}
