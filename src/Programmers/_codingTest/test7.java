package Programmers._codingTest;

import java.util.Collections;
import java.util.PriorityQueue;

public class test6 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{10, 7, 8, 5, 8, 7, 6, 2, 9}, 3));
        System.out.println(s.solution(new int[]{10, 8, 6, 5, 7, 6, 4, 2, 1}, 4));
        System.out.println(s.solution(new int[]{10, 6, 5, 6, 7, 4, 3, 1, 10}, 3));
        System.out.println(s.solution(new int[]{44, 51, 44, 47, 47, 43, 40, 36, 35, 35, 30}, 3));
        System.out.println(s.solution(new int[]{77, 89, 81, 75, 66, 73, 85, 89}, 3));
    }

    static class Solution {
        public int solution(int[] prices, int k) {
            int answer = 0;

            int n = prices.length;

            for (int i = 0 ; i < n - k ; i ++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int j = i + 1 ; j < n ; j ++) {
                    pq.add(prices[j]);
                }

                int temp = 0 - (prices[i] * k);
                for (int j = 1 ; j <= k ; j ++) {
                    temp += pq.poll();
                }

                answer = Math.max(answer, temp);
            }

            if (answer == 0) {
                return -1;
            }
            return answer;
        }
    }
}
