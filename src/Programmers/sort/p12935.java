package Programmers.sort;

import java.util.Arrays;

public class p12935 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{4, 3, 1, 2})));
        System.out.println(Arrays.toString(s.solution(new int[]{-1})));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            if(arr.length == 1) {
                return new int[]{-1};
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < arr.length ; i ++) {
                if(min > arr[i]) {
                    min = arr[i];
                }
            }

            int[] answer = new int[arr.length - 1];
            int idx = 0;
            for(int i = 0 ; i < arr.length ; i ++) {
                if(arr[i] != min) {
                    answer[idx ++] = arr[i];
                }
            }

            return answer;
        }
    }
}
