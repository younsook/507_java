package chap03;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
* train_실습3_4정수배열이진탐색.java
*/
import java.util.Arrays;
import java.util.Random;
public class Train03_3 {
	
	private static int resultIndex;

	private static void inputData(int[] data) {
		// 구현 반복 숙달 훈련 - 100 이하 난수를 생성
		Random rnd = new Random(41);
		for(int i=0; i<data.length;i++) {
			data[i] = rnd.nextInt(41);
		}
		
	}
	
	private static void showList(String str, int[] data) { // 함수정의에서는 파라미터 변수의 타입을 지정해줘야한다.
		System.out.println(str);
		System.out.println(Arrays.toString(data));
		
	}
	
	private static int linearSearch(int[] data, int key) {
		for(int i=0; i<data.length;i++) {
			if(key == data[i]) {
				return i;  //찾았을때 인덱스 반환
			}
		}
		return -1; 
	}
	
	
	private static int binarySearch(int[] data, int key) {
		// 내가 직접 만든 binarySearch()로 찾기
		//이진탐색 (기본형 int 배열)
		int size = data.length;
		int pl =0;
		int pr = size-1;
		
		int pc = 0;
		//Arrays.binarySearch() 구현하기
		do {
			int pc1 = (pl+pr)/2;
			if(key == data[pc1]) {
				System.out.println("찾은 값의 인덱스="+pc1);
				return 0;
			} else if(key < data[pc1]) {//내가 찾는 키가 중간보다 작으면 
				pr = pc1 -1;
			} else {
				pl = pc1+1;
			}
		} while (pl <= pc);
		//Arrays.binarySearch()
		return -1;
	}

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성  //구현하기

		showList("정렬 전 배열[]:: ", data); //구현하기
		Arrays.sort(data); //api 하는것이니 안해도됨
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = 33; //난수 입력
				//linearSearch 반환값이 resultIndex 이다.
		resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2  
		//구현하기 선형탐색으로 
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = 39; //작성하기 난수 입력
		/*
		 * 교재 109~113
		 */
		int resultIndex1 = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex1);
		
		key = 30;
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex1 = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(30): result = " + resultIndex1);

	}

	

	

	
	

	


	

	
}