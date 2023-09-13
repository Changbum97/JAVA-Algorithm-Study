package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/1.-Two-Sum
 */

import java.util.*;

public class p1_TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(test(s.twoSum(new int[]{2,7,11,15}, 9), new int[]{0, 1}));
        System.out.println(test(s.twoSum(new int[]{3,2,4}, 6), new int[]{1,2}));
        System.out.println(test(s.twoSum(new int[]{3,3}, 6), new int[]{0,1}));
    }

    static boolean test(int[] result, int answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (result[i] != answer[i]) {
                return false;
            }
        }

        return true;
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0 ; i < nums.length ; i  ++) {
                if (map.containsKey(target - nums[i])) {
                    answer[0] = map.get(target - nums[i]);
                    answer[1] = i;
                    break;
                }

                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
            }

            return answer;
        }
    }
}
