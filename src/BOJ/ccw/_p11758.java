package BOJ.ccw;

import java.util.Scanner;

public class _p11758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if(ccw < 0) {
            System.out.println(-1);
        } else if(ccw > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
