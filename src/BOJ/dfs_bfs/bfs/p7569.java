package BOJ.dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7569 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] box = new int[h][n][m];

        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 공간
        int zeroCnt = 0;
        Queue<Tomato> tomatoQueue = new LinkedList<>();

        for (int i = 0 ; i < h ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                for (int k = 0 ; k < m ; k ++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 0) {
                        zeroCnt ++;
                    } else if (box[i][j][k] == 1) {
                        tomatoQueue.add(new Tomato(j, k, i));
                    }
                }
            }
        }

        int[] xDir = new int[]{1, -1, 0, 0, 0, 0};
        int[] yDir = new int[]{0, 0, 1, -1, 0, 0};
        int[] zDir = new int[]{0, 0, 0, 0, 1, -1};
        int answer = 1;

        while(!tomatoQueue.isEmpty()) {
            Tomato tomato = tomatoQueue.poll();

            for (int i = 0 ; i < 6 ; i ++) {
                int nextX = tomato.x + xDir[i];
                int nextY = tomato.y + yDir[i];
                int nextZ = tomato.z + zDir[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || nextZ < 0 || nextZ >= h) {
                    continue;
                }

                int nowDay = box[tomato.z][tomato.x][tomato.y];

                // 익지 않은 토마토라면 익히게 함
                if (box[nextZ][nextX][nextY] == 0) {
                    if (nowDay + 1 > answer) {
                        answer = nowDay + 1;
                    }

                    zeroCnt --;
                    box[nextZ][nextX][nextY] = nowDay + 1;
                    tomatoQueue.add(new Tomato(nextX, nextY, nextZ));
                }
            }
        }

        // 토마토가 다 익지 못하는 상황
        if (zeroCnt != 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer - 1);
        }
    }

    private static class Tomato {
        int x, y, z;

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
