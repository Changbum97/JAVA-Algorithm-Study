package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/LeetCode-88.-Merge-Sorted-Array
 */

public class p88_MergeSortedArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3), new int[]{1, 2, 2, 3, 5, 6}));
        System.out.println(test(s.merge(new int[]{1}, 1, new int[]{}, 0), new int[]{1}));
        System.out.println(test(s.merge(new int[]{0}, 0, new int[]{1}, 1), new int[]{1}));
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
        public int[] merge(int[] nums1, int m, int[] nums2, int n) {
            int idx1 = 0;
            int idx2 = 0;
            int[] result = new int[m + n];

            for (int i = 0 ; i < m + n ; i ++) {
                if (idx1 == m) {
                    result[i] = nums2[idx2 ++];
                } else if (idx2 == n) {
                    result[i] = nums1[idx1 ++];
                } else {
                    if (nums1[idx1] <= nums2[idx2]) {
                        result[i] = nums1[idx1 ++];
                    } else {
                        result[i] = nums2[idx2 ++];
                    }
                }
            }

            for (int i = 0 ; i < m + n ; i ++) {
                nums1[i] = result[i];
            }

            return nums1;
        }
    }
}
