package Programmers.stack_queue;

import java.util.*;

public class p42584 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString( s.solution(new int[]{1, 2, 3, 2 ,3}) ));
    }
    static class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];

            Stack<Price> stack = new Stack<>();
            stack.push(new Price(prices[0], 0));

            for(int i = 1 ; i < n ; i ++) {
                while(!stack.isEmpty()) {
                    Price p = stack.peek();
                    if(p.price > prices[i]) {
                        stack.pop();
                        answer[p.idx] = i - p.idx;
                    } else {
                        break;
                    }
                }
                stack.push(new Price(prices[i], i));
            }

            while(!stack.isEmpty()) {
                Price p = stack.pop();
                answer[p.idx] = n - p.idx - 1;
            }

            return answer;
        }

        class Price {
            int price, idx;
            Price(int price, int idx) {
                this.price = price;
                this.idx = idx;
            }
        }
    }
}
