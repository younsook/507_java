package solution;
//https://school.programmers.co.kr/learn/courses/30/lessons/43165
//코딩테스트 연습>깊이/너비 우선 탐색(DFS/BFS)>타겟 넘버

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//DFS 문제 타겟넘버
//스택을써서 2개를 넣고 빼내기.
class StackSolution {
	
	private static class State{
		int index;
		int currentSum;
		public State(int index, int currentSum) {
			super();
			this.index = index;
			this.currentSum = currentSum;
		}
		
	}
	//스택사용.
    public int solution(int[] numbers, int target) {   	
        int count = 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(0,0));
        while(!stack.empty()) {
        	State current = stack.pop();
        	if (current.index == numbers.length) {
        		if(current.currentSum == target) {
        			count++;
        		}
        		continue;
        	}
        	//안맞으면
        	//무조건 2개를 넣고 하나씩빼면서 물어봄.
        	stack.push(new State(current.index+1, current.currentSum + numbers[current.index]));        	
        	stack.push(new State(current.index+1, current.currentSum - numbers[current.index]));
        }
        return count;
    }
} 
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
class QueueStackSolution {
	
	private static class State{
		int index;
		int currentSum;
		
		public State(int index, int currentSum) {
			super();
			this.index = index;
			this.currentSum = currentSum;
		}
		
	}
	//스택사용.
    public int solution(int[] numbers, int target) {   	
        int count = 0;
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0,0));
        
        while(!queue.isEmpty()) {
        	State current = queue.poll();
        	
        	if (current.index == numbers.length) {
        		if(current.currentSum == target) {
        			count++;
        		}
        		continue;
        	}
        	queue.offer(new State(current.index+1, current.currentSum + numbers[current.index]));        	
        	queue.offer(new State(current.index+1, current.currentSum - numbers[current.index]));
        }
        return count;
    }
} 

class RecurStackSolution {
	
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
	//
    public int dfs(int[] numbers, int target, int index, int currentSum) {   	
        int count = 0;

        	if (index == numbers.length) { //재귀에꼭필요 index currentSum
        		return currentSum == target ? 1 : 0;
        	}
        	
        	int add = dfs(numbers, target, index+1, currentSum+numbers[index]);
        	int subt = dfs(numbers, target, index+1, currentSum-numbers[index]);
        	return add + subt;

//        }
       
    }
} 
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        return answer;
//    }
//

//numbers	target	return
//[1, 1, 1, 1, 1]	3	5
//[4, 1, 2, 1]	4	2

//1. DFS(스택), BFS(큐) 연습
//2. 오퍼 알려줘 
//3. 실무에서는 큐 많이 사용

public class solution43165 {
	
	public static void main(String[] args) {
		
		StackSolution      stackSol = new StackSolution();
        QueueStackSolution queueSol = new QueueStackSolution();
        RecurStackSolution recurSol = new RecurStackSolution();
		
		int[][] testNumbers = {
				{1, 1, 1, 1, 1},
				{4, 1, 2, 1}
		};
		int[] testTarger = {3,4};
		int[] expectedResults = {5,2};
		
		for(int i =0; i<testTarger.length;i++ ) {
			int[] numbers = testNumbers[i];
			int target = testTarger[i];
			int expectResult = expectedResults[i];
			
			int stackResult = stackSol.solution(numbers, target) ;
			if(expectResult ==stackResult) System.out.println("solution43165");
			
			int r1 = stackSol.solution(numbers, target);
            int r2 = queueSol.solution(numbers, target);
            int r3 = recurSol.solution(numbers, target);

            System.out.printf("Test %d  |  target = %d, expected = %d\n", i + 1, target, expectResult);
            System.out.printf("  Stack  result : %d\n", r1);
            System.out.printf("  Queue  result : %d\n", r2);
            System.out.printf("  Recurs result : %d\n\n", r3);
		}

	}
	
}

