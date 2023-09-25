package BOJ.dp;

import java.util.Scanner;

public class p1049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   // 끊어진 줄의 개수
        int n = sc.nextInt();   // 브랜드 개수

        Cost[] costs = new Cost[n];
        for (int i = 0 ; i < n ; i ++) {
            costs[i] = new Cost(sc.nextInt(), sc.nextInt());
        }

        int[] dp = new int[m + 1];
        dp[0] = 0;

        for (int i = 1 ; i <= m ; i ++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0 ; j < n ; j ++) {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[j].one);

                int temp = i >= 6 ? dp[i - 6] : 0;
                dp[i] = Math.min(dp[i], temp + costs[j].six);
            }
        }

        System.out.println(dp[m]);
    }

    static class Cost {
        int six, one;

        Cost(int six, int one) {
            this.six = six;
            this.one = one;
        }
    }
}
