package Programmers.heap;

/**
 * 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * MaxHeap, MinHeap을 사용한 예제
 */

import java.util.*;

public class MaxHeap_MinHeap_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}), new int[]{0, 0}));
        System.out.println(test(s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}), new int[]{333, -45}));
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
        public int[] solution(String[] operations) {

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (String op : operations) {
                // 새로운 숫자 삽입
                if (op.startsWith("I")) {
                    int num = Integer.parseInt(op.substring(2));
                    minHeap.add(num);
                    maxHeap.add(num);
                } else if (!minHeap.isEmpty()) {
                    // 최댓값 삭제
                    if (op.equals("D 1")) {
                        minHeap.remove(maxHeap.poll());
                    }
                    // 최솟값 삭제
                    else {
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }

            int[] answer = new int[2];

            if (!maxHeap.isEmpty()) {
                answer[0] = maxHeap.poll();
                answer[1] = minHeap.poll();
            }

            return answer;
        }
    }
}
