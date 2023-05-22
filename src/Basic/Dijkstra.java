// https://www.acmicpc.net/problem/1753

package Basic;

import java.util.*;

public class Dijkstra {

    static int n, m;
    static ArrayList<Edge>[] connections;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 정점의 개수
        m = sc.nextInt();   // 간선의 개수
        int start = sc.nextInt();   // 시작 정점 번호

        makeConnections(sc);

        dijkstra(start);
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] result = new int[n + 1];          // 출발점에서 부터의 최단 거리
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        boolean[] check = new boolean[n + 1];  // check가 true이면 최단거리가 확정된 정점
        Arrays.fill(check, false);

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 최단거리가 확정된 정점이 아닌 경우에만 진행
            if (check[now.index] == false) {
                check[now.index] = true;

                // 현재 노드와 연결된 간선 조회
                for (Edge edge : connections[now.index]) {
                    // 다음 정점(edge.next)의 지금까지 구한 최단거리보다 현재 정점(now.index) + 현재 정점에서 다음 정점의 거리가 작다면 갱신
                    if (result[edge.next] > result[now.index] + edge.dist) {
                        result[edge.next] = result[now.index] + edge.dist;
                        pq.add(new Node(edge.next, result[edge.next]));
                    }
                }
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (check[i] == false) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    /**
     *      입력     =>  connections  으로 만드는 함수
     *      5 6         1 => { (2, 2), (3, 3) }
     *      1           2 => { (3, 4), (4, 5) }
     *      5 1 1       3 => { (4, 6) }
     *      1 2 2       4 => { }
     *      1 3 3       5 => { (1, 1) }
     *      2 3 4
     *      2 4 5
     *      3 4 6
     */
    private static void makeConnections(Scanner sc) {

        connections = new ArrayList[n + 1];

        for (int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<Edge>();
        }

        for (int i = 1 ; i <= m ; i ++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            connections[start].add(new Edge(end, dist));
        }
    }

    private static class Edge {
        int next;   // 다음 정점 번호
        int dist;   // 다음 정점에 가는데 드는 비용

        Edge(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    private static class Node implements Comparable<Node>{
        int index;  // 정점 번호
        int dist;   // 출발점 ~ 정점 까지의 최소 거리

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            // dist를 기준으로 오름차순 정렬
            return this.dist - o.dist;
        }
    }
}
