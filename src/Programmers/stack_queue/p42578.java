package Programmers.stack_queue;

import java.util.*;

public class p42578 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(s.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
    static class Solution {
        public int solution(String[][] clothes) {
            int n = clothes.length;

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0 ; i < n ; i ++) {
                if(map.get(clothes[i][1]) == null) {
                    map.put(clothes[i][1], 1);
                } else {
                    map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                }
            }

            Object[] keys = map.keySet().toArray();
            int answer = 1;
            for(int i = 0 ; i < keys.length ; i ++) {
                String key = keys[i].toString();
                answer *= (map.get(key) + 1);
            }

            return answer - 1;
        }
    }
}
