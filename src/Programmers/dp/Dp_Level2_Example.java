package Programmers.dp;

public class Dp_Level2_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4) == 5);
        System.out.println(s.solution(3) == 3);
    }

    static class Solution {
        public long solution(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }

            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3 ; i <= n ; i ++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            return dp[n];
        }
    }
}
