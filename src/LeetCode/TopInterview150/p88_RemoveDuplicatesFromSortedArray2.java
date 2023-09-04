package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/80.-Remove-Duplicates-from-Sorted-Array-II
 */

public class p88_RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,3}) == 5);
        System.out.println(s.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}) == 7);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 1;
            int num = nums[0];
            int numCnt = 1;

            for (int i = 1 ; i < nums.length ; i ++) {
                if (nums[i] != num) {
                    nums[k ++] = nums[i];
                    num = nums[i];
                    numCnt = 1;
                } else if (numCnt == 1) {
                    numCnt ++;
                    nums[k ++] = nums[i];
                }
            }

            return k;
        }
    }
}
