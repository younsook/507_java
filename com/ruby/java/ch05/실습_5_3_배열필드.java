package com.ruby.java.ch05;

public class 실습_5_3_배열필드 {
	static class Person { //static 이 없으면 내부에서 사용못함.
		// 필드 (private)
		/*
		 * name은 String, age는 int, weight는 float로 필드들을 private 선언 subjects을 교육과목 private
		 * 배열 years을 수강 연도 private 배열 count 필드를 사용하여 수강 과목 증가시마다 ++count
		 */
		// 필드
		// 필드 (private)
		private String name;
		private int age;
		private float weight;
		private String[] subjects;
		private int[] years;
		
		// 메소드
		public void show() {
			// 기본 정보 출력::name=**, age=**, weight=**로 출력


			System.out.println("name="+name+", age="+age+", weight="+weight);
			
			//+"subjects="+subjects+"years="+years
			// 교육과목 및 수강 연도 출력
			//while 문을 사용하여 교육과목과 수강연도를 출력
			
			int i=0;
			while (i < subjects.length) {
				System.out.println("교육과목 : "+subjects[i]);
				i++;			
			}
			int j=0;
			while (j < years.length) {
				System.out.print(years[j]+" ");
				j++;
			}System.out.println();
			 
		}//public void show()
		
//		// 과목, 수강연도를 매개변수로 전달받아 배열에 추가
//		void addSubjectYear(String subject, int year) {
//			
//		}
	}//static class Person

	
		public static void main(String[] args) {
			// 첫 번째 객체 생성 및 초기화
			Person p1 = new Person(); //Person 클래스 이름이 데이터 타입이됨
			// 다음 코드를 setter, addSubjectYear를 사용하여 수정
			p1.name = "홍길동";
			p1.age = 25;
			p1.weight = 60.56f;
			p1.subjects = new String[] { "Mathematics", "Science", "History" };
			p1.years = new int[] { 2020, 2021, 2022 };

			// 메소드 호출
			p1.show();

			// 두 번째 객체 생성 및 초기화
			Person p2 = new Person();
			p2.name = "강감찬";
			p2.age = 55;
			p2.weight = 62.34f;
			p2.subjects = new String[] { "Literature", "Philosophy", "Physics" };
			p2.years = new int[] { 2018, 2019, 2020 };

			// 메소드 호출
			p2.show();
		}//public static void main(String[] args)
	}
