package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * https://velog.io/@changbum/122.-Best-Time-to-Buy-and-Sell-Stock-II
 */

public class p122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}) == 7);
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}) == 4);
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}) == 0);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            if (n == 1) {
                return 0;
            }

            int temp, min;
            int answer = 0;
            boolean increasing;
            if (prices[0] < prices[1]) {
                increasing = true;
                min = prices[0];
                temp = prices[1] - prices[0];
            } else {
                increasing = false;
                min = prices[1];
                temp = 0;
            }

            for (int i = 2 ; i < n ; i ++) {
                if (increasing) {
                    if (prices[i] > prices[i - 1]) {
                        temp = prices[i] - min;
                    } else {
                        answer += temp;
                        temp = 0;
                        min = prices[i];
                        increasing = false;
                    }
                } else {
                    if (prices[i] < prices[i - 1]) {
                        min = prices[i];
                    } else {
                        temp = prices[i] - min;
                        increasing = true;
                    }
                }
            }

            if (increasing) {
                answer += prices[n - 1] - min;
            }

            return answer;
        }
    }
}
