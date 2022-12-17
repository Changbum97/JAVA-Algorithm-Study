package Programmers.greedy;

import java.util.*;

public class p42862 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{5, 3, 1}));
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{1, 2}));
        System.out.println(s.solution(3, new int[]{3}, new int[]{1}));
    }
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] student = new int[n + 2];
            Arrays.fill(student, 1);
            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i = 0 ; i < lost.length ; i ++) {
                student[ lost[i] ] --;
            }

            for(int i = 0 ; i < reserve.length ; i ++) {
                if(student[ reserve[i] ] == 0) {
                    student[ reserve[i] ] ++;
                    reserve[i] = -1;
                }
            }

            for(int i = 0 ; i < reserve.length ; i ++) {
                int r = reserve[i];
                if(r == -1) continue;

                if(student[r - 1] == 0) {
                    student[r - 1] ++;
                } else {
                    student[r + 1] ++;
                }
            }

            for(int i = 1 ; i <= n ; i ++) {
                if(student[i] != 0) {
                    answer ++;
                }
            }

            return answer;
        }
    }
}
