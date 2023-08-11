package Programmers.dp;

/**
 * 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * DP Level3 예제
 */
public class Dp_Level3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}) == 4);
        System.out.println(s.solution(4, 3, new int[][]{{1, 2}, {2, 1}}) == 0);
    }

    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0 ; i <= m ; i ++) { dp[i][0] = -1; }
            for (int i = 0 ; i <= n ; i ++) { dp[0][i] = -1; }

            for (int i = 0 ; i < puddles.length ; i ++) {
                dp[puddles[i][0]][puddles[i][1]] = -1;
            }

            dp[1][1] = 1;
            for (int i = 1 ; i <= m ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (dp[i][j] == -1) continue;
                    if (i == 1 && j == 1) continue;

                    if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
                        dp[i][j] = 0;
                    } else if (i == 0 || dp[i - 1][j] == -1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0 || dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                    }
                }
            }

            return dp[m][n];
        }
    }
}
