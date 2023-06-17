package BOJ.dp;

import java.util.Arrays;
import java.util.Scanner;

public class p1006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTestCase = sc.nextInt();

        for (int t = 0 ; t < totalTestCase ; t ++) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[][] arr = new int[2][n + 1];

            for (int i = 0 ; i <= 1 ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int answer = solve(n, w, arr, 2);

            if (n >= 2) {
                if (arr[0][1] + arr[0][n] <= w) {
                    int temp = arr[0][1];
                    arr[0][1] = w;
                    answer = Math.min(answer, solve(n, w, arr, 1));
                    arr[0][1] = temp;
                }
                if (arr[1][1] + arr[1][n] <= w) {
                    int temp = arr[1][1];
                    arr[1][1] = w;
                    answer = Math.min(answer, solve(n, w, arr, 0));
                    arr[1][1] = temp;
                }
                if (arr[0][1] + arr[0][n] <= w && arr[1][1] + arr[1][n] <= w) {
                    arr[0][1] = w;
                    arr[1][1] = w;
                    answer = Math.min(answer, solve(n - 1, w, arr, 2));
                }
            }

            System.out.println(answer);
        }
    }

    private static int solve(int n, int w, int[][] arr, int status) {
        int[][] dp = initDp(n);
        // dp[0][i] => i열의 윗 줄(0행)까지 채워졌을 때의 최소값
        // dp[1][i] => i열의 아랫 줄(1행)까지 채워졌을 때의 최솟값
        // dp[2][i] => i열의 모든 줄이 채워졌을 때의 최솟값

        dp[0][1] = 1;
        dp[1][1] = 1;
        dp[2][1] = arr[0][1] + arr[1][1] <= w ? 1 : 2;

        for (int i = 2 ; i <= n ; i ++) {
            dp[0][i] = dp[2][i - 1] + 1;
            if (arr[0][i] + arr[0][i - 1] <= w) {
                dp[0][i] = Math.min(dp[0][i], dp[1][i - 1] + 1);
            }

            dp[1][i] = dp[2][i - 1] + 1;
            if (arr[1][i] + arr[1][i - 1] <= w) {
                dp[1][i] = Math.min(dp[1][i], dp[0][i - 1] + 1);
            }

            dp[2][i] = Math.min(dp[0][i], dp[1][i]) + 1;
            if (arr[0][i] + arr[1][i] <= w) {
                dp[2][i] = Math.min(dp[2][i], dp[2][i - 1] + 1);
            }
            if (arr[0][i] + arr[0][i - 1] <= w && arr[1][i] + arr[1][i - 1] <= w) {
                dp[2][i] = Math.min(dp[2][i], dp[2][i - 2] + 2);
            }
        }

        return dp[status][n];
    }

    private static int[][] initDp(int n) {
        int[][] dp = new int[3][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        Arrays.fill(dp[2], Integer.MAX_VALUE);
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[2][0] = 0;
        return dp;
    }
}
