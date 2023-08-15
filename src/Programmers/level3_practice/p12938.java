package Programmers.level3_practice;

/**
 * 최고의 집합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class p12938 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(2, 9), new int[]{4, 5}));
        System.out.println(test(s.solution(2, 1), new int[]{-1}));
        System.out.println(test(s.solution(2, 8), new int[]{4, 4}));
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
        public int[] solution(int n, int s) {
            if (n > s) return new int[]{-1};

            int[] answer = new int[n];
            int x = s / n;
            int y = s - (n * x);

            for (int i = 0 ; i < n ; i ++) {
                if (n - i == y) x ++;

                answer[i] = x;
            }

            return answer;
        }
    }
}
