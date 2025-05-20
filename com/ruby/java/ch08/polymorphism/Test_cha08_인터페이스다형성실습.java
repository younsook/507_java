package com.ruby.java.ch08.polymorphism;

/*
 * 인터페이스 다형성 실습 코드
 * 생성자에서 this()를 사용, super()를 사용
 * 추상 메소드 구현에서 super.추상메소드를 사용하는 구현 실습이 목적임 
 */
interface Vehicle { // 인터페이스
	public abstract void showVehicle(); // 추상 메소드
}

//Truck 
class Truck implements Vehicle {
	int weight;

	public Truck(int weight) {
		this.weight = weight;
	}

	public void showVehicle() {
		System.out.println("Truck: weight=" + weight);
	}
}

//car
class Car implements Vehicle {
	int vehicleOccupants;

	// 기본 생성자
	public Car() {

	}
	// 생성자 오버라이딩
	public Car(int vehicleOccupants) {
		this.vehicleOccupants = vehicleOccupants;
	}
	
	public void showVehicle() {
		System.out.println("Car: vehicleOccupants=" + vehicleOccupants);
	}

}

//Taxi
class Taxi extends Car {
	int mileage;
	int price; 
	
	public Taxi(int mileage, int price) {
		this.mileage = mileage;
		this.price = price;
	}
	
	public void showVehicle() {
		//부모 클래스의 메소드 호출
		super.showVehicle();
		System.out.println("Taxi: mileage=" + mileage+", price="+price);
	}

}

//MotorCycle
class MotorCycle implements Vehicle {
	int price;
	
	public MotorCycle(int price) {
		this.price = price;
	}
	
	public void showVehicle() {
		System.out.println("MotorCycle : price=" + price);
	}

}

public class Test_cha08_인터페이스다형성실습 {
	// Vehicle v = new Vehicle() {생성한것을 (Vehicle [] a) 배열로 받고
	public static void displayVehicles(Vehicle[] a) { 
		for (Vehicle v : a) {
			v.showVehicle();// v의 타입을 실행 시간에 확인하여 해당 클래스의 메소드로 바인딩
		}
	}

	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[5];
		arr[0] = new Truck(33);
		arr[1] = new Car(4);
		arr[2] = new Taxi(2, 9000);// 생성자가 super()를 사용
		arr[3] = new Truck(22);
		arr[4] = new MotorCycle(12000);
		
		
		displayVehicles(arr);
		Vehicle v = new Vehicle() {// 익명클래스 -익명객체 > 리액트/스프링부트에서 사용
			public void showVehicle() {
				System.out.println("Vehicle: 익명 클래스 ");
			}
		};
		v.showVehicle();
	}
}
