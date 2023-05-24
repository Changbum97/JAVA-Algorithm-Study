package BOJ.dp.game_theory;

import java.util.Scanner;

public class p9659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String str = n % 2 == 0 ? "CY" : "SK";
        System.out.println(str);
    }
}
