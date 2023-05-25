package BOJ.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p16120 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> ppap = new ArrayList<>();

        for (int i = str.length() - 1 ; i >= 0 ; i --) {
            if (str.charAt(i) == 'P') {
                if (i != 0 && str.charAt(i - 1) == 'A') {
                    ppap.add(1);
                    i --;
                } else {
                    ppap.add(-1);
                }
            } else {
                System.out.println("NP");
                System.exit(0);
            }
        }

        int check = 0;
        for (int i = 0 ; i < ppap.size() - 1 ; i ++) {
            check += ppap.get(i);
            if (check < 0) {
                System.out.println("NP");
                System.exit(0);
            }
        }

        if (check == 0 && ppap.get( ppap.size() - 1 ) == -1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
