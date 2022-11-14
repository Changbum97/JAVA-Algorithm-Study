package Programmers.binary;

import java.util.Arrays;

public class p70129 {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution("110010101001")));
        System.out.println(Arrays.toString(s.solution("01110")));
        System.out.println(Arrays.toString(s.solution("1111111")));
    }
    static class Solution {
        public int[] solution(String s) {
            int cnt = 0;
            int change = 0;

            while(!s.equals("1")) {
                // 제거할 0의 개수 count
                for(int i = 0 ; i < s.length() ; i ++) {
                    if(s.charAt(i) == '0') {
                        cnt ++;
                    }
                }
                s = s.replace("0", "");
                s = Integer.toBinaryString(s.length());
                change ++;
            }

            return new int[]{change, cnt};
        }
    }
}
