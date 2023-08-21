package BOJ.data_structure.stack;

/**
 * 오큰수
 * 골드 4
 * https://www.acmicpc.net/problem/17298
 */

import java.util.Scanner;
import java.util.Stack;

public class p17298_G4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        for (int i = n - 1 ; i >= 0 ; i --) {
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                while(!stack.isEmpty() && stack.peek() <= input[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    answer[i] = -1;
                } else {
                    answer[i] = stack.peek();
                }
            }
            stack.push(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i ++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
