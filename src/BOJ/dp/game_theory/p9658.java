package BOJ.dp.game_theory;

import java.util.Scanner;

public class p9658 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dp = new String[n + 4];
        dp[1] = "CY";
        dp[2] = "SK";
        dp[3] = "CY";
        dp[4] = "SK";
        for (int i = 5 ; i <= n ; i ++) {
            dp[i] = "SK";

            if (dp[i - 1].equals("SK") && dp[i - 3].equals("SK") && dp[i - 4].equals("SK")) {
                dp[i] = "CY";
            }
        }

        System.out.println(dp[n]);
    }
}
