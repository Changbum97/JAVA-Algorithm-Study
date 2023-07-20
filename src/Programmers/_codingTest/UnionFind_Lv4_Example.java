package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/64063
// Union Find LV4 예제

import java.util.*;

public class UnionFind_Lv4_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        long[] answer = s.solution(10, new long[]{1, 3, 4, 1, 3, 1});
        for (long i : answer) {
            System.out.print(i + " ");
        }
    }

    static class Solution {

        static HashMap<Long, Long> cap = new HashMap<>();

        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];

            for (int i = 0 ; i < room_number.length ; i ++) {
                long target = room_number[i];

                if (!cap.containsKey(target)) {
                    answer[i] = target;
                    cap.put(target, target + 1);
                } else {
                    answer[i] = findCap(target);
                }
            }

            return answer;
        }

        public long findCap(long now) {
            if (!cap.containsKey(now)) {
                cap.put(now, now + 1);
                return now;
            } else {
                cap.put(now, findCap(cap.get(now)));
                return cap.get(now);
            }
        }
    }
}
