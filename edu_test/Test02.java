package edu_test;

import java.util.ArrayList;
import java.util.HashMap;

class Item{
	String name;
	Integer pid;
	
	//부모생성자
	public Item(String name, Integer pid) {
		this.name = name;
		this.pid = pid;
	}

	@Override
	public String toString() {
//		return "Item [name=" + name + ", pid=" + pid + "]";
		return name +":"+pid;
	}
	
}
class ItemA extends Item {
	String size;
	
	//생성자
	public ItemA(String name, Integer pid, String size) {
		super(name, pid);
		this.size = size;
	}

	@Override
	public String toString() {
//		return "ItemA [size=" + size + "]";
		return super.toString() +":"+size;
	}
	
}
class ItemB extends Item {
	String ItemA;
	private String color;
	
	public ItemB(String name, Integer pid, String color) {
		super(name, pid);
		this.color = color;
	}
	@Override
	public String toString() {
//		return "ItemB [color=" + color + "]";
		return super.toString() +":"+color;
	}
	
}
public class Test02 {
	public static void main(String[] args) {
//		ItemA a = new ItemA("Name", 100, "XXL");
//		ItemB b = new ItemB("Name", 100, "RED");
		
		ArrayList<Item> list = new ArrayList<>();
		list.add(new ItemA("NameA", 100, "XXL"));
		list.add(new ItemB("NameB", 100, "RED"));
		
		for(Item item : list ) {
			System.out.println(item);
		}
		
		System.out.println("-".repeat(10));
		HashMap<Integer, Item> map = new HashMap<>();
//		HashMap<String, Item> map = new HashMap<>();
//		map.put("itemA", new ItemA("NameA", 100, "XXL"));
//		map.put("ItemB", new ItemB("NameB", 100, "RED"));
//		
//		System.out.println(map.get("itemA"));
		
		map.put(1, new ItemA("NameA", 100, "XXL"));
		map.put(2, new ItemB("NameB", 100, "RED"));
		
		System.out.println(map.get(1));
		
		System.out.println(map.get(2));
		
	}
}
