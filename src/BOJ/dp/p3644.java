package BOJ.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class p3644 {

    private static final int max = 10001;

    public static void main(String[] args) {
        BigInteger[] fibo = new BigInteger[max];
        BigInteger[] fiboSum = new BigInteger[max];
        BigInteger[] dp = new BigInteger[max];

        fibo[0] = new BigInteger("1");
        fibo[1] = new BigInteger("2");
        fibo[2] = new BigInteger("3");

        fiboSum[0] = new BigInteger("1");
        fiboSum[1] = new BigInteger("3");
        fiboSum[2] = new BigInteger("6");

        /**
         * n = 8 인 경우
         * 1을 골랐을 때 => 5개(3, 4, 5, 6, 7)로 만들 수 있는 경우의 수(이 대, 3,7을 같이 고를 수 있음) => fibo[5]
         * 2를 골랐을 때 => 5개(4, 5, 6, 7, 8) '' => fibo[5]
         * 3을 골랐을 때 => 5, 6, 7, 8 => fibo[4]
         * 4를 골랐을 때 => 6, 7, 8 => fibo[3]
         * 5를 골랐을 때 => 7, 8 => fibo[2]
         * 6을 골랐을 때 => 8 => fibo[1]
         * 7을 골랐을 때 => X => fibo[0] = 1 => 7을 고른 경우 1가지
         * 8을 골랐을 때 => X => fibo[0]
         * => fibo[0] + fibo[0] ~ fibo[n - 3]까지의 합 + fibo[n - 3] + 1(아무것도 안 고른 경우)
         */
        for (int i = 3 ; i < max ; i ++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]);
            fiboSum[i] = fiboSum[i - 1].add(fibo[i]);
            dp[i] = fiboSum[i - 3].add(fibo[i - 3]).add(new BigInteger("2"));
        }

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
