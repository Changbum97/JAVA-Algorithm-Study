package BOJ.etc;

import java.util.Scanner;

public class p1051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][m];
        for (int i = 0 ; i < n ; i ++) {
            String str = sc.nextLine();
            for (int j = 0 ; j < m ; j ++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = 1;
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                int k = 0;
                while(true) {
                    if (i + k >= n || j + k >= m) break;

                    if (arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i + k][j + k]) {
                        answer = Math.max((k + 1) * (k + 1), answer);
                    }
                    k ++;
                }
            }
        }
        System.out.println(answer);
    }
}
