package BOJ.etc;

import java.util.Scanner;

public class p1018 {

    private static String[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        board = new String[n];
        for (int i = 0 ; i < n ; i ++) {
            board[i] = sc.nextLine();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0 ; i < n - 7 ; i ++) {
            for (int j = 0 ; j < m - 7 ; j ++) {
                int temp = check(i, j);
                answer = Math.min(answer, temp);
            }
        }
        System.out.println(answer);
    }

    private static int check(int x, int y) {
        int case1 = 0;
        int case2 = 0;

        for (int i = x ; i < x + 8 ; i ++) {
            for (int j = y ; j < y + 8 ; j ++) {
                char c = board[i].charAt(j);
                if ((i + j) % 2 == 0) {
                    if (c == 'W') {
                        case1 ++;
                    } else {
                        case2 ++;
                    }
                } else {
                    if (c == 'W') {
                        case2 ++;
                    } else {
                        case1 ++;
                    }
                }
            }
        }

        return case1 < case2 ? case1 : case2;
    }
}
