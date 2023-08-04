package Programmers._coding_test;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * Hash와 Set을 이용한 예제
 */

import java.util.*;

public class Hash_Set_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3,1,2,3}) == 2);
        System.out.println(s.solution(new int[]{3,3,3,2,2,4}) == 3);
        System.out.println(s.solution(new int[]{3,3,3,2,2,2}) == 2);
    }

    static class Solution {
        public int solution(int[] nums) {
            int n = nums.length;

            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }

            return Math.min(set.size(), n / 2);
        }
    }
}
