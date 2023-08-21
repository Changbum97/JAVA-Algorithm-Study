package BOJ.data_structure.stack;

/**
 * 히스토그램
 * 플래티넘 5
 * https://www.acmicpc.net/problem/1725
 */

import java.util.Scanner;
import java.util.Stack;

public class p1725_P5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n + 2];

        for (int i = 1 ; i <= n ; i ++) {
            input[i] = sc.nextInt();
        }
        input[0] = 0;
        input[n + 1] = 0;

        Stack<NI> stack = new Stack<>();
        stack.push(new NI(0, 0));
        int answer = 0;

        for (int i = 1 ; i <= n + 1 ; i ++) {
            while (stack.peek().num > input[i]) {
                int h = stack.pop().num;
                int w = i - stack.peek().idx - 1;
                answer = Math.max(answer, h * w);
            }
            stack.push(new NI(input[i], i));
        }
        System.out.println(answer);
    }

    private static class NI {
        int num, idx;
        NI (int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
