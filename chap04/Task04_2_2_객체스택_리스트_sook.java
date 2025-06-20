package chap04;
/*
 * 실습 4_3번
 * point(x,y) 객체를 스택에 저장
 * 좌표를 스택에 구현 소스 코드 - 5장에서 활용
 * 예외 처리 코드를 이해하는 것이 필요
 * 스택 구현을 배열이 아닌 list로 구현
 * 객체 스택 리스트
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
* objectStack에 Point2 객체를 push, pop하는 코드를 구현 실습한다
*/
import java.util.Random;
import java.util.Scanner;

import chap04.IntStack4.EmptyIntStackException;
import chap04.IntStack4.OverflowIntStackException;

class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "Point2 [ix=" + ix + ", iy=" + iy + "]";
	}

	@Override
	public int hashCode() { //이 값이 나중에 HashMap, HashSet에서 버킷 위치 결정에 사용됨.
		return Objects.hash(ix, iy);
	}
	/* Objects.hash()
	 * java.util.Objects 클래스의 정적 메소드 (static method)
	 * 내부적으로 들어온 파라미터들을 이용해 해시코드를 계산
	 * 다양한 타입의 인자를 받아서 자동으로 해시코드를 만들어 줌
	 * */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2 other = (Point2) obj;
		return ix == other.ix && iy == other.iy;
	}
}

//스택 구현
class ObjectStack{
	private List<Point2> data;  // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	/*
	 * 정수스택 버젼을 참조하여 예외처리 완성
	 */
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
//추가
		EmptyGenericStackException(String s){
			super(s);
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
//추가
		OverflowGenericStackException(String s){
			super(s);
		}
	}

   

//--- 생성자(constructor) ---//
	public ObjectStack(int maxlen) {
		//구현
		capacity = maxlen;
		data = new ArrayList<>(capacity);
		top = 0;
		
	}

//--- 스택에 x를 푸시 ---//
	public boolean push(Point2 x) throws OverflowGenericStackException {
		//구현
		if (isFull()) { // 스택이 가득 참
			throw new OverflowGenericStackException("push: stack overflow");
		}
		data.add(x);
		top++;
		return true;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point2 pop() throws EmptyGenericStackException  {
		//구현
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException("pop: stack empty");
		top--;
		return data.remove(top);
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point2 peek() throws EmptyGenericStackException  {
		//구현
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException("peek: stack empty");
		return data.get(top -1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		data.clear();
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point2 x) {
		//구현
		for(int i = top -1; i >= 0; i--) {
			if(data.get(i).equals(x)) { // (O) 값 비교 → 같은 좌표값이면 true
			//if(data.get(i)==x) { // (X) 주소 비교 → 서로 다른 객체이면 false
				return i; // 검색성공
			}
		}
		return -1; //검색 실패
	}
	/*
	 * 1. 현재 indexOf() 메서드에서 if(data.get(i)==x) 부분은 객체의 참조(메모리 주소)를 비교하고 있습니다. 
	 * 값 비교를 하도록 equal()을 개선하시면 좋을 듯 합니다.*/

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return top;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		//구현
		if(isEmpty()) {
			System.out.println("스택이 비어 있습니다.");
			return;
		}
		else {
			//추가할 부분
			for (int i = 0; i < top; i++) {
	                System.out.print(data.get(i) + " ");
	            }
	            System.out.println();
			}
	}
}



public class Task04_2_2_객체스택_리스트_sook {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point2 p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point2(rndx,rndy);
				try {
					s.push(p);
				} catch(ObjectStack.OverflowGenericStackException e) {
					System.out.println("stack이 가득찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch(ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}