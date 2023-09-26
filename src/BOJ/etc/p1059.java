package BOJ.etc;

import java.util.Scanner;

public class p1059 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] arr = new int[l];

        for (int i = 0 ; i < l ; i ++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int left = 0;   // n이 S[0]보다 작은 경우를 대비하여 0으로 설정
        int right = Integer.MAX_VALUE;

        for (int a : arr) {
            if (a == n) {
                System.out.println(0);
                System.exit(0);
            }

            if (a < n) {
                left = Math.max(left, a);
            } else {
                right = Math.min(right, a);
            }
        }

        // [왼쪽 중 하나, 오른쪽 중 하나] + [n, 왼쪽 or 오른쪽 중 하나]
        System.out.println( (n - left - 1) * (right - n - 1) + (right - left - 2) );
    }
}
