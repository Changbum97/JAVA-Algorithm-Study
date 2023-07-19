package Programmers.dp;

public class p42897 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 3, 1}));
    }
    static class Solution {
        public int solution(int[] money) {
            int answer = 0;

            // dp[0][i] = money[i]를 선택한 최대
            // dp[1][i] = money[i]를 선택하지 않은 최대
            int[][] dp = new int[2][money.length];
            dp[0][0] = money[0];
            dp[0][1] = money[1];
            dp[1][1] = money[0];

            for (int i = 2 ; i < money.length - 1 ; i ++) {
                dp[0][i] = money[i] + Math.max(dp[0][i - 2], dp[1][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            }

            answer = Math.max(dp[0][money.length - 2], dp[1][money.length - 2]);

            dp = new int[2][money.length];

            dp[0][1] = money[1];
            dp[0][2] = money[2];
            dp[1][2] = money[1];

            for (int i = 3 ; i < money.length ; i ++) {
                dp[0][i] = money[i] + Math.max(dp[0][i - 2], dp[1][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            }

            answer = Math.max(answer, dp[0][money.length - 1]);
            answer = Math.max(answer, dp[1][money.length - 1]);
            return answer;
        }
    }
}
