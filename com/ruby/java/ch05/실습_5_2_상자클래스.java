package com.ruby.java.ch05;

class Box {

	double width;
	double height;
	double depth;

	// source > using fields
	public Box(double width, double height, double depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public void show() {
		System.out.println("width=" + width + ", height=" + height + ", depth=" + depth);
	}

	// 부피 계산 메소드
	double getVolume() {
		return width * height * depth;
	}

	// 박스의 가로,세로,높이를 scale 비율로 변경
	void resize(double scale) {
		width *= scale;
		height *= scale;
		depth *= scale;
	}

	public void resize(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	// 둘레 길이 계산 메소드
	double getPerimeter() {
		return (width + height) *2;
	}


}

public class 실습_5_2_상자클래스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 박스 객체 생성
		Box box1 = new Box(10, 5, 3);

		// 박스 정보 출력
		box1.show();

		// 부피 계산
		System.out.println("부피계산 : " + box1.getVolume());

		// 박스 크기 변경
		box1.resize(15, 8, 5);
		box1.show();

		// 둘레 길이 계산 메소드
		System.out.println(box1.getPerimeter());

		// 박스를 2배 확대
		box1.resize(0.5);
		box1.show();

//		Box box2 = new Box(4, 7, 3);
//		System.out.println(box2);
//		// box2.show();
//		
//		// 박스 크기 변경
//        box2.resize(9, 3, 8);
//        System.out.println(box2);
//        //box2.show();
//
//        // 박스를 2배 확대
//        box2.resize(1.5);
//        System.out.println(box2);
//        //box2.show();

	}

}
