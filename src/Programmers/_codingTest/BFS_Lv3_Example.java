package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// BFS LV3 예제

import java.util.*;

public class BFS_Lv3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    static class Solution {
        public int solution(String begin, String target, String[] words) {

            int remain = words.length;
            boolean[] check = new boolean[words.length];
            Arrays.fill(check, false);

            boolean temp = false;
            for (int i = 0 ; i < words.length ; i ++) {

                if (words[i].equals(begin)) {
                    check[i] = true;
                    remain --;
                } else if(words[i].equals(target)) {
                    temp = true;
                    break;
                }
            }
            if (temp == false) {
                return 0;
            }

            Queue<Word> queue = new LinkedList<>();
            queue.add(new Word(0, begin));

            while(remain > 0) {
                Word now = queue.poll();

                for (int i = 0 ; i < words.length ; i ++) {
                    if (check[i] == false && changeable(now.word, words[i])) {
                        queue.add(new Word(now.step + 1, words[i]));
                        check[i] = true;
                        remain --;
                        if (words[i].equals(target)) {
                            return now.step + 1;
                        }
                    }
                }
            }

            return 0;
        }

        public boolean changeable(String a, String b) {
            int cnt = 0;
            for(int i = 0 ; i < a.length() ; i ++) {
                if (a.charAt(i) != b.charAt(i)) {
                    cnt ++;
                }
                if (cnt >= 2) {
                    return false;
                }
            }
            return true;
        }

        class Word {
            int step;
            String word;

            Word(int step, String word) {
                this.step = step;
                this.word = word;
            }
        }
    }
}
