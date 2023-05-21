// https://www.acmicpc.net/problem/1260

package Basic;

import java.util.*;

public class DFS_BFS {

    static ArrayList<Integer>[] connections;
    static boolean[] check;
    static List<Integer> result;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // 정점 개수 (1~n)
        m = sc.nextInt();       // 간선 개수
        int start = sc.nextInt();   // 시작 정점 번호

        makeConnections(sc);

        reset();
        dfs(start);
        printResult();

        reset();
        bfs(start);
        printResult();
    }

    private static void dfs(int now) {
        result.add(now);
        check[now] = true;

        for (int next : connections[now]) {
            if (check[next] == false) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        // Queue 사용(FIFO)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int next : connections[now]) {
                if (check[next] == false) {
                    check[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    /**
     *      입력     =>  connections  으로 만드는 함수
     *      4 5 1       1 => 2 3 4
     *      1 2         2 => 1 4
     *      1 3         3 => 1 4
     *      1 4         4 => 1 2 3
     *      2 4
     *      3 4
     */
    private static void makeConnections(Scanner sc) {

        connections = new ArrayList[n + 1];

        for (int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= m ; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            connections[x].add(y);
            connections[y].add(x);
        }

        for (int i = 1 ; i <= n ; i ++) {
            Collections.sort(connections[i]);
        }
    }

    /**
     * check, result 초기화
     */
    private static void reset() {
        check = new boolean[n + 1];
        Arrays.fill(check, false);
        result = new ArrayList<>();
    }

    /**
     * result 출력
     */
    private static void printResult() {
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
