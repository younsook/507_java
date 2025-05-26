package com.ruby.java.ch13.boundGen;
//제네릭 클래스 627p 
//와일드 카드 630p
class Bag<T extends Solid>{
	private T thing;
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Bag(T thing) {
		this.thing = thing;
	}

	
	public T getThing() // T : 자기가 할당한 타입을 가져온다
	{
		return thing;
	}
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	boolean isSameOwner (Bag<?> obj) {
		if(this.owner.equals(obj.getOwner()))
			return true;
		return false;
	}
	
	
	void showType() {
		System.out.println("T의 타입은"+ thing.getClass().getName());
		
	}
}

class Solid {
	
}
class Liquid {
	
}

class Book extends Solid{
	
}
class PencilCase extends Solid{
	
}
class Notebook extends Solid{
	
}

class Water extends Solid{
	
}
class Coffee extends Solid{
	
}


public class BagTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
//		Bag<Water> bag4 = new Bag<>(new Book()); //오류
//		Bag<Coffee> bag5 = new Bag<>(new Book()); //오류
		
		bag.setOwner("김푸름");
		bag2.setOwner("김푸름");
		bag.isSameOwner(bag2);

		
		boolean result = bag.isSameOwner(bag2);
		if(result) System.out.println("소유자가 동일합니다");
		else System.out.println("소유자가 다릅니다");
		
		
		}

}







