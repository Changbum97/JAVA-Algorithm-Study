package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/162.-Find-Peak-Element
 */

public class p162_FindPeakElement {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1,2,3,1}) == 2);
        System.out.println(s.findPeakElement(new int[]{1,2,1,3,5,6,4}) == 1);
    }

    static class Solution {
        private static int answer;

        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }

            answer = -1;
            binarySearch(nums, 0, nums.length - 1, nums.length - 1);
            return answer;
        }

        private void binarySearch(int[] nums, int left, int right, int end) {
            // 답을 찾은 경우
            if (answer != -1) return;
            if (left > right) return;

            int mid = (left + right) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    answer = mid;
                    return;
                }
            } else if (mid == end) {
                if (nums[mid] > nums[mid - 1]) {
                    answer = mid;
                    return;
                }
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                answer = mid;
                return;
            }

            binarySearch(nums, left, mid - 1, end);
            binarySearch(nums, mid + 1, right, end);
        }
    }
}
