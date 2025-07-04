package chap09;
import java.util.ArrayList;
/*
 * 집합 트리 = 유니온트리
 * 집합 원소를 제거하는 delete() 추가, 집합 세트를 출력하는 displaySets()를 추가함
 * 유니온파인드=유일한원소
 * 집합 트리= 트리의 기본속성이다. 
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sets3 {
	//Map<Integer, Integer> parent;
	//Map<Integer, Integer> rank;
	
    private int[] parent;
    private int n;

    //배열만들기
    public Sets3(int sz) {
        n = sz;
        parent = new int[sz + 1]; // Don't want to use parent[0]
        Arrays.fill(parent, -1);  // Initialize with -1 //초기값을 -1로설정함.
    }
    //집합트리 주요1
    public int simpleFind(int i) {
        // Find the root of the tree containing element i
    	//the root 최상단을 찾아라.
    	//1. 못찾았다. 경계조건부터 
    	while (parent[i] >= 0) {
    		i = parent[i];
    	}
    	return i; //그게아니면 그냥 i 값 리턴
    }
  //집합트리 주요2
    public void simpleUnion(int i, int j) {
        // Replace the disjoint sets with roots i and j, i != j with their union
        i = simpleFind(i); //i가 속한 집합의 루트
        j = simpleFind(j); //j가 속한 집합의 루트
        if (i == j) return; //같은집합
        parent[j] = i;
    }

    public void weightedUnion(int i, int j) {
        // Union sets with roots i and j, using the weighting rule.
        i = simpleFind(i);
        j = simpleFind(j);
        if (i == j) return; // 이미 같은 집합이면 리턴
        
        // 더 작은 집합을 더 큰 집합 아래에 둔다.
        // parent[x]는 음수일수록 더 큰 집합
        // 즉, parent[i] < parent[j] => i가 더 큰 집합
        if (parent[i] < parent[j]) {
        	 // i 집합이 더 크므로 j를 i 밑에 붙인다
            parent[i] += parent[j];  // 크기 누적
            parent[j] = i;           // j의 루트를 i로 설정
        } else {
            // j 집합이 더 크므로 i를 j 밑에 붙인다
            parent[j] += parent[i];
            parent[i] = j;
        }
        
    }
    
    public void delete(int n) {
    	//n이 root이거나 non-leaf 일 문제 해결 필요
    	if(n <= 0 || n > this.n) {
    		System.out.println("잘못된 매개변수 입니다.");
    		return;
    	}
    	// root를 찾아야함.
    	
    	
    	//집합 set을 끊는다. 
    	parent[n] = -1;
  
    }
 

    //void difference() 차집합 -  이 문제는 disjoint set을 가정하므로 가정 변경이 필요
    //void intersection()교집합
     
    public void displaySets() { //경로압축 : 
    	//{1,2,3} 등으로 set을 표시하기
    	Map<Integer, List<Integer>> sets = new HashMap<>();
    	for (int i = 1; i <= n; i++) {
            int root = simpleFind(i);  // i가 속한 집합의 루트
            sets.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
    	// 출력
        System.out.println("displaySets() 결과:");
        for (List<Integer> set : sets.values()) {
            System.out.print("{ ");
            for (int v : set) {
                System.out.print(v + " ");
            }
            System.out.println("}");
        }

    }
    
    public void display() {
        System.out.print("display:index=  ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("display:value= ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", parent[i]);
        }
        System.out.println();
    }

}
public class Task09_01_1집합트리_sook {

    public static void main(String[] args) {
        Sets3 m = new Sets3(20);
        m.simpleUnion(7, 1);
        m.simpleUnion(2, 3);
        m.simpleUnion(4, 5);
        m.simpleUnion(6, 7);
        m.simpleUnion(4, 2);
        m.simpleUnion(5, 7); //결과 7 6이나옴. 
        m.simpleUnion(8, 10);
        m.simpleUnion(13, 11);
        m.simpleUnion(12, 9);
        m.simpleUnion(14, 20);
        m.simpleUnion(16, 19);
        m.simpleUnion(17, 18);
        m.simpleUnion(12, 19);
        m.simpleUnion(13, 15);
        System.out.println("SimpleUnion() 실행 결과::");
        m.display();
        m.displaySets();
        m.weightedUnion(1, 8);
        m.weightedUnion(1, 4);
        m.weightedUnion(3, 9);
        m.weightedUnion(7, 15);
        m.weightedUnion(12, 18);
        m.weightedUnion(4, 16);
        System.out.println("WeightedUnion() 실행 결과::");
        m.display();
        m.displaySets();
        if (m.simpleFind(2) == m.simpleFind(18))
        	System.out.println("2, 18은 같은 집합이다");
        else
        	System.out.println("2, 18은 다른 집합이다");

        System.out.println("***3를 집합에서 삭제한다***");
        m.delete(3);//root를 삭제할 때 문제 있다
        m.display();
        m.displaySets();
        
        if (m.simpleFind(2) == m.simpleFind(18))
        	System.out.println("2, 18은 같은 집합이다");
        else
        	System.out.println("2, 18은 다른 집합이다");
        
    }
}

