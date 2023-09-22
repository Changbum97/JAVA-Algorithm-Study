package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/215.-Kth-Largest-Element-in-an-Array
 */

public class p215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2) == 5);
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) == 4);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int[] numCnt = new int[20001];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int num : nums) {
                numCnt[num + 10000] ++;
                max = Math.max(max, num + 10000);
                min = Math.min(min, num + 10000);
            }

            int cnt = 0;
            for (int i = max ; i >= min ; i --) {
                cnt += numCnt[i];
                if (cnt >= k) {
                    return i - 10000;
                }
            }
            return -1;
        }
    }
}
