package BOJ.dp.game_theory;

import java.util.Scanner;

public class p9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = n % 2 == 0 ? "CY" : "SK";
        System.out.println(str);
    }
}
