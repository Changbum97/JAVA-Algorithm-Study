package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/12971
// 원형 DP (처음과 끝이 이어지는 경우) 예제

public class Dp_Circular_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(s.solution(new int[]{1, 3, 2, 5, 4}));
    }

    static class Solution {
        public int solution(int sticker[]) {
            int answer = 0;
            int n = sticker.length;

            // n이 1, 2인 경우 예외 처리
            if (n == 1) {
                return sticker[0];
            } else if (n == 2) {
                return Math.max(sticker[0], sticker[1]);
            }

            // 0행 => i번째 수를 고른 경우
            // 1행 => i번째 수를 고르지 않은 경우
            // 첫번째 수 포함 + 마지막 수 제외
            int dp1[][] = new int[2][n];
            dp1[0][0] = sticker[0];
            dp1[0][1] = sticker[1];
            dp1[1][1] = sticker[0];

            for (int i = 2 ; i < n - 1 ; i ++) {
                dp1[0][i] = Math.max(dp1[0][i - 2], dp1[1][i - 1]) + sticker[i];
                dp1[1][i] = Math.max(dp1[0][i - 1], dp1[1][i - 1]);
            }

            // 첫번째 수 제외 + 마지막 수 포함
            int dp2[][] = new int[2][n];
            dp2[0][1] = sticker[1];
            dp2[0][2] = sticker[2];
            dp2[1][2] = sticker[1];

            for (int i = 3 ; i < n ; i ++) {
                dp2[0][i] = Math.max(dp2[0][i - 2], dp2[1][i - 1]) + sticker[i];
                dp2[1][i] = Math.max(dp2[0][i - 1], dp2[1][i - 1]);
            }

            answer = Math.max(dp1[0][n - 2], dp1[1][n - 2]);
            answer = Math.max(answer, dp2[0][n - 1]);
            answer = Math.max(answer, dp2[1][n - 1]);
            return answer;
        }
    }
}
