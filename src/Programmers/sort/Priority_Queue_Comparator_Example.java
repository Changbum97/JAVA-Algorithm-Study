package Programmers.sort;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * Priority Queue에 Comparator을 적용한 예제
 */

import java.util.*;

public class Priority_Queue_Comparator_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6, 10, 2}).equals("6210"));
        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}).equals("9534330"));
    }

    static class Solution {
        public String solution(int[] numbers) {
            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                // S1 + S2, S2 + S1을 비교하여 결과가 크게 나오도록 return
                @Override
                public int compare(String s1, String s2) {
                    int x = Integer.parseInt(s1 + s2);
                    int y = Integer.parseInt(s2 + s1);
                    return y - x;
                }
            });

            for (int number : numbers) {
                pq.add(String.valueOf(number));
            }

            String answer = "";
            while(!pq.isEmpty()) {
                answer += pq.poll();
            }
            return answer;
        }

    }
}
