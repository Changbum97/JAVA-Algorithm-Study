package Programmers.sort;

/**
 * K번째 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * Collections.sort를 사용해 ArrayList를 정렬하는 예제
 */

import java.util.*;

public class ArrayList_Sort_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}),
                new int[]{5, 6, 3}));
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
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];

            for (int t = 0 ; t < commands.length ; t ++) {
                int start = commands[t][0] - 1;
                int end = commands[t][1] - 1;
                int target = commands[t][2] - 1;

                List<Integer> temp = new ArrayList<>();
                for (int i = start ; i <= end ; i ++) {
                    temp.add(array[i]);
                }

                Collections.sort(temp);
                answer[t] = temp.get(target);
            }

            return answer;
        }
    }
}
