package chap10_edu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;

class Graph5<T> {
	private Map<T, Integer> vertexIndexMap = new HashMap<>();
    private List<T> vertexList = new ArrayList<>();
    
    private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;

    private int[][] length = new int[NMAX][NMAX]; // 인접 행렬 (연결 비용)
    private int[] dist = new int[NMAX]; //최단 거리 저장용
    private boolean[] s = new boolean[NMAX]; //방문여부
    private final int n;
    
    //1. 생성자
    public Graph5(int nodeSize) {
    	this.n = nodeSize;
    	for(int i=0; i<n; i++) {
    		Arrays.fill(length[i], MAX_WEIGHT);  // 무한대 초기화
            length[i][i] = 0; // 자기 자신으로 가는 비용은 0
    	}

    }

    public void addVertex(T vertex) {
        if (!vertexIndexMap.containsKey(vertex)) {
            vertexIndexMap.put(vertex, vertexList.size());
            vertexList.add(vertex);
        }
    }

    public void insertEdge(T from, T to, int weight) {
        int i = vertexIndexMap.get(from);
        int j = vertexIndexMap.get(to);
        length[i][j] = weight;
    }

    public void displayConnectionMatrix() {
    	 System.out.print("    ");
    	 
    	    for (int j = 0; j < n; j++) {
    	        System.out.print(String.format("%6s", vertexList.get(j)));
    	    }
    	    System.out.println();
    	    for (int i = 0; i < n; i++) {
    	        System.out.print(String.format("%4s", vertexList.get(i)));
    	        for (int j = 0; j < n; j++) {
    	            if (length[i][j] == MAX_WEIGHT) {
    	                System.out.print(String.format("%6s", "∞"));
    	            } else {
    	                System.out.print(String.format("%6d", length[i][j]));
    	            }
    	        }
    	        System.out.println();
    	    }
    }

    public boolean isNonNegativeEdgeCost() {
    	 for (int i = 0; i < n; i++) {
    	        for (int j = 0; j < n; j++) {
    	            if (length[i][j] != MAX_WEIGHT && length[i][j] < 0) {
    	                return false;
    	            }
    	        }
    	    }
    	    return true;
    }

    public void shortestPath(T startVertex) {
    	int startIndex = vertexIndexMap.get(startVertex);
        Arrays.fill(s, false);
        for (int i = 0; i < n; i++) {
            dist[i] = length[startIndex][i];
        }
        s[startIndex] = true;
        dist[startIndex] = 0;

        for (int i = 0; i < n - 1; i++) {
        	 int u = choose();
             s[u] = true;

             for (int j = 0; j < n; j++) {
                 if (!s[j] && dist[u] + length[u][j] < dist[j]) {
                     dist[j] = dist[u] + length[u][j];
                 }
             }
        }
        printDistances(startIndex);
    }

    private int choose() {
        int minDist = MAX_WEIGHT;
        int minPos = -1;

        for (int i = 0; i < n; i++) {
            if (!s[i] && dist[i] < minDist) {
                minDist = dist[i];
                minPos = i;
            }
        }

        return minPos;
   
    }

    private void printDistances(int startNode) {
        System.out.print("출발노드 " + startNode + ": ");
        for (int i = 0; i < n; i++) {
        	T vertex = vertexList.get(i);
            System.out.print("->(" + vertex + ")");
            System.out.print((dist[i] == MAX_WEIGHT ? "∞" : dist[i]) + " ");
        }
        System.out.println();
    }
}
public class Task11_5최단경로_sook {

	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {
        return new int[][]{
            {0, 6, 5, 7, 0, 0, 0},
            {6, 0, -2, 0, -1, 0, 0},
            {5, -2, 0, -2, 1, 0, 0},
            {7, 0, -2, 0, 0, -1, 0},
            {0, -1, 1, 0, 0, 0, 3},
            {0, 0, 0, -1, 0, 0, 8},
            {0, 0, 0, 0, 3, 8, 0}
        };
    }

    public static int[][] makeGraph2() {
        return new int[][]{
            {0, 300, 1000, 0, 0, 0, 0, 1700},
            {300, 0, 800, 0, 0, 0, 0, 0},
            {1000, 800, 0, 1200, 0, 0, 0, 0},
            {0, 0, 0, 1200, 1500, 1000, 0, 0},
            {0, 0, 0, 1500, 0, 250, 0, 0},
            {0, 0, 0, 1000, 250, 0, 900, 1400},
            {0, 0, 0, 0, 0, 900, 0, 1000},
            {1700, 0, 0, 0, 0, 1400, 1000, 0}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph5<Integer> g = new Graph5<>(7);

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph5<>(7);
            
            for (int i = 0; i < matrix.length; i++) {
                g.addVertex(i);
            }
            
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else if (select == 2) {
            int[][] matrix = makeGraph2();
            showMatrix(matrix);
            g = new Graph5<>(8);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("\nCommands: 1: Display Matrix, 2: Dijkstra (non-negative), 3: Quit => ");
            select = scanner.nextInt();
            if (select == 3) break;

            switch (select) {
                case 1:
                    g.displayConnectionMatrix();
                    break;
                case 2:
                    if (g.isNonNegativeEdgeCost()) {
                        System.out.print("Start node: ");
                        int startNode = scanner.nextInt();
                        g.shortestPath(startNode);
                    } else {
                        System.out.println("Negative edge가 존재하므로 Bellman-Ford 알고리즘 사용해야 한다.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
