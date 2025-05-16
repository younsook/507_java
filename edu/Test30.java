package edu;
// if문 중첩 135p
public class Test30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =6;
		if((i%2) == 0) {
			System.out.println(i+"은 2의 배수입니다.");
			if((i%3) == 0) {
				System.out.println(i+"은 3의 배수입니다.");
			}
		}
	}

}
