package Programmers.heap;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * Priority Queue를 사용한 예제
 */

import java.util.*;

public class Priority_Queue_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7) == 2);
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.add(s);
            }

            while(pq.peek() < K) {
                if (pq.size() == 1) {
                    return -1;
                }

                int x = pq.poll();
                int y = pq.poll();
                pq.add(x + (2 * y));
                answer ++;
            }

            return answer;
        }
    }
}
