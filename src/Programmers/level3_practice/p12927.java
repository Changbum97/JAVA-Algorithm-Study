package Programmers.level3_practice;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * Priority Queue 예제
 */

import java.util.*;

public class p12927 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[]{4, 3, 3}) == 12);
        System.out.println(s.solution(1, new int[]{2, 1, 2}) == 6);
        System.out.println(s.solution(3, new int[]{1, 1}) == 0);
    }

    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator <Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int work : works) {
                pq.add(work);
            }

            for (int i = 1 ; i <= n ; i ++) {
                int x = pq.poll();
                if (x >= 1) {
                    pq.add(x - 1);
                }
                if (pq.isEmpty()) {
                    return 0;
                }
            }

            while(!pq.isEmpty()) {
                int x = pq.poll();
                answer += (long)x * (long)x;
            }

            return answer;
        }
    }
}
