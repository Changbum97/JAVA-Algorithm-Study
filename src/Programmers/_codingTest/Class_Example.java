package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
// Solution Class가 아닌 다른 클래스와 static int 변수를 사용하는 예제

public class Class_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(s.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    static class Solution {

        static int rtScore = 0;
        static int cfScore = 0;
        static int jmScore = 0;
        static int anScore = 0;

        public String solution(String[] survey, int[] choices) {
            String answer = "";

            for (int i = 0 ; i < survey.length ; i ++) {
                String s = survey[i];

                if (s.equals("RT")) {
                    add(1, choices[i], false);
                } else if (s.equals("TR")) {
                    add(1, choices[i], true);
                } else if (s.equals("CF")) {
                    add(2, choices[i], false);
                } else if (s.equals("FC")) {
                    add(2, choices[i], true);
                } else if (s.equals("JM")) {
                    add(3, choices[i], false);
                } else if (s.equals("MJ")) {
                    add(3, choices[i], true);
                } else if (s.equals("AN")) {
                    add(4, choices[i], false);
                } else if (s.equals("NA")) {
                    add(4, choices[i], true);
                }
            }

            answer += rtScore >= 0 ? "R" : "T";
            answer += cfScore >= 0 ? "C" : "F";
            answer += jmScore >= 0 ? "J" : "M";
            answer += anScore >= 0 ? "A" : "N";

            return answer;
        }

        public void add(int type, int score, boolean reverse) {
            score -= 4;
            if (score == 0) return;

            if (type == 1) {
                if (reverse) {
                    rtScore += score;
                } else {
                    rtScore -= score;
                }
            } else if (type == 2) {
                if (reverse) {
                    cfScore += score;
                } else {
                    cfScore -= score;
                }
            } else if (type == 3) {
                if (reverse) {
                    jmScore += score;
                } else {
                    jmScore -= score;
                }
            } else if (type == 4) {
                if (reverse) {
                    anScore += score;
                } else {
                    anScore -= score;
                }
            }
        }
    }
}
