package Programmers.stack_queue;

/**
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * Stack(LIFO) 사용 예제
 */

import java.util.*;

public class Stack_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new int[]{1, 1, 3, 3, 0, 1, 1}), new int[]{1, 3, 0, 1}));
        System.out.println(test(s.solution(new int[]{4, 4, 4, 3, 3}), new int[]{4, 3}));
    }

    static boolean test(int[] result, int answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (result[i] != answer[i]) {
                return false;
            }
        }

        return true;
    }

    static class Solution {
        public int[] solution(int []arr) {

            // LIFO => Stack
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);

            for (int num : arr) {
                if (stack.peek() != num) {
                    stack.push(num);
                }
            }

            List<Integer> temp = new ArrayList<>();
            while(!stack.isEmpty()) {
                temp.add(stack.pop());
            }

            int[] answer = new int[temp.size()];
            for(int i = 0 ; i < temp.size() ; i ++) {
                answer[i] = temp.get(temp.size() - i - 1);
            }

            return answer;
        }
    }
}
