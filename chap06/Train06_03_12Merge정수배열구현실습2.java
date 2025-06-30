package chap06;
//book 246p 내용이 복잡하여 새로 만든 구현소스.
//하나의 배열로 리커시브로 구현하는것 정렬
public class Train06_03_12Merge정수배열구현실습2 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		int temp[] = new int[30]; //2. 합친결과
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			
		}
		while (p > righta && q <= rightb) {
			
		}
		while (q > rightb && p <= righta) 
		{
			
		}
		System.out.println();
		for (int j = 0; j < ix; j++) {
			// 배열  temp을 배열 a에 복사
		}
			System.out.println();
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(int[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right); //1. a의 전체 합친 머지 결과 임시배열
		return;
	}

	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20]; //난수생성
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬 0: left, nx-1: right ,nx:배열원소개수

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}