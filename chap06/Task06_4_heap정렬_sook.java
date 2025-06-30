package chap06;
//heap의 full, empty에 대한 예외처리 구현 권장 
import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap; //생성자에서 heap만들기.
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		
		this.MaxSize = sz;
		this.heap = new int[MaxSize +1]; //인덱스 1부터 사용 :1사용하면 무조건큰것을 반환하라
		this.n = 0;
	}
	//257p 공식활용

	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		System.out.println("현재 힙 배열 상태 (index:value):");
		for (int i=1; i<=n;i++ ) {
			System.out.print("["+ i +"]:"+heap[i]+"\t");
		}
		System.out.println();
	
	}
	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		//1. isFull?
		if (isFull()) {
			HeapFull();
			return;
			//throw new FullException("가득찼어?")
		}
		n++;
		int i =n;
		//2. 공간을 생성해야함
		//3. 재배치 시작 (0) 그러면 insert 끝.
		 // i 값 수정
		while(i > 1 && heap[i/2] < x) { //1. i > 1 1보다 크니 2.heap[i/2] 부모보다 크니 
		 // 너 내자리로 와 
			heap[i] = heap[i/2]; //i값 위치만 바꿨다.
			i = i/2 ; //i 값 수정해야한다. 부모노드의 좌표를 i에 넣어주는것 
			
		}
		//결론적으로 heap i 번째에 x를 넣어야해.
		heap[i] =x;
	}
	@Override
	public int DeleteMax() {//heap에서 (머리위)가장 큰 값을 삭제하여 리턴한다. 
		//int x = 0;
		int i, j;
		if (n == 0) { //아무것도 없을때 나가는 값
			HeapEmpty();
			int elm = 0;
			return elm; //elm을 0으로 보내라.
		}
		
		//1.공간을 작게 만들어야해.
		int x =heap[1]; //반환할 최대값
		int lastE = heap[n]; //마지막 원소를 맨 위로 올릴생각.
		n--; //힙크기 축소
		
		//2.i,j 루트와 왼쪽 시작 (책보고 정하기)
		i=1; //루트
		j=2; //왼쪽
		//3.재배치를 시작 while(){}
		while(j <= n) {
		//3-1.오른쪽자식이 존재하고, 왼쪽보다 크면 → 오른쪽 자식 선택: 자식보다 큰가? 인덱스비교(값비교x)
			if(j < n && heap[j] < heap[j+1]) {
				j++; //j = j+1; // 오른쪽 자식 인덱스 선택
			}
		//3-2.마지막 원소가 자식보다 크거나 같은가? 자리 확정
			if (lastE >= heap[j]) break;
		//3-3.자식을 위로 이동
			heap[i] = heap[j];
			i= j;   //현재 위치를 자식 위치로 이동
			j= 2 * i; //다음 자식으로 가는 인덱스 계산
		}
		//4.적절한 위치에 (마지막 원소:lastE) 배치, (특정 값)을 배치
		heap[i]=lastE;
 		return x;//x는 최대값
	}
	
	//스택,큐에서 본것. 일반가드문
	public boolean isEmpty() {
		return n == 0;
	}
	//일반가드문
	public boolean isFull() {
		return n == MaxSize;
	}
	
	public int size() {
		return n; // 몇개인지 돌려줘야한다.
	}
	
	public int peek() {
		//[0]인덱스 사용자는
		if (isEmpty()) {
			System.out.println("힙이 비어 있습니다.");
			return Integer.MIN_VALUE;
		}
		return heap[1];
	}
	//스택,큐에서 본것.
	
	//1맨앞자리에 큰것두기, 2하나꺼내기, 3하나꺼냈으니 한줄빼야한다.
	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
	
	public void clear() {
	    n = 0;
	    for (int i = 1; i < heap.length; i++) {
	        heap[i] = 0;
	    }
	}
}
public class Task06_4_heap정렬_sook {

	 static void showData(int[] d) {
		 for (int i =0; i < d.length; i++) {
			 System.out.print(d[i]+"\t");
		 }
		 System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    int []sorted = new int[count];//heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				heap.clear();
				for(int i =1; i<= count; i++) {
					x[i] = rnd.nextInt(100);
					heap.Insert(x[i]);
				}
				System.out.println("입력된 난수: ");
			     showData(x);
			     
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
				for (int i = count -1; i>=0; i--) {
					sorted[i] = heap.DeleteMax();
				}
				System.out.println("정렬 결과: ");
				showData(sorted);
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
