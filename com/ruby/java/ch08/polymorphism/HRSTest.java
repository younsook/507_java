package com.ruby.java.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;

	public abstract void calsSalary();
	public abstract void calsBonus();

}

class Salesman extends Employee {
	int annual_sales; // 연간 판매 실적
	public void calsSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
	public void calsBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	int num_project;
	public void calsSalary() {
		System.out.println("Consultant 급여 = 기본급 + 판매 수당");
	}
	public void calsBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

class Manager extends Employee {
	int num_team;
	public void calsSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
	@Override
	public void calsBonus() {
		// TODO Auto-generated method stub
		
	}
}

class Director extends Manager {
	public void calsBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}



//	public static void calcTax(Employee e) {
//		System.out.println("소득세를 계산합니다.");
//	}

	public static void main(String[] args) {
//		Salesman s = new Salesman();
//		Consultant c = new Consultant();
//		Director d = new Director();

//		calcTax(s);
//		calcTax(c);
//		calcTax(d);
//		Object o;
//		System.out.println(s.toString());
//		System.out.println(c.toString());
//		System.out.println(d.toString());
		
//		Salesman s2 = s;
//		System.out.println(s2.toString());
//		
//		if(s.equals(s2)) {
//			System.out.println("동일한 객체입니다.");
//		}else {
//			System.out.println("서로 다른 객체입니다.");
//		}
		//
		Salesman s1 = new Salesman();
		Employee s2 = new Salesman();
		Object s3 = new Salesman();
		
		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		
		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	
	}

}
