package BOJ.mathematics.primeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p14860 {

    static final long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m > n) {
            int temp = n;
            n = m;
            m = temp;
        }

        List<PrimeNumber> primeNumbers = getPrimeNumbers(m);
        long answer = 1;

        for (PrimeNumber primeNumber : primeNumbers) {
            long cnt = (n / primeNumber.num) * (m / primeNumber.num);

            answer *= power(primeNumber.root, cnt);
            answer %= mod;
        }

        System.out.println(answer);
    }

    private static List<PrimeNumber> getPrimeNumbers(int x) {
        boolean[] isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2 ; i * i <= x ; i ++) {
            if (isPrime[i] == true) {
                for (int j = i * 2 ; j <= x ; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<PrimeNumber> primeNumbers = new ArrayList<>();
        for (int i = 2 ; i <= x ; i ++) {
            if (isPrime[i]) {
                long temp = i;
                while(temp <= x) {
                    primeNumbers.add(new PrimeNumber(i, temp));
                    temp *= i;
                }
            }
        }

        return primeNumbers;
    }

    private static class PrimeNumber {
        long root, num;

        PrimeNumber(long root, long num) {
            this.root = root;
            this.num = num;
        }
    }

    /**
     * n의 x승 (n^x)를 logN의 시간 복잡도로 계산
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
}