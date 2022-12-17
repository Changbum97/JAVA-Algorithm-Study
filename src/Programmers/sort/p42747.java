package Programmers.sort;

import java.util.*;

public class p42747 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 0, 6, 1, 5}));
    }
    static class Solution {
        public int solution(int[] citations) {
            int n = citations.length;

            Arrays.sort(citations);
            int max = -1;
            for(int i = 0 ; i < n ; i ++) {
                if(max < citations[i]) {
                    max = citations[i];
                }
            }

            int[] arr = new int[max + 1];
            int cnt = 0;
            int citIdx = n - 1;

            for(int i = max ; i >= 0 ; i --) {
                while(citIdx >= 0 && citations[citIdx] == i) {
                    cnt ++;
                    citIdx --;
                }
                arr[i] = cnt;

                if(arr[i] >= i) {
                    return i;
                }
            }

            return 0;
        }
    }
}
