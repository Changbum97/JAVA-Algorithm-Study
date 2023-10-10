package BOJ.etc;

import java.util.Scanner;

public class p2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int time = sc.nextInt();

        h += time / 60;
        m += time % 60;
        if (m >= 60) {
            m -= 60;
            h ++;
        }
        if (h >= 24) {
            h -= 24;
        }

        System.out.println(h + " " + m);
    }
}
