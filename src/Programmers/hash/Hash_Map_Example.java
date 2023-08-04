package Programmers.hash;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * Hash와 Map을 사용한 예제
 */

import java.util.*;

public class Hash_Map_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}).equals("leo"));
        System.out.println(s.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}).equals("vinko"));
        System.out.println(s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}).equals("mislav"));
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {

            Map<String, Integer> map = new HashMap<>();
            for (String p : participant) {
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }

            for (String c : completion) {
                int cnt = map.get(c);
                if (cnt == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt - 1);
                }
            }

            return (String) map.keySet().toArray()[0];
        }
    }
}
