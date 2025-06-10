package chap04;

import java.util.Scanner;

//int형 고정 길이 스택

class IntStack3 {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
//추가
		EmptyIntStackException(String s) {
			super(s); //RuntimeException의 생성자 호출
		}
		
	}
	/*
	public class RuntimeException extends Exception {
	    // 생성자 중 하나: 메시지를 받는 생성자
		public RuntimeException() {}
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
	/*
	OutOfMemoryError 클래스는 자바에서 메모리 부족 시 발생하는 에러를 나타내는 클래스,
	이 클래스는 Error 클래스의 하위 클래스이며, 메모리가 부족하여 객체를 생성할 수 없는 경우에
	발생
	*/
	
	
//--- 생성자(constructor) ---//
	public IntStack3(int maxlen) {
		capacity = maxlen;
		try {
		stk = new int[capacity]; //heap에 메모리 할당
		} catch(OutOfMemoryError e) {
			System.out.println("메모리 없음");
			capacity = 0;
			return;
		}
		top = 0;

	}

//--- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
		if (top >= capacity) { // 스택이 가득 참
			throw new OverflowIntStackException("push: stack overflow");
		}
		return stk[top++] = x;
//추가
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
//추가
		if(top <=0) {
			throw new EmptyIntStackException("pop: stack empty");
		}
		return stk[--top];
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
//추가
		if(top <=0) {
			throw new EmptyIntStackException("peek: stack empty");
		}
		return stk[top-1];
	}

//--- 스택을 비움 ---//
	public void clear() {
//추가
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
//추가
		for(int i=top-1;i>=0;i--) {
			if(stk[i]==x) {
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
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
//추가
		return top <=0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
//추가
		return top >= capacity;
	}
	
//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() throws EmptyIntStackException{
//추가
		if(top <=0) {
			System.out.println("스택이 비어 있습니다.");
			return;
		}
		for(int i=0; i<top; i++) {
			System.out.print(stk[i]+" ");
		}
		System.out.println();
	}
}

public class Train04_1_1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack3 s = new IntStack3(4); // 최대 4 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (IntStack3.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					s.dump();
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				
				break;
			}
		}
	}
}
