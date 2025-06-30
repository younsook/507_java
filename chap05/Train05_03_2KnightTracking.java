package chap05;
/* 위키피디아검색 : 기사의 여행
 * Knight's Tour 문제는 체스판에서 나이트(Knight) 말이 모든 체스판의 칸을 한 번씩만 방문하면서
 * 체스판의 모든 방을 방문하면 종료. 
 * 나이트는 체스에서 "L" 모양으로 움직이는데, 두 칸 직진하고 한 칸 옆으로 이동하는 방식입니다.
 * 임의 위치에서 시작

문제 설명
체스판은 보통 8x8 크기이지만, 이 문제는 임의의 N x N 체스판에서 해결할 수 있습니다.
목표는 나이트가 시작점에서 출발하여 모든 칸을 한 번씩만 방문하면서 끝나는 경로를 찾는 것입니다.
종료조건: 모든 칸이 방문하였을 때 종료 > 방문한 순서를 출력

구현조건:
(x,y)를 저장하는 point 객체를 사용하여 스택으로 non-recursive backtracking 알고리즘으로 구현
 */
import java.util.Stack;

enum knightMoves {NW, NE, EN, ES, SE, SW, WW, WN}

class Offsets4 {
	int a;
	int b;
	public Offsets4(int a, int b) {
		this.a = a; this.b = b;
	}
}
public class Train05_03_2KnightTracking {

	static Offsets4[] moves = new Offsets4[8];//static을 선언하는 이유를 알아야 한다
    static final int N = 8;
	private static int Movedcount = 1;


	
    // 체스판 배열
    private static int[][] board = new int[N][N];
	
	

    // Point 객체로 나이트의 위치를 저장
    static class Point {
        int x, y, moveToward;

        Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.moveToward = move;
        }
    }

    // 1. 체스판을 초기화 (-1로 설정)
    private static void initializeBoard() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			board[i][j] = -1;
    		}
    	}
    }

    // 3. 체스판의 범위 내에서 유효한 움직임인지 확인
    private static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // 2. 나이트 투어 알고리즘 (비재귀적으로 스택 사용)
    private static boolean solveKnightTracking(int startX, int startY) {
    	
    	boolean DEBUG = false;
    	
    	
    	for (int ia = 0; ia < N; ia++)
    		moves[ia] = new Offsets4(0, 0);//배열에 Offsets4 객체를 치환해야 한다.
    	moves[0].a = -2;	moves[0].b = -1;//NW으로 이동
    	moves[1].a = -2;	moves[1].b = 1;//NE
    	moves[2].a = -1;	moves[2].b = 2;//EN
    	moves[3].a = 1;		moves[3].b = 2;//ES
    	moves[4].a = 2;		moves[4].b = 1;//SE
    	moves[5].a = 2;		moves[5].b = -1;//SW
    	moves[6].a = -1;	moves[6].b = -2;//WS
    	moves[7].a = 1;		moves[7].b = -2;//WN
        // 나이트가 이동할 수 있는 8가지 방향
    	
        Stack<Point> stack = new Stack<>();

       
        
        // 시작 위치를 스택에 푸시
        
        board[startX][startY] = Movedcount++; // 시작 위치는 첫 번째 이동
        stack.push(new Point(startX, startY, 0));

                      
	/*1. point currentPoint = stack.peek();
	 *2. 이동 했는지 여부를 체크 (moved = false)
	 *3. 8가지 방향 중 한가지 방향으로 이동
	 *4. isSafe이면, Push(이동 방향 추가), moved = true,
	 *5. 만약 이동을 못하면 (if moved == false)이면 pop해서 백트레킹 진행
	 *6. 이렇게 했음에도 안되면 -> false
	 * */
        
       
        //8방향 중 한가지 방향 시도
        while (!stack.isEmpty()) {  
 	   // 8가지 방향으로 나이트 이동 시도
        	
	        // 현재위치를 보고peek x,y좌표와 시도중인 방향 dir을 가져온다.
		   Point currentPoint = stack.peek();
		   
		   int x = currentPoint.x;
		   int y = currentPoint.y;
		   		   
	       //이동했는지 여부 체크
	       boolean moved = false;
	          
	       int dir = currentPoint.moveToward;
		  for (; dir < 8; dir++) {
			   int nextX = x + moves[dir].a;
			   int nextY = y + moves[dir].b;
			   
			   if (DEBUG) System.out.println("현재 위치: (" + x + ", " + y + "), 시도 방향: " + dir);
			   
			   //isSafe이면, Push(이동 방향 추가), moved = true
			   if (isSafe(nextX, nextY)) {
				   currentPoint.moveToward = dir +1;
				   board[nextX][nextY] = Movedcount++;
				   
				   stack.push(new Point(nextX, nextY, 0));
				   moved = true;
				   if (DEBUG) System.out.println("이동 성공 → (" + nextX + ", " + nextY + "), Movedcount = " + Movedcount);

				   
				   //모든 곳을 방문했어?
				   if (Movedcount == N * N) {
				        return true;
				    }
				   break;
			   	} 
		   	} // 8방향 전부 시도하면서 이동 가능한 칸이 나오면 해당 칸으로 이동
		  
		  
		  
           // 더 이상 이동할 곳이 없을 경우
           //만약 이동을 못하면 (if moved == false)이면 pop해서 백트레킹 진행
           if(!moved) {
        	   Point removed = stack.pop();
        	   board[removed.x][removed.y] = -1;
        	   Movedcount--;
        	   if (DEBUG) System.out.println("이동 실패 → (" + x + ", " + y + ")에서 되돌아감, Movedcount = " + Movedcount);
           }
           
           
	  } //while (!stack.isEmpty())  
        return false; // 해결하지 못함   
    }

    // 4. 결과 출력
    private static void showTracking() {
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.printf("%3d",board[i][j]);
    		}
    		System.out.println();
    	}

    }

    public static void main(String[] args) {

    	// 보드초기화
        initializeBoard();

        // 나이트가 (0, 0)에서 시작
        if (solveKnightTracking(0, 0) && isBoardFullyVisited() ) {
            showTracking();
            System.out.println("기사의 여행 성공");
        } else {
            System.out.println("해결할 수 없습니다.: 기사의 여행 실패");
        }
    }

	private static boolean isBoardFullyVisited() {
		 for (int i = 0; i < N; i++) {
		        for (int j = 0; j < N; j++) {
		            if (board[i][j] == -1) return false;
		        }
		    }
		    return true;
	}
}
