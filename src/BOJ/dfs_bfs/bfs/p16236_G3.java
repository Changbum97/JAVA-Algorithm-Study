package BOJ.dfs_bfs.bfs;

/**
 * 아기 상어
 * 골드 3
 * https://www.acmicpc.net/problem/16236
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class p16236_G3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] fishes = new int[7];

        int x = 0;
        int y = 0;

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                int num = sc.nextInt();
                if (num == 0) {
                    arr[i][j] = 0;
                } else if (num == 9) {
                    arr[i][j] = 0;
                    x = i;
                    y = j;
                } else {
                    arr[i][j] = num;
                    fishes[num] ++;
                }
            }
        }

        bfs(n, x, y, arr, fishes);
    }

    private static void bfs(int n, int x, int y, int[][] arr, int[] fishes) {
        int[] rows = new int[]{0, 0, 1, -1};
        int[] cols = new int[]{1, -1, 0, 0};

        PriorityQueue<Co> pq;
        boolean[][] check;

        int sharkSize = 2;
        int sharkEat = 0;
        int time = 0;

        while (getTotalSmallFish(fishes, sharkSize) != 0) {
            pq = new PriorityQueue<>();
            pq.add(new Co(x, y, 0));

            check = new boolean[n][n];
            check[x][y] = true;
            boolean eat = false;

            while(!pq.isEmpty()) {
                Co co = pq.poll();

                if (arr[co.x][co.y] != 0 && arr[co.x][co.y] < sharkSize) {
                    sharkEat ++;
                    fishes[arr[co.x][co.y]] --;
                    arr[co.x][co.y] = 0;
                    if (sharkEat == sharkSize) {
                        sharkSize ++;
                        sharkEat = 0;
                    }
                    time += co.step;
                    x = co.x;
                    y = co.y;
                    eat = true;

                    break;
                }

                for (int i = 0 ; i < 4 ; i ++) {
                    int newX = co.x + rows[i];
                    int newY = co.y + cols[i];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                    if (arr[newX][newY] > sharkSize) continue;
                    if (check[newX][newY] == true) continue;

                    check[newX][newY] = true;
                    pq.add(new Co(newX, newY, co.step + 1));
                }
            }

            if (!eat) {
                break;
            }
        }

        System.out.println(time);
    }

    private static int getTotalSmallFish(int[] fishes, int sharkSize) {
        int result = 0;

        for (int i = 1 ; i < Math.min(sharkSize, 7) ; i ++) {
            result += fishes[i];
        }

        return result;
    }

    private static class Co implements Comparable<Co> {
        int x, y, step;
        Co (int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int compareTo(Co co) {
            // step > 상단 > 왼쪽 순으로 우선 순위
            if (co.step == this.step) {
                if (co.x == this.x) {
                    return this.y - co.y;
                }
                return this.x - co.x;
            }
            return this.step - co.step;
        }
    }
}
