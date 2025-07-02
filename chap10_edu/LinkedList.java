package chap10_edu;
//250702 한교수님 설명
import java.util.Comparator;

public class LinkedList<T> {
	private final Node<T> head;
	private int size;
	
	//1. 빈 노드를 생성
	public LinkedList(Node<T> head, int size) {
		this.head = new Node<>(null); //dummy 노드
		this.head.setPrev(head);
		this.head.setNext(size);
	}
	
//	public LinkedList(Node<T> head, int size) {
//		super();
//		this.head = head;
//		this.size = size;
//	}


	//2. size 는 빈노드를 포함하지 않는다. 오른쪽으로 가리키는 것. (왼쪽없는 원형과비슷한구조)
	public int size() {
		return size;
	}

	//3.빈노드는 나의 head를 가르킨다.
	
	public boolean isEmpty() {
		return head.getNext() == head;
	}
	
	//4. 헤드 다음 맨앞에 넣는것.그리고 기존연결을 변경하는것.
	public void addFirst(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> first = head.getNext();
		
		newNode.setPrev(head);
		newNode.setNext(first);
		head.setNext(newNode);
		first.setPrev(newNode);
		
		size++;
	}
	//7.
	public void addLast(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> last = head.getPrev();
		
		newNode.setPrev(last);
		newNode.setNext(head);
		last.setNext(newNode);
		head.setPrev(newNode);
		
		size++;
	}
	}
// head를 변경한것은 위험.
//	public void addLast(T obj) {
//		Node<T> newNode = new Node<>(obj);
//		
//		if(head == null) {
//			head = newNode;
//		} else {
//			Node<T> current = head;
//			
//			while(current.getNext() != null) {
//				current = current.getNext();
//			}
//			current.setNext(newNode);
//			current.setPrev(current);
//		}
//		size++
//	}
	
	//5. 삭제
	public void delete(T obj, Comparator<? super T> c) {
		//Node<T> current(현재노드)
		Node<T> current = head.getNext();
		
		//반복구문을 사용해서 current를 이동
		while (current != head) {
			if(c.compare(current.getData(), obj) ==0) {
				current.getPrev().setNext(current.getNext()); //메서드 체이닝 (중요.리뷰가능해야)
				//current객체(주체)->setNext야 다음을 연결해, 누구한테? current객체의 다음으로 
				current.getNext().setPrev(current.getPrev());
				size--;
				System.out.println("삭제 완료:" + obj);
				return;
			}
			current = current.getNext();
		}
		//만약 obj와 Node<T>가 같으면 삭제
		//아니면 return 해야 됨.
		System.out.println("삭제할 데이터를 찾을 수 없습니다:" + obj);
	}
	
	//6.머지.
	//add를 사용해서 변경, 그러면 순서보장.
	public LinkedList<T> mergeNewList(LinkedList<T> lst2, Comparator<? super T> cc){
		LinkedList<T> lst3 = new LinkedList<>();
		
		Node<T> ai = head.getNext();
		Node<> bi = lst2.head.getNext();
		
		// 돌려~
		while(ai != head && bi != lst2.head) {
			if(cc.compare(ai.getData(), bi.getData()) <= 0) { //ai가 bi보다 작음
				//addLast를 이용해서 추가. ai
				lst3.addLast(ai.getData()); //작은것부터 넣어.
				ai = ai.getNext();
			}else {
				//addLast를 이용해서 추가. bi
				lst3.addLast(bi.getData()); 
				bi = bi.getNext();
				//size손대지 않기.
			}
		}
		//ai 남은 리스트를 순회해서 뒷부분에 추가
		//bi 남은 리스트를 순회해서 뒷부분에 추가
		
		while (ai != head) {
			lst3.add(ai.getData());
			ai = ai.getNext();
		}
		while (bi != lst2.head) {
			lst3.add(bi.getData());
			bi = bi.getNext();
		}
		return lst3;
	}
	
	
	//add할때 순서를 보장?
	public void add(T obj, Comparator<? super T> c) {
		Node<T> newNode = new Node<>(obj);
		Node<T> current = head.getNext();
		
		//정렬된 위치를 찾아야함.
		while (current != head && c.compare(obj, current).getData() > 0) {
			current = current.getNext();
		}
		
		//current 기준으로 앞에 삽입 (선형코드)
		newNode.setPrev(current.getPrev());
		newNode.setNext(current);
		current.getPrev().setPrev(newNode);
		current.setPrev(newNode);
		
		
		
	}
	
	public void add(T obj) {
		@SuppressWarnings("unchecked")
		Comparable<T> comparableObj = (Comparable<T> obj);
		add (obj, (a,b) -> comparableObj.compareTo(b))
		
		
	}
	
	
	
	
	
	
	
	
	
}
