package BOJ.data_structure.stack;

/**
 * 오등큰수
 * 골드 3
 * https://www.acmicpc.net/problem/17299
 */

import java.util.Scanner;
import java.util.Stack;

public class p17299_G3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] cnt = new int[1000001];
        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextInt();
            cnt[input[i]] ++;
        }

        Stack<NC> stack = new Stack<>();
        int[] answer = new int[n];
        for (int i = n - 1 ; i >= 0 ; i --) {

            while (!stack.isEmpty() && stack.peek().cnt <= cnt[input[i]]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek().num;
            }

            stack.push(new NC(input[i], cnt[input[i]]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i ++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static class NC {
        int num, cnt;

        NC (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
