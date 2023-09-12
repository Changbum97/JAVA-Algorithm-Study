package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/150.-Evaluate-Reverse-Polish-Notation
 */

import java.util.*;

public class p150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2","1","+","3","*"}) == 9);
        System.out.println(s.evalRPN(new String[]{"4","13","5","/","+"}) == 6);
        System.out.println(s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}) == 22);
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String token : tokens) {
                if (isNumber(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    int afterNum = stack.pop();
                    int beforeNum = stack.pop();

                    if (token.equals("+")) {
                        stack.push(beforeNum + afterNum);
                    } else if (token.equals("-")) {
                        stack.push(beforeNum - afterNum);
                    } else if (token.equals("*")) {
                        stack.push(beforeNum * afterNum);
                    } else {
                        stack.push(beforeNum / afterNum);
                    }
                }
            }

            return stack.pop();
        }

        // str이 숫자인지 판단
        private static boolean isNumber(String str) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                return false;
            }
            return true;
        }
    }
}
