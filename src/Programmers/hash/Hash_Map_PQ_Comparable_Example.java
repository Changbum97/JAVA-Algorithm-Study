package Programmers.hash;

/**
 * 베스트앨범
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * Hash, Map, Priority Queue, Comparabled을 사용한 예
 */

import java.util.*;

public class Hash_Map_PQ_Comparable_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}), new int[]{4, 1, 3, 0}));
        System.out.println(test(s.solution(new String[]{"classic"}, new int[]{300}), new int[]{0}));
        System.out.println(test(s.solution(new String[]{"classic", "pop", "classic", "classic", "pop", "test"}, new int[]{500, 600, 150, 800, 2500, 100}), new int[]{4, 1, 3, 0, 5}));
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
        public int[] solution(String[] genres, int[] plays) {
            int n = genres.length;

            // 중복 제거 로직
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0 ; i < n ; i ++) {
                if (map.containsKey(genres[i])) {
                    map.put(genres[i], map.get(genres[i]) + plays[i]);
                } else {
                    map.put(genres[i], plays[i]);
                }
            }

            // 장르별 정렬 로직
            PriorityQueue<GP> pq = new PriorityQueue<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.add( new GP(entry.getKey(), entry.getValue()) );
            }

            // 장르별 노래 2개씩 추출 로직
            List<Integer> answerList = new ArrayList<>();
            while(!pq.isEmpty()) {
                GP gp = pq.poll();
                String targetGenre = gp.genre;
                PriorityQueue<PI> temp = new PriorityQueue<>();

                for (int i = 0 ; i < n ; i ++) {
                    if (genres[i].equals(targetGenre)) {
                        temp.add( new PI(plays[i], i) );
                    }
                }

                answerList.add(temp.poll().index);
                if (temp.size() != 0) {
                    answerList.add(temp.poll().index);
                }
            }

            // List -> Array 형변환
            int[] answer = new int[answerList.size()];

            for (int i = 0 ; i < answerList.size() ; i ++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        // Genre And Play
        class GP implements Comparable<GP> {
            String genre;
            int play;

            GP (String genre, int play) {
                this.genre = genre;
                this.play = play;
            }

            // play를 기준으로 내림차순 정렬
            public int compareTo(GP gp) {
                return gp.play - this.play;
            }
        }

        // Play And Index
        class PI implements Comparable<PI>{
            int play, index;

            PI(int play, int index) {
                this.play = play;
                this.index = index;
            }

            // play를 기준으로 내림차순 정렬
            public int compareTo(PI pi) {
                return pi.play - this.play;
            }
        }
    }
}
