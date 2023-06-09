package BOJ.etc;

import java.util.Scanner;

public class p1002 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();

        for (int t = 0 ; t < testCaseCnt ; t ++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double r1 = sc.nextDouble();

            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double r2 = sc.nextDouble();

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else {
                double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                double farDist = dist + (Math.min(r1, r2));

                if (farDist < Math.max(r1, r2)) {
                    System.out.println(0);
                }else if (dist == r1 + r2 || farDist == Math.max(r1, r2)) {
                    System.out.println(1);
                } else if (dist < r1 + r2) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
