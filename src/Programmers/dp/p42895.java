package Programmers.dp;

import java.util.*;

public class p42895 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, 12));
        System.out.println(s.solution(2, 11));
    }

    static class Solution {
        public int solution(int N, int number) {
            HashSet<Long> set = new HashSet<>();
            ArrayList<Long>[] list = new ArrayList[10];

            list[1] = new ArrayList<>();
            list[1].add(Long.valueOf(N));
            if(N == number) return 1;

            // 최대 8번
            for(int i = 2 ; i <= 8 ; i ++) {
                list[i] = new ArrayList<>();
                list[i].add(list[i - 1].get(0) * 10 + N);
                if(list[i].get(0) == number) {
                    return i;
                }

                for(int j = 1 ; j < i ; j ++) {
                    for(long nn : list[j]) {
                        for(long num : list[i - j]) {
                            if(!set.contains(num + nn)) {
                                if(num + nn == number) {
                                    return i;
                                }
                                list[i].add(num + nn);
                                set.add(num + nn);
                            }
                            if(!set.contains(num * nn)) {
                                if(num * nn == number) {
                                    return i;
                                }
                                list[i].add(num * nn);
                                set.add(num * nn);
                            }
                            if(!set.contains(num - nn) && num - nn > 0) {
                                if(num - nn == number) {
                                    return i;
                                }
                                list[i].add(num - nn);
                                set.add(num - nn);
                            }
                            if(!set.contains(num / nn) && num / nn != 0) {
                                if(num / nn == number) {
                                    return i;
                                }
                                list[i].add(num / nn);
                                set.add(num / nn);
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
}
