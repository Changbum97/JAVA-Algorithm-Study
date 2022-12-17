package Programmers.stack_queue;

import java.util.*;

public class p42579 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println( Arrays.toString( s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        System.out.println( Arrays.toString( s.solution(new String[]{"classic", "pop", "classic", "classic", "pop", "test"}, new int[]{500, 600, 150, 800, 2500, 100})));
        System.out.println( Arrays.toString( s.solution(new String[]{"classic"}, new int[]{300})));
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int n = genres.length;

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0 ; i < n ; i ++) {
                if(map.get(genres[i]) == null) {
                    map.put(genres[i], plays[i]);
                } else {
                    map.put(genres[i], map.get(genres[i]) + plays[i]);
                }
            }

            PriorityQueue<Music> pq = new PriorityQueue<>((o1, o2) -> {
                return o2.play - o1.play;
            });

            Object[] objKey = map.keySet().toArray();
            for(int i = 0 ; i < objKey.length ; i ++) {
                String key = objKey[i].toString();
                pq.add(new Music(key, map.get(key)));
            }

            List<Integer> answerList = new ArrayList<>();
            while(!pq.isEmpty()) {
                Music music = pq.poll();
                String targetGenre = music.genre;
                PriorityQueue<GenreMusic> pq2 = new PriorityQueue<>((o1, o2) -> {
                    return o2.play - o1.play;
                });

                for(int i = 0 ; i < n ; i ++) {
                    if(genres[i].equals(targetGenre)) {
                        pq2.add(new GenreMusic(plays[i], i));
                    }
                }

                answerList.add( pq2.poll().idx );
                if(!pq2.isEmpty()) {
                    answerList.add( pq2.poll().idx );
                }
            }

            int[] answer = new int[answerList.size()];
            int answerIdx = 0;
            for(int num : answerList) {
                answer[answerIdx ++] = num;
            }

            return answer;
        }

        class GenreMusic {
            int play, idx;
            GenreMusic(int play, int idx) {
                this.play = play;
                this.idx = idx;
            }
        }

        class Music {
            String genre;
            int play;
            Music(String genre, int play) {
                this.genre = genre;
                this.play = play;
            }
        }
    }
}
