package BOJ.dp;

import java.util.Scanner;

public class p9656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = n % 2 == 1 ? "CY" : "SK";
        System.out.println(str);
    }
}
