package Programmers.dp;

/**
 * 올바른 괄호의 갯수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12929
 * DP Level4 예제
 */

public class Dp_Level4_Example2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2) == 2);
        System.out.println(s.solution(3) == 5);
        System.out.println(s.solution(4) == 14);
        System.out.println(s.solution(14) == 2674440);
    }

    static class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1 ; i <= n ; i ++) {
                for (int j = 0 ; j < i ; j ++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }

            return dp[n];
        }
    }
}
