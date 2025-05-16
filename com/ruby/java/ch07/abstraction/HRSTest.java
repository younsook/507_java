package com.ruby.java.ch07.abstraction;

abstract class Employee{
	String name;
	int salary;
	
	public abstract void calsSalary();
	public abstract void calsBonus();
	
}
//abstract class Salesman extends Employee{

class Salesman extends Employee{
	public void calsSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");		
	}

	public void calsBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
		
	}
	
}

class Consultant extends Employee{
	public void calsSalary() {
		System.out.println("Consultant 급여 = 기본급 + 판매 수당");		
	}

	public void calsBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
		
	}
	
}

abstract class Manager extends Employee{
	public void calsSalary() {
		System.out.println("Manager 급여 = 기본급 + 판매 수당");		
	}

	
}

class Director extends Manager{
	public void calsBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
		
	}
	
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		//Manager m = new Manager();
		Director d = new Director();
		
		s.calsBonus();
		c.calsBonus();
		//m.calsSalary();
		d.calsBonus();
	}
	

}
