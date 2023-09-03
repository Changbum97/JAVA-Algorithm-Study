package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/26.-Remove-Duplicates-from-Sorted-Array
 */

public class p26_RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 2}) == 2);
        System.out.println(s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}) == 5);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            for (int i = 1 ; i < nums.length ; i ++) {
                if (nums[k] != nums[i]) {
                    nums[++ k] = nums[i];
                }
            }
            return k + 1;
        }
    }
}
