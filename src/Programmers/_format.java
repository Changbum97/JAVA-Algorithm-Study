package Programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/문제번호
public class _format {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(10);
    }

    static class Solution {
        public int solution(int input) {
            int output = input * input;
            return output;
        }
    }

    // Array Test
    static boolean test(int[] result, int answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (result[i] != answer[i]) {
                return false;
            }
        }

        return true;
    }
}
