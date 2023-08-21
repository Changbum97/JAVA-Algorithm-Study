package BOJ.mathematics.primeNumber;

/**
 * 소수 구하기
 * 실버 3
 * https://www.acmicpc.net/problem/1929
 */

import java.util.Arrays;
import java.util.Scanner;

public class p1929_S3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] isPrimeNumber = getPrimeNumbers(n);
        for (int i = m ; i <= n ; i ++) {
            if (isPrimeNumber[i]) {
                System.out.println(i);
            }
        }
    }

    private static boolean[] getPrimeNumbers(int n) {
        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[1] = false;

        for (int i = 2 ; i * i <= n ; i ++) {
            if (isPrimeNumber[i]) {
                for (int j = i + i ; j <= n ; j += i) {
                    isPrimeNumber[j] = false    ;
                }
            }
        }

        return isPrimeNumber;
    }
}
