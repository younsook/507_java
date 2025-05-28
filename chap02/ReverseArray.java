package chap02;
/*
 * 2장 - 정수 배열 정렬
 * train_실습2_5정수배열정렬.java
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class ReverseArray {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data); //난수를 10 ~ 60 사이에 생성 
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 정렬후", data);
		
		
		Arrays.sort(data); //실전 sort API 사용 1 1,2둘중하나사용
		sortData(data); //연습용으로 sort 만들기 2
		
		//시간걸려해결
		int realData[] = {5, 15, 99};
		for (int newData: realData) {
			int []result = insertData(data, newData);//입력 실수보다 큰 숫자를 우측으로 이동
			System.out.print("\n\n"+ newData+ " : ");
			showData("실수 삽입후", result);
		}
		//
	}
	
	static void showData(String msg, int[]data) {
		System.out.println("msg : "+msg);
		System.out.println(Arrays.toString(data));

	}
	static void inputData(int []data) {
		//난수 생성 10~60사이
		Random rnd = new Random(41); //시드가 41이면 항상 같은 순서의 난수 생성
		for(int i=0; i<data.length;i++) {
			data[i] = rnd.nextInt(51) +10; // 0~50 + 10 → 10~60
		}

	}
	
	static void swap(int[]data, int idx1, int idx2) {//교재 67페이지
		// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
		int txt = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = txt;
	}
	static void sortData(int[] arr) {
		//버블 정렬 i번과 j번을 맞바꾸기
		for (int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					swap(arr,i,j); // 작은 값을 앞으로 보내는 오름차순 정렬
				}
			}
		}
	}
	static void reverse(int[] data) {//교재 67페이지
		// reverse() 구현
		for(int i=0; i< data.length /2; i++) {
			swap(data, i, data.length - i -1);
		}

	}
	static void reverseSort(int []arr) {

	}

	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 * O(n) 알고리즘으로 구현 
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1]; //11개의 배열
		//추가하는 알고리즘 작성 연습
		return newData;
		
	}


}