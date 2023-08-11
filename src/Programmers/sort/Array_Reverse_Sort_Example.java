package Programmers.sort;

/**
 * H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * Array를 내림차순 정렬하는 예제
 */

import java.util.*;

public class Array_Reverse_Sort_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 0, 6, 1, 5}) == 3);
        System.out.println(s.solution(new int[]{1}) == 1);
    }

    static class Solution {
        public int solution(int[] citations) {
            int n = citations.length;

            Integer[] arr = new Integer[n];
            for (int i = 0 ; i < n ; i ++) {
                arr[i] = new Integer(citations[i]);
            }

            // 내림차순 정렬
            Arrays.sort(arr, Collections.reverseOrder());

            int bigCnt = 0;
            for (int answer = n ; answer >= 1 ; answer --) {
                while(bigCnt < n && arr[bigCnt] >= answer) {
                    bigCnt ++;
                }

                if (bigCnt >= answer) {
                    return answer;
                }
            }

            return 0;
        }
    }
}
