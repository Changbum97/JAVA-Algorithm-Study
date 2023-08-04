package Programmers.stack_queue;

/**
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * Queue를 사용한 예제
 */

import java.util.*;

public class Queue_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}), new int[]{2, 1}));
        System.out.println(test(s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}), new int[]{1, 3, 2}));
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
        public int[] solution(int[] progresses, int[] speeds) {

            // FIFO => Queue
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0 ; i < speeds.length ; i ++) {
                int temp = (100 - progresses[i]) / speeds[i];
                if ((100 - progresses[i]) % speeds[i] != 0) temp ++;

                queue.add(temp);
            }
            queue.add(101);

            int day = queue.poll();
            int job = 1;
            List<Integer> answerList = new ArrayList<>();

            while(!queue.isEmpty()) {
                int temp = queue.poll();
                if (temp <= day) {
                    job ++;
                } else {
                    answerList.add(job);
                    day = temp;
                    job = 1;
                }
            }

            int[] answer = new int[answerList.size()];
            for(int i = 0 ; i < answerList.size() ; i ++) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }
}
