package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/169.-Majority-Element
 */

import java.util.Arrays;

public class p169_MajorityElement {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}) == 2);
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
