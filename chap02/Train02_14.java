package chap02;
import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class Train02_14 {

	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data); //
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		Arrays.sort(data); //람다식 없이 돌리기 이해.
		
		Arrays.sort(data, (a,b)->a.compareTo(b)); //람다식으로 돌리기.
		showDataWithLambda("람다식으로 정렬된 배열 출력", data);
				
	}

	private static void showDataWithLambda(String str, String[] data) {
		// TODO Auto-generated method stub
		System.out.println(str);
		Arrays.stream(data).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void showData(String str, String[] data) {
		System.out.println(str);
		//확장된 for 문으로 출력
		for(String x : data) {
			System.out.print(x+" ");
		}
		System.out.println();
		
	}
	static void swap(String[] data, int idx1, int idx2) {//교재 67페이지
		//스트링의 맞교환 함수로 sortData()에서 호출됨
		// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
		String txt = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = txt;
	}
	private static void sortData(String[] data) {
		//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 
		//버블 정렬 i번과 j번을 맞바꾸기
		for (int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i].compareTo(data[j]) > 0) {
					swap(data,i,j); // 작은 값을 앞으로 보내는 오름차순 정렬
				}
			}
		}
	}
	private static String[] insertString(String[] data, String string) {
		//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] newdata = new String[data.length+1];
		for (int i=0; i <data.length;i++) {
			newdata[i] = data[i];
		}
		newdata[data.length] = string;
		Arrays.sort(newdata);
		return newdata;
	}



}
