package Programmers.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class p12910 {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(s.solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(s.solution(new int[]{3, 2, 6}, 10)));
    }

    static class Solution {
        public int[] solution(int[] arr, int divisor) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0 ; i < arr.length ; i ++) {
                if(arr[i] % divisor == 0) {
                    pq.add(arr[i]);
                }
            }

            if (pq.isEmpty()) {
                return new int[]{-1};
            } else {
                int[] answer = new int[pq.size()];
                int idx = 0;

                while(!pq.isEmpty()) {
                    answer[idx ++] = pq.poll();
                }

                return answer;
            }
        }
    }
}
