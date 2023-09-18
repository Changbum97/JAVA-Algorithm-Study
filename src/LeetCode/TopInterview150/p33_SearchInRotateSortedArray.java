package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/33.-Search-in-Rotated-Sorted-Array
 */

public class p33_SearchInRotateSortedArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0) == 4);
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3) == -1);
        System.out.println(s.search(new int[]{1}, 0) == -1);
    }

    static class Solution {
        private static int answer;

        public int search(int[] nums, int target) {
            answer = -1;
            binarySearch(nums, target, 0, nums.length - 1);
            return answer;
        }

        private void binarySearch(int[] nums, int target, int left, int right) {
            if (answer != -1) return;
            if (left > right) return;

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                return;
            }

            if (mid != 0) {
                if ((nums[left] <= target && nums[mid - 1] >= target) ||
                        (nums[left] > nums[mid - 1] && (nums[left] <= target || nums[mid - 1] >= target))) {
                    binarySearch(nums, target, left, mid -1);
                }
            }
            if (mid != nums.length - 1) {
                if ((nums[mid + 1] <= target && nums[right] >= target) ||
                        (nums[mid + 1] > nums[right] && (nums[mid + 1] <= target || nums[right] >= target))) {
                    binarySearch(nums, target, mid + 1, right);
                }
            }
        }
    }
}
