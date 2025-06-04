package chap04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 실습 4_2번 실습으로 배열 대신에 ArrayList을 사용한 구현하기 
 * 교재에 있는 소스코드
 * 입력하여 실행 실습
 * 정수형 스택 리스트
 * 객체스택과 큐에 대한 구현도 정수 스택의 예외처리 방식을 반복 적용함 
 */

import java.util.Scanner;



class IntStack4 {
	private List<Integer> stk; // 스택용 리스트
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
//추가
		EmptyIntStackException(String s){
			super(s);
		}
	}

/*
public class RuntimeException extends Exception {
// 생성자 중 하나: 메시지를 받는 생성자
public RuntimeException(String message) {
    // 부모 클래스인 Throwable 클래스의 생성자 호출
    super(message);
}
}
*/
	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
//추가
		OverflowIntStackException(String s){
			super(s);
		}
	}
	//--- 생성자(constructor) ---//
	public IntStack4(int maxlen) {
		capacity = maxlen;
//추가
		try {
		//추가
			stk= new ArrayList<>(capacity); //리스트로 스택 구현
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
			stk = null;
		}
		
	}

	//--- 스택에 x를 푸시 ---//
	public void push(int x) throws OverflowIntStackException {
		if (isFull()) { // 스택이 가득 참
			throw new OverflowIntStackException("push: stack overflow");
		}
		stk.add(x);
//return stk.size(); 리스트 사이즈 자체를 스택의 개수로 사용하므로
//top 변수 필요 없음.
//추가
	}

	//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("pop: stack empty");
//추가
		return stk.remove(stk.size() -1);
	}

	//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
		return stk.get(stk.size() -1);
//추가
	}

	//--- 스택을 비움 ---//
	public void clear() throws EmptyIntStackException {
		/*
		 * stack을 empty로 만들어야 한다.
		 * stack이 empty일 때 clear()가 호출된 예외 발생해야 한다 
		 * pop()으로 구현하지 않고 대신에 while 문으로 remove()를 반복 실행한다
		 */
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
		stk.clear();
//추가
	}

//스택 (ArrayList 기반)
/*
 스택은 항상 List의 마지막에 push/pop 하므로 → 가장 최근 데이터부터 
 역순으로 접근 → 단순 for문 가능 
 */
	//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
//추가
		for(int i=stk.size()-1;i>=0;i--) {
			if(stk.get(i)==x) {
				return i; // 검색성공
			}
		}
		return -1; //검색 실패
	}

	//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		//추가
		return capacity;
	}

	//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
	//추가
		return stk.size();
	}

	//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		//추가
		return stk.isEmpty();
	}

	//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		//추가
		return stk.size() >= capacity;
	}
	
	//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() throws EmptyIntStackException{
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			
		}
		else {
			//추가할 부분
		 for (int i = 0; i < stk.size(); i++) {
                System.out.print(stk.get(i) + " ");
            }
            System.out.println();
		}
	}
}


public class Train04_2_1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack4 s = new IntStack4(4); // 최대 64 개를 푸시할 수 있는 스택
		Random rnd = new Random();
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5)clear  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = rnd.nextInt(10);
				try {
					s.push(x);
				} catch (IntStack4.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					s.dump();
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 5: //clear
				try {
					s.clear();
				} catch (IntStack4.EmptyIntStackException e) {			
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
				
			}
		}
	}
}
