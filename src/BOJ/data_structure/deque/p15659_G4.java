package BOJ.data_structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p15659_G4 {

    static int[] input;
    static int max, min, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextInt();
        }

        int[] opCnt = new int[4];
        for (int i = 0 ; i < 4 ; i ++) {
            opCnt[i] = sc.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(0, opCnt, new int[n - 1]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int step, int[] opCnt, int[] op) {
        if (step == n - 1) {
            calc(op);
        } else {
            for (int i = 0 ; i < 4 ; i ++) {
                if (opCnt[i] >= 1) {
                    opCnt[i] --;
                    op[step] = i;
                    dfs(step + 1, opCnt, op);
                    opCnt[i] ++;
                }
            }
        }
    }

    private static void calc(int[] op) {
        // + - * /
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(input[0]);

        for (int i = 0 ; i < n - 1 ; i ++) {
            if (op[i] == 2 || op[i] == 3) {
                int x = deque.pollLast();
                int y = input[i + 1];
                deque.addLast(op[i] == 2 ? x * y : x / y);
            } else {
                deque.addLast(op[i]);
                deque.addLast(input[i + 1]);
            }
        }

        int result = deque.pollFirst();
        while (!deque.isEmpty()) {
            int plusOrMinus = deque.pollFirst();
            int x = deque.pollFirst();

            if (plusOrMinus == 0) {
                result += x;
            } else {
                result -= x;
            }
        }

        if (max < result) max = result;
        if (min > result) min = result;
    }
}
