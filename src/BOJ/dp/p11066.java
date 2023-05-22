package BOJ.dp;

import java.util.Arrays;
import java.util.Scanner;

public class p11066 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();   // 테스트 케이스 개수

        for (int t = 1 ; t <= testCaseCnt ; t ++) {
            int n = sc.nextInt();
            int[] files = new int[n];

            for (int i = 0 ; i < n ; i ++) {
                files[i] = sc.nextInt();
            }

            int result = addFile(n, files);
            System.out.println(result);
        }
    }

    private static int addFile(int n, int[] files) {

        int[][] dp = new int[n][n];     // dp[x][y] => x ~ y 파일이 있을때의 최소
        int[] sum = new int[n];
        sum[0] = files[0];

        for (int i = 0 ; i < n ; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int i = 1 ; i < n ; i ++) {
            sum[i] = sum[i - 1] + files[i];
            dp[i - 1][i] = files[i - 1 ] + files[i];
        }

        // 대각선으로 조회하며 dp 구현
        for (int t = 2 ; t < n ; t ++) {
            for (int i = 0 ; i + t < n ; i ++) {
                int j = i + t;
                int sumItoJ = i == 0 ? sum[j] : sum[j] - sum[i - 1];

                for (int k = 1 ; k <= t ; k ++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - k] + dp[j - k + 1][j] + sumItoJ);
                }
            }
        }

        return dp[0][n - 1];
    }
}
