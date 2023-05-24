package BOJ.mathematics;

import java.util.Scanner;

public class p13412 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();   // 테스트 케이스 개수

        for (int i = 0 ; i < t ; i ++) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {
        if (n == 1) return 1;

        int divisor = 0;        // n의 약수 개수 ( 8 = 2 * 2 * 2 = 2^3 => 1개로 측정 )

        for (int i = 2 ; i <= n ; i ++) {
            if (n % i == 0) {
                divisor ++;
                while(n % i == 0) {
                    n /= i;
                }
            }
        }

        return (long) Math.pow(2, divisor - 1);
    }
}
