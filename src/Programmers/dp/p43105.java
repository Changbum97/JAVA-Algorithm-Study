package Programmers.dp;

public class p43105 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    static class Solution {
        public int solution(int[][] triangle) {
            int n = triangle.length;
            int[][] dp = new int[n][n];
            int answer = 0;

            dp[0][0] = triangle[0][0];
            for(int i = 1 ; i < n ; i ++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                for(int j = 1 ; j <= i ; j ++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }

            for(int i = 0 ; i < n ; i ++) {
                if(answer < dp[n - 1][i]) {
                    answer = dp[n - 1][i];
                }
            }

            return answer;
        }
    }
}
