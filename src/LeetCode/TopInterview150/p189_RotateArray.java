package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/189.-Rotate-Array
 */

public class p189_RotateArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.rotate(new int[]{1,2,3,4,5,6,7}, 3), new int[]{5,6,7,1,2,3,4}));
        System.out.println(test(s.rotate(new int[]{-1,-100,3,99}, 2), new int[]{3,99,-1,-100}));
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
        public int[] rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;

            reverse(nums, 0, n - k - 1);
            reverse(nums, n - k, n - 1);
            reverse(nums, 0, n - 1);

            return nums;
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start ++] = nums[end];
                nums[end --] = temp;
            }
        }
    }
}
