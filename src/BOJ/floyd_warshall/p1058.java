package BOJ.floyd_warshall;

import java.util.Scanner;

public class p1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        sc.nextLine();
        for (int i = 0 ; i < n ; i ++) {
            String str = sc.nextLine();
            for (int j = 0 ; j < str.length() ; j ++) {
                if (str.charAt(j) == 'Y') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // i:중간점   j:시작점   k:끝점
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (i == j || arr[j][i] == Integer.MAX_VALUE) continue;

                for (int k = 0 ; k < n ; k ++) {
                    if (i == k || j == k || arr[i][k] == Integer.MAX_VALUE) continue;

                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0 ; i < n ; i ++) {
            int temp = 0;
            for (int j = 0 ; j < n ; j ++) {
                if (arr[i][j] <= 2) {
                    temp ++;
                }
            }
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
