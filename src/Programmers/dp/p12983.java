package Programmers.dp;

import java.util.Arrays;

public class p12983 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"ba","na","n","a"}, "banana"));
    }
    static class Solution {
        public int solution(String[] strs, String t) {
            int answer = 0;
            int[] dp = new int[t.length()];
            Arrays.fill(dp, 50000);

            for(int i = 0 ; i < t.length() ; i ++) {
                for(int j = 0 ; j < strs.length ; j ++) {
                    if(i + 1 < strs[j].length()) continue;
                    if(t.substring(i - strs[j].length() + 1, i + 1).equals(strs[j])) {
                        if(i + 1 == strs[j].length()) {
                            dp[i] = 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - strs[j].length()] + 1);
                        }
                    }
                }
            }

            answer = dp[t.length() - 1];
            if(answer == 50000) {
                answer = -1;
            }
            return answer;
        }
    }
}
