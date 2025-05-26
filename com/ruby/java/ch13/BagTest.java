package com.ruby.java.ch13;
//제네릭 클래스 618p 622p
class Bag<T, N>{
	private T thing;
	private N name;
	
	public Bag(T thing, N name) {
		this.thing = thing;
		this.name = name;
	}

	
	public T getThing() // T : 자기가 할당한 타입을 가져온다
	{
		return thing;
	}
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public N getName()
	{
		return name;
	}
	public void setName(N name) {
		this.name = name;
	}
	
	void showType() {
		System.out.println("T의 타입은"+ thing.getClass().getName());
		System.out.println("N의 타입은"+ name.getClass().getName());
	}
}

class Book {
	public String toString() {
		return "책";
	}
	
}
class PencilCase {
	
}
class Notebook {
	
}


public class BagTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bag<Book, String> bag = new Bag<Book, String>(new Book(), "과학");
	
		bag.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is :"+ book);
		System.out.println("Thing is :"+ name);
		
		
		
		
		}

}







