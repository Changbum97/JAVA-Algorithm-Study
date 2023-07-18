package Programmers.practice;

public class p152996 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{100, 180, 360, 100, 270}));
    }

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            int[] eachWeight = new int[1001];

            for (int i = 0 ; i < weights.length ; i ++) {
                eachWeight[weights[i]] ++;
            }

            for (int i = 100 ; i <= 1000 ; i ++) {
                if (eachWeight[i] == 0) continue;

                answer += (long)eachWeight[i] * (long)(eachWeight[i] - 1) / 2;

                if (i * 2 <= 1000) {
                    answer += (long)(eachWeight[i] * (long)eachWeight[i * 2]);
                }
                if (i % 2 == 0 && (i / 2) * 3 <= 1000) {
                    answer += (long)eachWeight[i] * (long)eachWeight[(i / 2) * 3];
                }
                if (i % 3 == 0 && (i / 3) * 4 <= 1000) {
                    answer += (long)eachWeight[i] * (long)eachWeight[(i / 3) * 4];
                }
            }

            return answer;
        }
    }
}
