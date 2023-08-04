package Programmers.bruteForce;

/**
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * Brute Force, SQRT를 사용한 예제
 */

public class SQRT_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(10, 2), new int[]{4, 3}));
        System.out.println(test(s.solution(8, 1), new int[]{3, 3}));
        System.out.println(test(s.solution(24, 24), new int[]{8, 6}));
    }

    static boolean test(int[] result, int answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (result[i] != answer[i]) {
                return false;
            }
        }

        return true;
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {

            int sum = brown + yellow;

            for (int i = 2 ; i <= Math.sqrt(sum) + 1 ; i ++) {
                if (sum % i == 0) {
                    int j = sum / i;
                    if ((i - 2) * (j - 2) == yellow) {
                        int[] answer = new int[2];
                        answer[0] = j;
                        answer[1] = i;
                        return answer;
                    }
                }
            }

            return null;
        }
    }
}
