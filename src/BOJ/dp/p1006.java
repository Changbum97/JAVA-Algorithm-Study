package BOJ.dp;

import java.util.Scanner;

public class p1006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();
        for (int t = 0 ; t < testCaseCnt ; t ++) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int[][] arr = new int[n + 3][3];
            for (int i = 1 ; i <= 2 ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    arr[j][i] = sc.nextInt();
                }
            }

            int[] dp = new int[n + 3];

            int answer = 0;
            int end;
            if (n <= 3) {
                end = n;
            } else {
                arr[n + 1][1] = arr[1][1];
                arr[n + 1][2] = arr[1][2];
                arr[n + 2][1] = arr[2][1];
                arr[n + 2][2] = arr[2][2];
                end = n + 2;
            }

            for (int i = 1 ; i <= end ; i ++) {
                // dp[i - 1]에서 온 경우
                dp[i] = arr[i][1] + arr[i][2] <= max ? dp[i - 1] + 1 : dp[i - 1] + 2;

                // dp[i - 2]에서 온 경우
                if (i >= 2) {
                    if (arr[i][1] + arr[i - 1][1] <= max && arr[i][2] + arr[i - 1][2] <= max) {
                        dp[i] = Math.min(dp[i], dp[i - 2] + 2);
                    } else if (arr[i][1] + arr[i - 1][1] <= max || arr[i][2] + arr[i - 1][2] <= max) {
                        dp[i] = Math.min(dp[i], dp[i - 2] + 3);
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - 2] + 4);
                    }
                }

                // dp[i - 3]에서 온 경우
                if (i >= 3) {
                    if ((arr[i][1] + arr[i - 1][1] <= max && arr[i - 1][2] + arr[i - 2][2] <= max) ||
                        (arr[i][2] + arr[i - 1][2] <= max && arr[i - 1][1] + arr[i - 2][1] <= max)) {
                        dp[i] = Math.min(dp[i], dp[i - 3] + 4);
                    }
                }

            }

            for (int i = 0 ; i <= end ; i ++) {
                System.out.println(dp[i]);
            }
            if (n <= 3) {
                answer = dp[n];
            } else {
                answer = dp[n];
                answer = Math.min(answer, dp[n + 1] - dp[1]);
                answer = Math.min(answer, dp[n + 2] - dp[2]);
            }
            System.out.println(answer);
        }
    }
}
