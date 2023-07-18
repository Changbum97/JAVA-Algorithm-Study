package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// DP LV3 예제

public class Dp_lv3_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }
    static class Solution {
        public int solution(int m, int n, int[][] puddles) {

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0 ; i < puddles.length ; i ++) {
                int x = puddles[i][0];
                int y = puddles[i][1];
                dp[x][y] = -1;
            }
            dp[0][1] = 1;

            for (int i = 1 ; i <= m ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (dp[i][j] == -1) continue;

                    int up = dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                    int left = dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;

                    dp[i][j] = (up + left) % 1000000007;
                }
            }

            return dp[m][n];
        }
    }
}
