package BOJ.dfs_bfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p25307 {
    static int n, m, k;
    static int[][] arr;

    static int[] row = new int[]{0, 0, 1, -1};
    static int[] col = new int[]{1, -1, 0, 0};

    // 마네킹의 범위 내에 있는지 체크하는 배열
    static boolean[][] inMannequinRange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 행
        m = Integer.parseInt(st.nextToken());   // 열
        k = Integer.parseInt(st.nextToken());   // 마네킹과 떨어져야 하는 거리

        arr = new int[n][m];
        inMannequinRange = new boolean[n][m];
        Point start = null;
        Queue<Point> mannequinList = new LinkedList<>();

        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 0:빈칸  1:기둥  2:의자  3:마네킹  4:시루의 시작위치
                if(arr[i][j] == 4) {
                    // 시루의 시작 위치
                    start = new Point(i, j, 0);
                } else if(arr[i][j] == 3) {
                    // 마네킹들의 위치
                    mannequinList.add(new Point(i, j, 0));
                    inMannequinRange[i][j] = true;
                }
            }
        }

        // 마네킹에서 K이하의 거리에 있는 지점들을 모두 체크
        mannequinCheck(mannequinList);

        // 시루의 시작 위치에서 의자를 찾아가는 bfs
        System.out.println(bfs(start.x, start.y));
    }

    static void mannequinCheck(Queue<Point> mannequinList) {
        while(!mannequinList.isEmpty()) {
            Point now = mannequinList.poll();
            if(now.dist == k) continue;     // 마네킹과의 거리가 k이상인 곳은 가면 안됨

            for(int i = 0 ; i < 4 ; i ++) {
                int nextX = now.x + row[i];
                int nextY = now.y + col[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                if(inMannequinRange[nextX][nextY] == false) {
                    inMannequinRange[nextX][nextY] = true;
                    mannequinList.add(new Point(nextX, nextY, now.dist + 1));
                }
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));

        // 방문했는지 중복 체크에 사용하는 배열
        boolean[][] check = new boolean[n][m];
        check[x][y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            // 현재 위치가 의자라면 바로 return
            if(arr[now.x][now.y] == 2) {
                return now.dist;
            }

            for(int i = 0 ; i < 4 ; i ++) {
                int nextX = now.x + row[i];
                int nextY = now.y + col[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                // 다음에 갈 곳이 전에 방문한 적이 없고 && 기둥이 아니고 && 마네킹에서 K보다 멀리 떨어져 있는 경우
                if(check[nextX][nextY] == false && arr[nextX][nextY] != 1 && inMannequinRange[nextX][nextY] == false) {
                    queue.add(new Point(nextX, nextY, now.dist + 1));
                    check[nextX][nextY] = true;
                }
            }
        }

        // 이전에 의자를 찾지 못해서 여기까지 왔으므로 -1 return
        return -1;
    }

    static class Point {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}