package chap09;
/*
 * 집합 트리
 * 집합 원소를 제거하는 delete() 추가, 집합 세트를 출력하는 displaySets()를 추가함
 */
import java.util.Arrays;

class Sets3 {
    private int[] parent;
    private int n;

    public Sets3(int sz) {
        n = sz;
        parent = new int[sz + 1]; // Don't want to use parent[0]
        Arrays.fill(parent, -1);  // Initialize with -1
    }
    void displaySets() {
    	//{1,2,3} 등으로 set을 표시하기

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
    public void delete(int n) {
    	//n이 root이거나 non-leaf 일 문제 해결 필요
  
    }

    public void simpleUnion(int i, int j) {
        // Replace the disjoint sets with roots i and j, i != j with their union
        i = simpleFind(i);
        j = simpleFind(j);
        if (i == j) return;


    }

    public int simpleFind(int i) {
        // Find the root of the tree containing element i

    }

    public void weightedUnion(int i, int j) {
        // Union sets with roots i and j, using the weighting rule.
        i = simpleFind(i);
        j = simpleFind(j);
        if (i == j) return;

    }
    //void difference() 차집합 -  이 문제는 disjoint set을 가정하므로 가정 변경이 필요
    //void intersection()교집합

}
public class Task09_01_1집합트리_sook {

    public static void main(String[] args) {
        Sets3 m = new Sets3(20);
        m.simpleUnion(7, 1);
        m.simpleUnion(2, 3);
        m.simpleUnion(4, 5);
        m.simpleUnion(6, 7);
        m.simpleUnion(4, 2);
        m.simpleUnion(5, 7);
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

