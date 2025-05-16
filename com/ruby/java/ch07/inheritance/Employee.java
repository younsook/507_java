package com.ruby.java.ch07.inheritance;

public class Employee extends Person{ //클래스명은 항상 대문자 시작

	private String dept;

	
	public Employee() {
		super(); // 부모 클래스(Person)의 생성자 호출, 반드시 첫 줄
		System.out.println("Employee 생성자 실행");
	}
	
//	public Employee(int o) {
//		super(null,o); // 부모 클래스(Person)의 생성자 호출, 반드시 첫 줄
//		System.out.println("Employee 생성자 실행");
//	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
		System.out.println("Employee(name,age,dept) 생성자 실행!");
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		//return this.getName()+":" +this.getAge()+":"+ dept;
		//return super.toString()+":"+ dept ;
		return super.toString() + " (부서: " + dept + ")";
		// 예시 출력: 홍길동:30:회계부
	}

//	@Override
//	public String toString() {
//		return name+":"+ age +":"+ dept;
//	}
	
	 


}
