package Programmers.dp;

/**
 * 사칙연산
 * https://school.programmers.co.kr/learn/courses/30/lessons/1843
 * DP Level4 예제
 */
public class Dp_Level4_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}) == 1);
        System.out.println(s.solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"}) == 3);
    }

    static class Solution {
        public int solution(String arr[]) {

            int n = (arr.length + 1) / 2;
            int[] numbers = new int[n];
            boolean[] plus = new boolean[n - 1];
            int tempIdx = 0;

            for (String str : arr) {
                if (str.equals("+")) {
                    plus[tempIdx ++] = true;
                } else if (str.equals("-")) {
                    plus[tempIdx ++] = false;
                } else {
                    numbers[tempIdx] = Integer.parseInt(str);
                }
            }

            int[][] max = new int[n][n];    // max[i][j] = i ~ j 계산 중 최대
            int[][] min = new int[n][n];    // min[i][j] = i ~ j 계산 중 최소
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (i == j) {
                        max[i][j] = numbers[i];
                        min[i][j] = numbers[i];
                    } else {
                        max[i][j] = Integer.MIN_VALUE;
                        min[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int range = 1 ; range < n ; range ++) {
                for (int i = 0 ; i < n - range ; i ++) {
                    // i ~ (i + range) 범위 계산
                    int end = i + range;
                    for (int j = i ; j < end ; j ++) {
                        if (plus[j]) {
                            max[i][end] = Math.max(max[i][end], max[i][j] + max[j + 1][end]);
                            min[i][end] = Math.min(min[i][end], min[i][j] + min[j + 1][end]);
                        } else {
                            max[i][end] = Math.max(max[i][end], max[i][j] - min[j + 1][end]);
                            min[i][end] = Math.min(min[i][end], min[i][j] - max[j + 1][end]);
                        }
                    }
                }
            }

            return max[0][n - 1];
        }
    }
}
