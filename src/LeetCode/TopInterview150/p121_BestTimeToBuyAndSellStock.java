package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/121.-Best-Time-to-Buy-and-Sell-Stock
 */

public class p121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}) == 5);
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}) == 0);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int answer = 0;
            int min = prices[0];

            for (int i = 1 ; i < prices.length ; i ++) {
                min = Math.min(min, prices[i]);
                answer = Math.max(answer, prices[i] - min);
            }

            return answer;
        }
    }
}
