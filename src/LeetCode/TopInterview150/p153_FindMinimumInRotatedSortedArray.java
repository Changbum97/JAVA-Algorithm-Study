package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/153.-Find-Minimum-in-Rotated-Sorted-Array
 */

public class p153_FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{3,4,5,1,2}) == 1);
        System.out.println(s.findMin(new int[]{4,5,6,7,0,1,2}) == 0);
        System.out.println(s.findMin(new int[]{11,13,15,17}) == 11);
    }

    static class Solution {
        private static int min;

        public int findMin(int[] nums) {
            min = Integer.MAX_VALUE;
            binarySearch(nums, 0, nums.length - 1);
            return min;
        }

        private static void binarySearch(int[] nums, int left, int right) {
            if (left > right) return;
            if (nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
                return;
            }

            int mid = (left + right) / 2;
            min = Math.min(min, nums[mid]);
            binarySearch(nums, left, mid - 1);
            binarySearch(nums, mid + 1, right);
        }
    }
}
