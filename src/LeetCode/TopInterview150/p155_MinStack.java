package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/155.-Min-Stack
 */

import java.util.*;

public class p155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() == -3);
        minStack.pop();
        System.out.println(minStack.top() == 0);
        System.out.println(minStack.getMin() == -2);
    }

    static class MinStack {

        List<Integer> stack;
        List<Integer> minStack;
        int minValue;

        public MinStack() {
            stack = new ArrayList<>();
            minStack = new ArrayList<>();
            minValue = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if (val < minValue) {
                minValue = val;
            }

            stack.add(val);
            minStack.add(minValue);
        }

        public void pop() {
            stack.remove(stack.size() - 1);

            int temp = minStack.remove(minStack.size() - 1);

            if (temp == minValue) {
                minValue = minStack.isEmpty() ? Integer.MAX_VALUE : getMin();
            }
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }
    }
}
