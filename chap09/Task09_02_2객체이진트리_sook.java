package chap09;
//스택, 큐 삭제-(자바것사용), 이진트리만 순회 전위 중위 후위 -> 집합트리
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class SimpleObject4 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + getNo() + ") " + name;
	}
	public SimpleObject4() {
		setNo(null);
		name = null;
	}
	public SimpleObject4(String no, String name) {
		this.setNo(no);
		this.name = name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임
			System.out.print("번호: ");
			setNo(sc.next());
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public static final Comparator<SimpleObject4> NO_ORDER = Comparator.comparing(o -> o.getNo());

}




//정수를 저정하는 이진트리 만들기 실습
class TreeNode4 {
	TreeNode4 LeftChild;
	SimpleObject4 data;
	TreeNode4 RightChild;

	public TreeNode4() {
		LeftChild = RightChild = null;
	}

	TreeNode4(SimpleObject4 so) {
		data = so;
		LeftChild = RightChild = null;
	}
}

class Tree4 {
	TreeNode4 root;

	Tree4() {
		root = null;
	}

	TreeNode4 inorderSucc(TreeNode4 current) {
		//주어진 노드에 대한 inorder traversal 방문시에 다음에 방문할 노드(successor)를 찾는 알고리즘
		TreeNode4 temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null) {
				temp = temp.LeftChild;
			}
		return temp;
	}

	TreeNode4 findParent(TreeNode4 current, Comparator<? super SimpleObject4> c) {
		//주어진 노드의 parent node를 찾는 알고리즘
		if (current == root || root == null) return null;

	    TreeNode4 parent = null;
	    TreeNode4 node = root;

	    while (node != null && node != current) {
	        int cmp = c.compare(current.data, node.data);

	        parent = node; // 후보 부모

	        if (cmp < 0) {
	            node = node.LeftChild;
	        } else if (cmp > 0) {
	            node = node.RightChild;
	        } else {
	            break; // 같을 일이 없긴 함. 고유키라면.
	        }
	    }

	    // current 노드를 찾았을 때만 parent를 반환
	    if (node == current)
	        return parent;

	    return null; // current가 트리에 존재하지 않음
	}

	boolean isLeafNode(TreeNode4 current) {
		//주어진 노드가 leaf node인지 검사
		return current.LeftChild == null && current.RightChild == null;

	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	public boolean add(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
		//inorder로 출력시에 정렬이 되도록 입력: binary search tree를 구현
		// left subtree < x < right subtree
		TreeNode4 p = root;
		TreeNode4 q = null;
		boolean isLeft = false;
		while (p != null) {
			q = p;
			if (c.compare(obj, p.data) < 0) {
				p = p.LeftChild;
				isLeft = true;
			} else if (c.compare(obj, p.data) > 0) {
				p = p.RightChild;
				isLeft = false;
			} else {
				return false;
			}
		}
		TreeNode4 newNode = new TreeNode4(obj);
		if (q == null) root = newNode;
		else if (isLeft) q.LeftChild = newNode;
		else q.RightChild = newNode;
		return true;

	}

	public boolean delete(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
		//주어진 객체 obj를 포함한 노드를 찾아 삭제하는 알고리즘
		//난이도: 최상급 중에서 최상급
		TreeNode4 p = root, q = null;
		boolean isLeft = false;
		while (p != null && c.compare(obj, p.data) != 0) {
			q = p;
			if (c.compare(obj, p.data) < 0) {
				p = p.LeftChild;
				isLeft = true;
			} else {
				p = p.RightChild;
				isLeft = false;
			}
		}
		if (p == null) return false;

		if (p.LeftChild == null || p.RightChild == null) {
			TreeNode4 child = (p.LeftChild != null) ? p.LeftChild : p.RightChild;
			if (p == root) root = child;
			else if (isLeft) q.LeftChild = child;
			else q.RightChild = child;
		} else {
			TreeNode4 successor = inorderSucc(p);
			SimpleObject4 temp = p.data;
			p.data = successor.data;
			successor.data = temp;
			delete(successor.data, c);
		}
		return true;

	}

	boolean search(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
		//주어진 객체 obj를 갖는 노드를 찾는 문제
		TreeNode4 p = root;
		while (p != null) {
			int cmp = c.compare(obj, p.data);
			if (cmp == 0) return true;
			else if (cmp < 0) p = p.LeftChild;
			else p = p.RightChild;
		}
		return false;

	}
	void levelOrder() 
	//root 부터 level별로 출력 : root는 level 1, level 2는 다음줄에 => 같은 level이면 같은 줄에 출력하게 한다 
	{
		if (root == null) return;
		Queue<TreeNode4> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode4 node = queue.poll();
			System.out.print(" " + node.data);
			if (node.LeftChild != null) queue.offer(node.LeftChild);
			if (node.RightChild != null) queue.offer(node.RightChild);
		}

	}
	void NonrecInorder()//void Tree::inorder(TreeNode4 *CurrentNode)와 비교
	//stack을 이용하여 inorder traversal하는 알고리즘 구현
	{
		Stack<TreeNode4> stack = new Stack<>();
		TreeNode4 current = root;
		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.LeftChild;
			}
			if (stack.isEmpty()) break;
			current = stack.pop();
			System.out.println(" " + current.data);
			current = current.RightChild;
		}
	}
}


public class Task09_02_2객체이진트리_sook {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("정렬출력"), 
		LevelorderPrint("레벨별출력"), StackInorderPrint("스택정렬출력"), 
		PreorderPrint("prefix출력"), PostorderPrint("postfix출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Scanner sc2 = new Scanner(System.in);
		Tree4 t = new Tree4();
		Menu menu; // 메뉴
		String sno1, sname1;
		SimpleObject4 so;
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 
				SimpleObject4[] sox = { new SimpleObject4("33", "ee"), 
						new SimpleObject4("55", "tt"),
						new SimpleObject4("22", "ww"), 
						new SimpleObject4("66", "yy"), 
						new SimpleObject4("21", "wq") };
				for (SimpleObject4 soz : sox)
					t.add(soz, SimpleObject4.NO_ORDER);
				break;

			case Delete: //임의 정수 삭제
				so = new SimpleObject4();
				so.scanData("삭제", SimpleObject4.NO);
				t.delete(so, SimpleObject4.NO_ORDER);

				break;

			case Search: // 노드 검색
				so = new SimpleObject4();
				so.scanData("검색", SimpleObject4.NO);
				result = t.search(so, SimpleObject4.NO_ORDER);
				
				if (!result)
					System.out.println("검색 값 = " + so.getNo() + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so.getNo() + "데이터가 존재합니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				//t.NonrecInorder();
				break;
			case LevelorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.levelOrder();
				System.out.println();
				//t.NonrecInorder();
				break;
			case StackInorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.NonrecInorder();
				break;
			case PreorderPrint://prefix 출력
				t.preorder();
				System.out.println();
				break;
			case PostorderPrint://postfix로 출력
				t.postorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}

