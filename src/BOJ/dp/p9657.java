package BOJ.dp;

import java.util.Scanner;

public class p9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String dp[] = new String[n + 3];
        dp[0] = "CY";
        dp[1] = "SK";
        dp[2] = "CY";
        dp[3] = "SK";

        for (int i = 4 ; i <= n ; i ++) {
            dp[i] = "CY";
            if (dp[i - 1].equals("CY") || dp[i - 3].equals("CY") || dp[i - 4].equals("CY")) {
                dp[i] = "SK";
            }
        }

        System.out.println(dp[n]);
    }
}
