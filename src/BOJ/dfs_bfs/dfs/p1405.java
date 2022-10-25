package BOJ.dfs_bfs.dfs;

import java.util.Scanner;

public class p1405 {

    static int n;
    static double[] directionPercentage = new double[4];
    static int[] directionX = new int[]{0, 0, +1, -1};
    static int[] directionY = new int[]{+1, -1, 0, 0};
    static int[][] check = new int[30][30];
    static double ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < 4 ; i ++) {
            directionPercentage[i] = sc.nextDouble() / 100.0;
        }

        // n이 최대 14이기 때문에 시작포인트를 15, 15로 잡음
        // 한 쪽으로 최대한 가도 배열의 범위를 벗어나지 않음
        check[15][15] = 1;

        dfs(15, 15, 0, 1.0);
        System.out.println(1 - ans);
    }

    static void dfs(int x, int y, int step, double percentage) {
        if(check[x][y] == 2) {
            ans += percentage;
            return;
        }

        if(step == n) {
            return;
        }

        for(int i = 0 ; i < 4 ; i ++) {
            if(directionPercentage[i] != 0) {
                int nextX = x + directionX[i];
                int nextY = y + directionY[i];

                check[nextX][nextY] ++;
                dfs(nextX, nextY, step + 1, percentage * directionPercentage[i]);
                check[nextX][nextY] --;
            }
        }
    }
}
