package BOJ.mathematics;

import java.util.Scanner;

public class p11444 {

    private static final long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 피보나치 수를 1,000,000,007로 나눈 나머지는 2,000,000,016 마다 반복됨
        int n = (int) (sc.nextLong() % 2000000016);

        /**
         *  [F(n+2)] = [1 1] * [F(n+1)]   =>  [F(n+1)] = [1 1] ^ n * [1]
         *  [F(n+1)]   [1 0]   [F(n)]         [F(n)]     [1 0]       [0]
         */

        long[][] ans = new long[][]{{1, 0}, {0, 1}};
        long[][] temp = new long[][]{{1, 1}, {1, 0}};

        while(n > 0) {
            if (n % 2 == 1) {
                ans = multiple(ans, temp);
            }
            temp = multiple(temp, temp);
            n /= 2;
        }

        System.out.println(ans[1][0]);
    }

    private static long[][] multiple(long[][] a, long[][] b) {
        long[][] c = new long[][]{
                {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
                {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };

        for (int i = 0 ; i <= 1 ; i ++) {
            for (int j = 0 ; j <= 1 ; j ++) {
                c[i][j] %= mod;
            }
        }

        return c;
    }
}
