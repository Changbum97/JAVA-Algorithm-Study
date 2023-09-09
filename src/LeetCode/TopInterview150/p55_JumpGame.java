package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/55.-Jump-Game
 */

public class p55_JumpGame {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2,3,1,1,4}) == true);
        System.out.println(s.canJump(new int[]{3,2,1,0,4}) == false);
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int max = 0;

            for (int i = 0 ; i < n ; i ++) {
                if (i > max) {
                    return false;
                }

                if (max < i + nums[i]) {
                    max = nums[i] + i;
                }
            }

            return true;
        }
    }
}
