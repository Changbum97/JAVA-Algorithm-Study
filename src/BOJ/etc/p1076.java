package BOJ.etc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1076 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        Map<String, Integer> value = new HashMap<>();
        value.put("black", 0);
        value.put("brown", 1);
        value.put("red", 2);
        value.put("orange", 3);
        value.put("yellow", 4);
        value.put("green", 5);
        value.put("blue", 6);
        value.put("violet", 7);
        value.put("grey", 8);
        value.put("white", 9);

        long answer = ( value.get(s1) * 10 + value.get(s2) ) * (long)Math.pow(10, value.get(s3));
        System.out.println(answer);
    }
}
