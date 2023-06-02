package BOJ.etc;

import java.util.Scanner;

public class p1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        n = (n / 100) * 100;
        for (int i = n ; i <= n + 99 ; i ++) {
            if (i % f == 0) {
                int temp = i % 100;
                if (temp == 0) {
                    System.out.println("00");
                } else if (temp <= 9) {
                    System.out.println("0" + temp);
                } else {
                    System.out.println(temp);
                }
                break;
            }
        }
    }
}
