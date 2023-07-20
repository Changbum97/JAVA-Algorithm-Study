package Programmers._codingTest;

// 시간초과
// https://school.programmers.co.kr/learn/courses/30/lessons/60060
// HashMap, equals, hashCode 사용 예제

import java.util.*;

public class HshMap_Lv4_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];
            HashMap<Word, Integer> startsWith = new HashMap<>();
            HashMap<Word, Integer> endsWith = new HashMap<>();
            HashMap<Integer, Integer> onlyLen = new HashMap<>();

            for (int i = 0 ; i < queries.length ; i ++) {
                String query = queries[i];
                onlyLen.put(query.length(), 0);
                if (query.endsWith("?")) {
                    startsWith.put(new Word(query.replaceAll("\\?", ""), query.length()), 0);
                } else {
                    endsWith.put(new Word(query.replaceAll("\\?", ""), query.length()), 0);
                }
            }

            String startTemp = "";
            String endTemp = "";
            for (int i = 0 ; i < words.length ; i ++) {
                startTemp = "";
                endTemp = "";
                int lenTemp = words[i].length();

                if (!onlyLen.containsKey(lenTemp)) {
                    continue;
                }
                onlyLen.put(lenTemp, onlyLen.get(lenTemp) + 1);

                for (int j = 0 ; j < lenTemp ; j ++) {
                    startTemp += words[i].charAt(j);
                    Word swt = new Word(startTemp, lenTemp);
                    if (startsWith.containsKey(swt)) {
                        startsWith.put(swt, startsWith.get(swt) + 1);
                    }

                    endTemp = words[i].charAt(lenTemp - j - 1) + endTemp;
                    Word ewt = new Word(endTemp, lenTemp);
                    if (endsWith.containsKey(ewt)) {
                        endsWith.put(ewt, endsWith.get(ewt) + 1);
                    }
                }
            }

            for (int i = 0 ; i < queries.length ; i ++) {
                String query = queries[i];

                try {
                    if (query.startsWith("?") && query.endsWith("?")) {
                        answer[i] = onlyLen.get(query.length());
                    } else {
                        if (query.endsWith("?")) {
                            answer[i] = startsWith.get(new Word(query.replaceAll("\\?", ""), query.length()));
                        } else {
                            answer[i] = endsWith.get(new Word(query.replaceAll("\\?", ""), query.length()));
                        }
                    }
                } catch(NullPointerException e) {
                    answer[i] = 0;
                }

            }

            return answer;
        }

        class Word {
            String word;
            int len;

            Word (String word, int len) {
                this.word = word;
                this.len = len;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || this.getClass() != o.getClass()) return false;

                Word w = (Word) o;
                if (w.word.equals(this.word) && w.len == this.len) {
                    return true;
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(word, len);
            }
        }
    }
}
