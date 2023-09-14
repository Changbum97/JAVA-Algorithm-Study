package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/219.-Contains-Duplicate-II
 */

import java.util.*;

public class p219_ContainsDuplicate2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3) == true);
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1) == true);
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2) == false);
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0 ; i < nums.length ; i ++) {
                int num = nums[i];
                if (!map.containsKey(num)) {
                    map.put(num, i);
                } else {
                    int beforeIdx = map.get(num);
                    if (i - beforeIdx <= k) {
                        return true;
                    }

                    map.put(num, i);
                }
            }

            return false;
        }
    }
}
