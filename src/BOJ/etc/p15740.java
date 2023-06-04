package BOJ.etc;

import java.math.BigDecimal;
import java.util.Scanner;

public class p15740 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(new BigDecimal(a).add(new BigDecimal(b)));
    }
}
