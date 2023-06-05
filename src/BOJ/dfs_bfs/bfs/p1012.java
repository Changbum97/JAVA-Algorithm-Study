package BOJ.dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1012 {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int t = 0 ; t < testCase ; t ++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            arr = new int[n][m];
            for (int i = 0 ; i < k ; i ++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }

            System.out.println(count());
        }
    }

    private static int count() {
        int result = 0;

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (arr[i][j] == 1) {
                    result ++;
                    bfs(i, j);
                }
            }
        }

        return result;
    }

    private static void bfs(int x, int y) {
        Queue<Land> queue = new LinkedList<>();
        queue.add(new Land(x, y));
        arr[x][y] = 0;

        int row[] = {1, -1, 0, 0};
        int col[] = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            Land now = queue.poll();

            for (int i = 0 ; i < 4 ; i ++) {
                int nextX = now.x + row[i];
                int nextY = now.y + col[i];
                if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0) {
                    continue;
                }

                if (arr[nextX][nextY] == 1) {
                    arr[nextX][nextY] = 0;
                    queue.add(new Land(nextX, nextY));
                }
            }
        }
    }

    private static class Land {
        int x, y;
        Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
