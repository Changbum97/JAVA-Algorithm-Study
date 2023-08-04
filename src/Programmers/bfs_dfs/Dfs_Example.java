package Programmers.bfs_dfs;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * DFS를 사용한 예제
 */

import java.util.*;

public class Dfs_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AAAAE") == 6);
        System.out.println(s.solution("AAAE") == 10);
        System.out.println(s.solution("I") == 1563);
        System.out.println(s.solution("EIO") == 1189);
    }

    static class Solution {
        static List<String> dictionary = new ArrayList<>();
        static String[] chars = new String[]{"A", "E", "I", "O", "U"};

        public int solution(String word) {
            makeDictonary(0, "");

            int answer = 0;
            for (String s : dictionary) {
                if (s.equals(word)) {
                    return answer;
                }
                answer ++;
            }

            return answer;
        }

        static void makeDictonary(int step, String word) {
            dictionary.add(word);
            if (step == 5) {
                return;
            }

            for (int i = 0 ; i <= 4 ; i ++) {
                makeDictonary(step + 1, word + chars[i]);
            }
        }
    }
}
