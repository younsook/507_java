package chap05;

/* Recursive
 * 마방진: 마법 magic + 정방형 배열 + 배치 진열의 진 > 숫자를 특이하게 배열하여 모든 방향의 합이 일정
 * **매직 스퀘어(Magic Square)**는 n×n 크기의 정사각형 배열에 숫자를 배치하되, 
 * 모든 행, 열, 대각선의 숫자 합이 동일하게 되는 배열을 말합니다. (point)
 * 이때 이 동일한 합을 **매직 상수(Magic Constant)**라고 합니다.
 * n은 3,5,7 등 홀수일 때만 가능
 * 3*3 , 5*5
 */
public class Train05_02_2마방진 {

	public static void main(String[] args) {
        int n = 3; // 마방진의 크기
        int[][] magicSquare = new int[n][n];
/*
 * 루벤스의 방법 단계:
1. 첫 번째 숫자를 첫 번째 행의 가운데 열(n/2)에 배치합니다.
2. 다음 숫자는 항상 대각선 위 오른쪽(북동쪽-1, +1)으로 이동하여 배치합니다.
    2.1 만약 배열의 경계를 벗어나면 반대편으로 이동합니다.
        열(r)이 배열의 오른쪽 끝을 벗어나면 맨 왼쪽 열로 이동하고, 
        행(c)이 배열의 맨 위를 벗어나면 맨 아래로 이동합니다.
3. 이미 숫자가 있는 칸에 도달한 경우, 현재 위치 바로 아래의 행으로 이동하여 다음 숫자를 배치합니다.
설명--------------
0 1 0
3 0 0
0 0 2
1번 n/2 → (0,1)
2번 (0-1, 1+1) → (-1, 2) → (2,2)
3번 (2-1, 2+1) → (1, 3) → (1,0)
 */
        // 마방진 생성 알고리즘 (루벤스의 방법)
        int row = 0, col = n / 2; // 시작 위치
        
        for (int num = 1; num <= n * n; num++) { // 3*3 , 5*5 등 배치할 반목문
            magicSquare[row][col] = num; // 현재 위치에 숫자 넣기
            //구현
            int nextRow = (row -1 + n)%n; //위로한칸 // → 위로 가는데 0보다 작아지면 아래로(%n)
            int nextCol = (col +1)%n; //오른쪽으로 한칸 //(col + 1) % n → 오른쪽 끝을 넘어가면 왼쪽으로
            
            if(magicSquare[nextRow][nextCol] != 0) { //↗ 방향 자리에 이미 숫자가 있으면 아래 ↓ 로 이동 
            	row = (row +1) %n; //↗ 방향 자리 차 있으면 아래 ↓ 로 이동 
            }else {
            	row = nextRow;
            	col = nextCol;
            }
        }

        // 마방진 출력
        showSquare(magicSquare);

        // 마방진의 합 확인
        int magicSum = n * (n * n + 1) / 2;
        System.out.println("가로, 세로, 대각선의 합 =  " + magicSum );
        System.out.println("마방진 검사 = " + checkSquare(magicSquare, magicSum));
    }

    // 마방진 출력 메서드
    static void showSquare(int[][] magicSquare) {
    	//구현
    	System.out.println("== 마방진 출력 ==");
    	for(int i=0; i<magicSquare.length;i++) { //행(r)을 처리 012
    		for(int j=0;j<magicSquare[i].length;j++) { //행(i)의 열을 하나씩 처리 012
    			System.out.printf("%3d", magicSquare[i][j]);
    		}
    		System.out.println();
    	}
    }

    // 마방진 유효성 검증 메서드
    static boolean checkSquare(int[][] magicSquare, int magicSum) {
    	// 구현 
    	int n = magicSquare.length;
    	
    	for(int i =0; i<n; i++) {
    		int rowsum =0;
    		for(int j=0; j<n; j++) {
    			rowsum += magicSquare[i][j];
    		}
    		if (rowsum != magicSum) return false;
    	}
    	
    	for(int i =0; i<n; i++) {
    		int colsum =0;
    		for(int j=0; j<n; j++) {
    			colsum += magicSquare[i][j];
    		}
    		if (colsum != magicSum) return false;
    	}
    	
    	int diag1 = 0;
        for (int i = 0; i < n; i++) {
            diag1 += magicSquare[i][i];
        }
        if (diag1 != magicSum) return false;

        // 부대각선 합 확인
        int diag2 = 0;
        for (int i = 0; i < n; i++) {
            diag2 += magicSquare[i][n - 1 - i];
        }
        if (diag2 != magicSum) return false;
        
    	return true;
    }
}
