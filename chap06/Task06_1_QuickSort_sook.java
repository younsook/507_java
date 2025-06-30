package chap06;
import java.util.Stack;
//import Chap6_Sorting.StackSorting.Stack3;
//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point {
	private int ix;
	private int iy;

	//Point 객체를 사용하여 l, r 을 만들어서
	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}
public class Task06_1_QuickSort_sook {


	//퀵 정렬(비재귀 버전)

		// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
		static void swap(int[] a, int idx1, int idx2) {
			int t = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = t;
		}

		// --- 퀵 정렬(비재귀 버전)---//
		static void quickSort(int[] a, int left, int right) {

			Stack<Point> st = new Stack<>();
			st.push (new Point(left, right));
			
			 while (!st.isEmpty()) {
		         Point pt = st.pop();   
		            int pl = pt.getX();
		            int pr = pt.getY();
		            int pivot = a[(pl + pr) / 2];
//		         int pl = left  = pt.getX();        // 왼쪽 커서
//		         int pr = right = pt.getY();        // 오른쪽 커서
		            
		            do {
		                while (a[pl] < pivot) pl++;
		                while (a[pr] > pivot) pr--;
		                if (pl <= pr) {
		                    swap(a, pl++, pr--);
		                }
		            } while (pl <= pr);

		            if (pt.getX() < pr) st.push(new Point(pt.getX(), pr));
		            if (pl < pt.getY()) st.push(new Point(pl, pt.getY()));
			 }
		}

		public static void main(String[] args) {
			int nx = 10;
			int[] x = new int[nx];
			for (int i = 0; i < nx; i++) {
				double d = Math.random();
				x[i] = (int) (d * 100);
			}
			
			System.out.println("[정렬 전]");
			for (int i = 0; i < nx; i++)
				System.out.print(" " + x[i]);
			System.out.println();

			quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

			System.out.println("[정렬 후 - 오름차순]");
			for (int i = 0; i < nx; i++)
				System.out.print(" " + x[i]);
		}
	}
