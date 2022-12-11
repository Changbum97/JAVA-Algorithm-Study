package Programmers.sort;

import java.util.PriorityQueue;

public class p42746 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{59, 596, 595})); // 596 59 595
        System.out.println(s.solution(new int[]{5, 50, 6, 52})); // 6 5 52 50
        System.out.println(s.solution(new int[]{5, 52, 6, 1})); // 6 5 52 1
        System.out.println(s.solution(new int[]{0, 0, 0})); // 6 2 1 10
    }
    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
               String str1 = o1 + o2;
               String str2 = o2 + o1;
               return str2.compareTo(str1);
            });

            for(int i = 0 ; i < numbers.length ; i ++) {
                pq.add(String.valueOf(numbers[i]));
            }

            while(!pq.isEmpty()) {
                answer += pq.poll();
            }

            boolean zeroCheck = false;
            for(int i = 0 ; i < answer.length() ; i ++) {
                if(answer.charAt(i) != '0') {
                    zeroCheck = true;
                    break;
                }
            }

            if(zeroCheck == false) return "0";
            return answer;
        }

    }
}
