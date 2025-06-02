package chap04;
/*
 * 실습 4_5번 - 정수 배열 원형 큐
 * 교재 148 ~ 157 페이지
 * 교재 소스 코드를 보지 않고 구현 완성 연습 필요 
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */
 
import java.util.Random;
/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;

import Chap4_스택과큐.IntQueue3.EmptyIntQueue3Exception;
import Chap4_스택과큐.IntQueue3.OverflowIntQueue3Exception;

//int형 고정 길이 큐

class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag;
	//private int num; // 현재 데이터 개수>> 삭제한 후에 queue가 full, empty를 구분하는 실습
	//enque 하기전에 갯수를 세어 front==rear 조건을 체크한다
	//deque도 마찬가지임 
	
//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception() {
		}

		public EmptyIntQueue3Exception(String string) {
			// TODO Auto-generated constructor stub
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception() {
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		capacity = maxlen;
		que = new int[capacity];
		front = rear = 0;
		isEmptyTag = true;
		
	}

	//배열 기반 원형 큐
	//배열을 사용한 원형 큐 (Circular Queue) -자료구조 시험에 나오는 진짜 큐
//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntQueue3Exception {
		//push할때는 rear를 사용
		que[rear] = x;
		//rear++;
		//num++;
//		if(rear == capacity)
//			rear =0;
		rear = (rear+1)% capacity;
		isEmptyTag = false;
		

	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
//		if(num <=0) //책은 num발생. 실제는 if(front == rear & isEmptyTag) 로 연습하기
		if(front == rear & isEmptyTag) { //isEmptyTag true면 예외를 발생시킴
			throw new EmptyIntQueue3Exception("deque: 비었다");
		}
		int result = que[front];
		//front++;
		//num--;
		front = (front+1)%capacity;
		return result;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {

	}

//--- 큐를 비움 ---//
	public void clear() {
		/*
		 * queue을 empty로 만들어야 한다.
		 * queue이 empty일 때 clear()가 호출된 예외 발생해야 한다 
		 */
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {

	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {

	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {

	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {

	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {

	}
}
public class Train04_3_2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}

}
