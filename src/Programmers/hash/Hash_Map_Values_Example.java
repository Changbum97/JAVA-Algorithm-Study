package Programmers.hash;

/**
 * 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * Hash, Map을 사용하고 Map의 Value를 순환하는 예제
 */

import java.util.*;

public class Hash_Map_Values_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}}) == 5);
        System.out.println(s.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}) == 3);
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> map = new HashMap<>();
            for (String[] cloth : clothes) {
                String type = cloth[1];
                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            }

            for (int value : map.values()) {
                answer *= (value + 1);
            }

            return answer - 1;
        }
    }
}
