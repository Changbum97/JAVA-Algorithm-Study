package Programmers.dp;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 2차원 DP 예제
 */

public class Dp_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}) == 30);
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int n = triangle.length;
            int answer = 0;
            int[][] dp = new int[n][n];
            dp[0][0] = triangle[0][0];

            for (int i = 1 ; i < n ; i ++) {
                for (int j = 0 ; j <= i ; j ++) {
                    if (j == 0) {
                        dp[i][j] = triangle[i][j] + dp[i - 1][j];
                    } else if (j == i) {
                        dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }

                    if (dp[i][j] > answer) {
                        answer = dp[i][j];
                    }
                }
            }

            return answer;
        }
    }
}
