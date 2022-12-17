package Programmers.PCCP;

import java.util.*;

public class p2_2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{10, 3, 7, 2}, 2));
        System.out.println(s.solution(new int[]{1, 2, 3, 4}, 3));
    }
    static class Solution {
        public int solution(int[] ability, int number) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
                return o1 - o2;
            });

            for(int i = 0 ; i < ability.length ; i ++) {
                pq.add(ability[i]);
            }

            for(int i = 0 ; i < number ; i ++) {
                int x = pq.poll();
                int y = pq.poll();
                pq.add(x + y);
                pq.add(x + y);
            }

            while(!pq.isEmpty()) {
                answer += pq.poll();
            }

            return answer;
        }
    }
}
