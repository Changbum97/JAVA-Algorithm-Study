package BOJ.backTracking;

import java.util.Scanner;

public class p12100 {

    static int n, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] arr = new int[n][n];
        answer = 0;
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                arr[i][j] = sc.nextInt();
                answer = Math.max(answer, arr[i][j]);
            }
        }

        solve(0, arr);
        System.out.println(answer);
    }

    private static void solve(int x, int[][] arr) {
        if (x >= 5) {
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    answer = Math.max(answer, arr[i][j]);
                }
            }
            return;
        }

        int[][] temp = copy(arr);
        solve(x + 1, up(temp));
        temp = rotate(arr);
        solve(x + 1, up(temp));
        temp = rotate(rotate(arr));
        solve(x + 1, up(temp));
        temp = rotate(rotate(rotate(arr)));
        solve(x + 1, up(temp));
    }

    private static int[][] up(int[][] arr) {
        for (int j = 0 ; j < n ; j ++) {
            int i = 0;
            while(i < n - 1) {
                if (arr[i][j] == 0) {
                    boolean check = false;
                    for (int ii = i + 1 ; ii < n ; ii ++) {
                        if (arr[ii][j] != 0) {
                            check = true;
                            arr[i][j] = arr[ii][j];
                            arr[ii][j] = 0;
                            break;
                        }
                    }
                    if (check == false) {
                        break;
                    }
                } else {
                    for (int ii = i + 1 ; ii < n ; ii ++) {
                        if (arr[ii][j] == arr[i][j]) {
                            arr[i][j] = arr[i][j] * 2;
                            arr[ii][j] = 0;
                            break;
                        } else if (arr[ii][j] != 0 && arr[ii][j] != arr[i][j]) {
                            break;
                        }
                    }
                    i ++;
                }
            }
        }
        return arr;
    }

    private static int[][] copy(int[][] arr) {
        int[][] temp = new int[n][n];
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    private static int[][] rotate(int[][] arr) {
        int[][] temp = new int[n][n];
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                temp[i][j] = arr[j][n - i - 1];
            }
        }
        return temp;
    }
}
