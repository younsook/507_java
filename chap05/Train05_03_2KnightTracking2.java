package chap05;
import java.util.*;
import java.util.stream.*;
public class Train05_03_2KnightTracking2 {

    static final int N = 8;
    static int[][] board = new int[N][N];

    static final int[][] MOVES = {
        {-2, -1}, {-2, 1}, {-1, 2}, {1, 2},
        {2, 1}, {2, -1}, {1, -2}, {-1, -2}
    };

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        for (int[] row : board) Arrays.fill(row, -1);

        Position start = new Position(0, 0);
        board[start.x][start.y] = 0;

        if (solve(start, 1)) {
            printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }

    static boolean solve(Position current, int moveNum) {
        if (moveNum == N * N) return true;

        Optional<Position> nextMove = getNextCandidates(current).stream()
            .min(Comparator.comparingInt(p -> (int) getPossibleMoves(p).count()));

        if (nextMove.isPresent()) {
            Position next = nextMove.get();
            board[next.x][next.y] = moveNum;
            if (solve(next, moveNum + 1)) return true;
            board[next.x][next.y] = -1; // backtrack
        }

        return false;
    }

    static List<Position> getNextCandidates(Position pos) {
        List<Position> candidates = new ArrayList<>();
        for (int[] move : MOVES) {
            int nx = pos.x + move[0];
            int ny = pos.y + move[1];
            if (isSafe(nx, ny)) candidates.add(new Position(nx, ny));
        }
        return candidates;
    }

    static Stream<Position> getPossibleMoves(Position pos) {
        return Arrays.stream(MOVES)
            .map(d -> new Position(pos.x + d[0], pos.y + d[1]))
            .filter(p -> isSafe(p.x, p.y));
    }

    static boolean isSafe(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && board[x][y] == -1;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
}
