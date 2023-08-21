package BOJ.mathematics.primeNumber;

/**
 * GCD 곱
 * https://www.acmicpc.net/problem/14860
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p14860 {

    private static final long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<PrimeNumber> primeNumbers = getPrimeNumbers(Math.min(n, m));
        long answer = 1;

        for (PrimeNumber primeNumber : primeNumbers) {
            // n * m 범위에 primeNumber.num이 곱해진 횟수
            long cnt = (n / primeNumber.num) * (m / primeNumber.num);

            // primeNumber.num = 4라면 2는 이전에 계산
            // 따라서 4인 경우 2만 한 번 더 곱해주면 됨
            answer *= power(primeNumber.root, cnt);
            answer %= mod;
        }

        System.out.println(answer);
    }

    /**
     * n^x 계산을 logx만에 해결
     */
    private static long power(long n, long x) {
        if (x == 0) return 1;
        if (x == 1) return n;

        long halfAnswer = power(n, x / 2) % mod;
        long fullAnswer = (halfAnswer * halfAnswer) % mod;

        // ex) 3^7 => (3^3) * (3^3) * 3
        if (x % 2 == 1) {
            fullAnswer *= n;
            fullAnswer %= mod;
        }

        return fullAnswer;
    }

    private static List<PrimeNumber> getPrimeNumbers(int x) {

        List<PrimeNumber> primeNumbers = new ArrayList<>();

        boolean[] isPrimeNumber = new boolean[x + 1];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[1] = false;

        for (int i = 2 ; i <= x ; i ++) {
            if (isPrimeNumber[i]) {
                for (int j = i + i ; j <= x ; j += i) {
                    isPrimeNumber[j] = false;
                }

                long temp = i;
                while (temp <= x) {
                    primeNumbers.add(new PrimeNumber(temp, i));
                    temp *= i;
                }
            }
        }

        return primeNumbers;
    }

    private static class PrimeNumber {
        // num = 8인 경우, root = 2
        long num, root;

        PrimeNumber(long num, long root) {
            this.num = num;
            this.root = root;
        }
    }
}
