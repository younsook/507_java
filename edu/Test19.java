package edu;

public class Test19 {
	public static void main(String[] args) {
		int score = 90;
		String result ="";
		
		if(score >= 60) {
			result = "합격";
		}else {
			result = "불합격";
		}
		System.out.println(result);
		System.out.println(score >= 60 ? "삼항연산자 : 합격" : "불합격");
	}
}
