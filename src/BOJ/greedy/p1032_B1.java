package BOJ.greedy;

/**
 * 명령 프롬프트
 * 브론즈 1
 * https://www.acmicpc.net/problem/1032
 */

import java.util.Scanner;

public class p1032_B1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = new String[n];

        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextLine();
        }

        String answer = input[0];
        for (int i = 1 ; i < n ; i ++) {
            for (int j = 0 ; j < answer.length() ; j ++) {
                if (answer.charAt(j) != '?') {
                    if (answer.charAt(j) != input[i].charAt(j)) {
                        answer = answer.substring(0, j) + '?' + answer.substring(j + 1);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
