package BOJ.mathematics;

import java.util.Scanner;

public class p2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = (int) (sc.nextLong() % 1500000);

        if(n == 0) {
            System.out.println(0);
        } else if(n == 1) {
            System.out.println(1);
        } else {
            int a = 0;
            int b = 1;
            int c = 0;

            for(int i = 2 ; i <= n ; i ++) {
                c = (a + b) % 1000000;
                a = b; b = c;
            }
            System.out.println(c);
        }
    }
}
