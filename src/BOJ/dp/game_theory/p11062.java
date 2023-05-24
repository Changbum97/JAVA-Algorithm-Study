package BOJ.dp.game_theory;

import java.util.Scanner;

public class p11062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tt = 0 ; tt < t ; tt ++) {
            int n = sc.nextInt();
            int[][] dp = new int[n + 2][n + 1];
            int[] arr = new int[n + 1];

            for(int i = 1 ; i <= n ; i ++) {
                arr[i] = sc.nextInt();
            }

            boolean playerATurn = true;
            if(n % 2 == 0) {
                // 카드가 짝수개이면 마지막에 playerB가 뽑음
                playerATurn = false;
            }

            for(int i = 1 ; i <= n ; i ++) {
                for(int j = 1 ; j <= n - i + 1 ; j ++) {
                    // 대각선으로 내려가는 로직 => dp[j][i + j - 1]
                    int row = j;
                    int col = i + j - 1;

                    if(playerATurn) {   // playerA 차례에는 최대한 크게
                        dp[row][col] = Math.max(dp[row + 1][col] + arr[row], dp[row][col - 1] + arr[col]);
                    } else {        // playerB 차례에는 최대한 작게
                        dp[row][col] = Math.min(dp[row + 1][col], dp[row][col - 1]);
                    }
                }
                playerATurn = !playerATurn;
            }

            System.out.println(dp[1][n]);
        }
    }
}
