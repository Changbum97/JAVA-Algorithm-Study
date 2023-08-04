package Programmers.stack_queue;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * Stack(LIFO) 사용 예제
 */

import java.util.Stack;

public class Stack_Example2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()()") == true);
        System.out.println(s.solution("(())()") == true);
        System.out.println(s.solution(")()(") == false);
        System.out.println(s.solution("(()(") == false);
    }

    static class Solution {
        boolean solution(String s) {

            // LIFO => Stack
            Stack<Character> stack = new Stack<>();

            for (int i = 0 ; i < s.length() ; i ++) {
                Character c = s.charAt(i);
                if (c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty() || stack.pop() == ')') {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }

            return false;
        }
    }
}
