package BOJ.etc;

import java.util.Scanner;

public class p11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1 ; i <= t ; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d\n", i, x, y, x+y);
        }
    }
}
