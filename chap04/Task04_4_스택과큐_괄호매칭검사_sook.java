
package chap04;
/*
문제 설명:
괄호로 이루어진 문자열이 주어졌을 때, 각 괄호가 제대로 짝을 이루고 있는지 확인하는 프로그램
괄호에는 <>, (), {}, []가 포함 
여는 괄호가 있을 때, 반드시 짝이 맞는 닫는 괄호가 나와야 하고, 
괄호는 올바르게 중첩되어야 한다.

조건:
  1. 여는 괄호는 반드시 닫는 괄호와 짝을 이뤄야 한다.
  2. 괄호들은 올바르게 중첩되어야 한다.
  3. 괄호 외의 문자는 무시한다.

입력 형식:
  한 줄에 괄호 문자열이 주어지고, 문자열은 괄호 외에도 다른 문자를 포함.

출력 형식:
  괄호가 유효하면 "Valid"를, 유효하지 않으면 "Invalid"를 출력.


*/


import java.util.*;

public class Task04_4_스택과큐_괄호매칭검사_sook {

	   public static boolean isValid(String s) {
	        //Map<Character, Character> pairs = *** // 사용 추천 "[ ]"을 map 쌍으로 정의
		   //1. 괄호 쌍 정의
		   Map<Character, Character> pairs = new HashMap<>();
		   pairs.put(')', '(');
		   pairs.put(']', '[');
		   pairs.put('}', '{');
		   pairs.put('>', '<');
		   //pairs.put(key, value);
		   
		   //2. 스택 객체 생성
		   Stack<Character> stack = new Stack<>();
		   
		   // 3: 문자열을 문자 배열로 순회하며 검사
	        for (char ch : s.toCharArray()) {
	            if (pairs.containsValue(ch)) { // 여는 괄호면 push            
	                stack.push(ch);
	            } else if (pairs.containsKey(ch)) { // 닫는 괄호면 pop해서 짝 확인          
	                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
	                    return false;  // 짝이 안 맞거나 스택이 비어있어? Invalid
	                }
	            }
	        }

	        // 4: 스택이 완전히 비어있어야 유효
	        return stack.isEmpty();

	    }

	    public static void main(String[] args) {
	 
	        String[] cases1 = {
	            "(12{as[33<1q2w3e>90]kkk}4r)fg", 
	            "<111{ddd[4r(1q2w3e)44]77}jj>kk" ,
	            "zz{w(a+b)*[c/d]-<q-e>1+2}w*t", 
	            "dd[a+b+c(y*u[abstract]go{234}2w3e)444]ttt" , 
	            "a+b<c-d<e%r{123{waste[go[stop(a+b+c(?)$)@]!]*}12}33>c-d>drop" 
	        };


	        String[] cases2 = {
	            "a-b-c{1234[3.14(hello)kkk]1>d-w",  
	            "a*b*c(121<good[days)gostop>q-w]t-1",  
	            "123{hello[a-w-e(w/e/r]\n)\t}qq", 
	            "q*t&w{12-34[a+b]*(c/d]-e}123", 
	            "12<a/b/c/d{q-t-t[a=c(78::]23;)'8}sss>x+y+w",
	        };

	        System.out.println("예제1:");
	        for (String test : cases1) {
	            System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
	        }

	        System.out.println("\n예제2:");
	        for (String test : cases2) {
	            System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
	        }
	    }
	}
