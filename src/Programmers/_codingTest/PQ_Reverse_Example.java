package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/42628
// Priority Queue 활용 예제 (오름차순, 내림차순)

import java.util.*;

public class PQ_Reverse_Example {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] answer1 = s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        for (int i : answer1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] answer2 = s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        for (int i : answer2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (String operation : operations) {
                if (operation.charAt(0) == 'I') {
                    int newNumber = Integer.valueOf(operation.substring(2, operation.length()));
                    maxHeap.add(newNumber);
                    minHeap.add(newNumber);
                } else if (maxHeap.size() > 0) {
                    if (operation.equals("D 1")) {
                        // 최대값 삭제
                        minHeap.remove(maxHeap.poll());
                    } else {
                        // 최소값 삭제
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }

            if (maxHeap.size() > 0) {
                answer[0] = maxHeap.poll();
                answer[1] = minHeap.poll();
            }
            return answer;
        }
    }
}
