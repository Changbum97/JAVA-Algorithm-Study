package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/27.-Remove-Element
 */

public class p27_RemoveElement {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{3, 2, 2, 3}, 3) == 2);
        System.out.println(s.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2) == 5);
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;

            for (int i = 0 ; i < nums.length ; i ++) {
                if (nums[i] != val) {
                    nums[k ++] = nums[i];
                }
            }

            return k;
        }
    }
}
