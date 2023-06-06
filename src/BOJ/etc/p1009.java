package BOJ.etc;

import java.util.Scanner;

public class p1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int j = 1 ; j <= n ; j ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int tempA = a;

            for (int i = 2 ; i <= b ; i ++) {
                tempA *= a;
                tempA %= 10;
            }

            tempA %= 10;

            if (tempA == 0) {
                System.out.println(10);
            } else {
                System.out.println(tempA);
            }
        }
    }
}
