package com.ruby.java.ch06;

public class ArmorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Armor suit = new Armor();
		suit = null; //아무 값도 가지지 않는다.
		suit.setName("mark6");
		suit.setHeight(180);
		System.out.println(suit.getName()+" : "+suit.getHeight());
	}

}
