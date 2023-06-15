package BOJ.etc;

import java.util.Scanner;

public class p1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < n ; i ++) {
            int x = sc.nextInt();
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        System.out.println(max * min);
    }
}
