package BOJ.dp;

import java.util.Scanner;

public class p23083 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n + 1][m + 1];

        int k = sc.nextInt();
        for (int i = 0 ; i < k ; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // arr[x][y] == 0 => 갈 수 있음, 1 => 갈 수 없음
            arr[x][y] = 1;
        }

        long[][] dp = new long[n + 2][m + 2];
        for (int i = 1 ; i <= n ; i ++) {
            if (arr[i][1] == 1) break;

            // 1열은 무조건 위에서 내려오는 경우밖에 없음
            dp[i][1] = 1;
        }

        for (int j = 2 ; j <= m ; j ++) {
            for (int i = 1 ; i <= n ; i ++) {
                if (arr[i][j] == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j % 2 == 0) {
                    dp[i][j] += dp[i + 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] %= 1000000007;
            }
        }

        System.out.println(dp[n][m]);
    }
}
