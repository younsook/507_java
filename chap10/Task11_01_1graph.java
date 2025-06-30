package chap10;
//train_실습과제11_3최소spanningtree_리스트.java
import java.util.*;

class Edge3 implements Comparable<Edge3> {
    int src;
    int dest;
    int weight;

    public Edge3() {}

    public Edge3(int src, int dest, int weight) {
    	this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
    	return String.format("%d -- %d  (w=%d)", src, dest, weight);
    }

    @Override
    public int compareTo(Edge3 e) {
    	return Integer.compare(this.weight, e.weight);
    }
}

class Graph_MST {
    int n; // Number of nodes
    LinkedList<Edge3>[] adj; // 각 정점의 간선 리스트      
    List<Edge3> edgePool = new ArrayList<>(); // 그래프 전체 간선(중복 제거용)


    public Graph_MST(int n) {
    	this.n = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) adj[i] = new LinkedList<>();
    }

    public void insertEdge3(int src, int dest, int weight) {
    	Edge3 e = new Edge3(src, dest, weight);
        adj[src].add(e);
        adj[dest].add(new Edge3(dest, src, weight));

        // 중복 방지를 위해 src < dest 인 경우만 저장
        if (src < dest) edgePool.add(e);
    }
    
    public List<Edge3> getAllEdges() {
        return edgePool;
    }

    public void displayAdjacencyLists() {
    	System.out.println("\n[Adjacency Lists]");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (Edge3 e : adj[i]) {
                System.out.print("(" + e.dest + ",w=" + e.weight + ") ");
            }
            System.out.println();
        }
    }
}

class Sets {
    int[] parent;
    int[] rank;

    public Sets(int n) {
    	parent = new int[n];
        rank   = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int i) {
    	if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
    	int rx = find(x);
        int ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) parent[rx] = ry;
        else if (rank[ry] < rank[rx]) parent[ry] = rx;
        else {
            parent[ry] = rx;
            rank[rx]++;
        }

    }
}
public class Task11_01_1graph {

	  static void KruskalMST(Graph_MST graph) {
	        int n = graph.n;
	        List<Edge3> edges = new ArrayList<>(graph.getAllEdges());
	        
	        // 1️ 간선 가중치 오름차순 정렬
	        Collections.sort(edges);
	        
//	        // 모든 간선을 리스트에 추가
//	        for (int i = 0; i < n; i++) {
//	 
//	        }
//
//	        // Arrays.sort()를 사용하여 간선을 가중치 기준으로 정렬


	        // Kruskal 알고리즘을 위한 Disjoint Set 초기화
	        // 2️ Union‑Find 초기화
	        Sets uf = new Sets(n);
	        List<Edge3> mst = new ArrayList<>();

	        // 3️ Kruskal 메인 루프
	        for (Edge3 e : edges) {
	            int rs = uf.find(e.src);
	            int rd = uf.find(e.dest);
	            if (rs != rd) {
	                mst.add(e);
	                uf.union(rs, rd);
	                if (mst.size() == n - 1) break; // MST 완성
	            }
	        }

	        // MST 출력
	        if (mst.size() != n - 1) {
	            System.out.println("No spanning tree found.");
	        } else {
	            System.out.println("Minimum Spanning Tree:");
	            for (Edge3 edge : mst) {
	                System.out.println(edge);
	            }
	        }
	    }

	    static final int N = 7;

	    static int[][] makeGraph() {
	        return new int[][]{
	            {0, 28, 0, 0, 0, 10, 0},
	            {28, 0, 16, 0, 0, 0, 14},
	            {0, 16, 0, 12, 0, 0, 0},
	            {0, 0, 12, 0, 22, 0, 18},
	            {0, 0, 0, 22, 0, 25, 24},
	            {10, 0, 0, 0, 25, 0, 0},
	            {0, 14, 0, 18, 24, 0, 0},
	        };
	    }
	    static void showMatrix(int[][]m) {
	    	System.out.println("adjacency matrix::");
	    	for (int[] row : m) {
	    		for (int num: row) {
	    			System.out.print(num + " ");
	    		}
	    		System.out.println();
	    	}
	    }
	    public static void main(String[] args) {
	        int[][] matrix = makeGraph();
	        showMatrix(matrix);
	        Graph_MST graph = new Graph_MST(N);

	        // 인접 행렬을 사용해 그래프 초기화
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = i+1; j < matrix[i].length; j++) {
	                if (matrix[i][j] != 0) {
	                    graph.insertEdge3(i, j, matrix[i][j]);
	                }
	            }
	        }

	        Scanner sc = new Scanner(System.in);
	        while (true) {
	            System.out.println("\n명령선택:: 1. Adjacency Lists 출력, 2. spanningTree (Kruskal), 3: Quit => ");
	            int select = sc.nextInt();
	            switch (select) {
	                case 1:
	                    graph.displayAdjacencyLists();
	                    break;
	                case 2:
	                    System.out.println("\nMinimal Spanning Tree 작업 시작");
	                    KruskalMST(graph);
	                    break;
	                case 3:
	                    sc.close();
	                    System.exit(0);
	                default:
	                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
	            }
	        }
	    }
	}

