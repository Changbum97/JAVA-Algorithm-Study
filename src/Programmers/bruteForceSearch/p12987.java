package Programmers.bruteForceSearch;

import java.util.*;

public class p12987 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(s.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);
            int n = A.length;
            int bIdx = n - 1;

            for(int i = n - 1 ; i >= 0 ; i --) {
                if(A[i] < B[bIdx]) {
                    answer ++;
                    bIdx --;
                }
            }

            return answer;
        }
    }
}
