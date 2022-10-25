package BOJ.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 정점의 개수
        int m = Integer.parseInt(st.nextToken());   // 간선의 개수

        List<Node>[] connections = new List[n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 연결
            connections[a].add(new Node(b, c));
            connections[b].add(new Node(a, c));
        }

        int[] dist = dijkstra(n, connections);
        int ans = dp(n, connections, dist);

        System.out.println(ans);
    }

    static int dp(int n, List<Node>[] connections, int[] dist) {
        // 2까지 가는 최단거리 기준으로 오름차순 정렬을 해야하기 때문에 PriorityQueue로 옮김
        PriorityQueue<PqFormat> distPq = new PriorityQueue<>();
        for(int i = 1 ; i <= n ; i ++) {
            distPq.add(new PqFormat(i, dist[i]));
        }
        distPq.poll();  // 2에서 2까지는 0이여서 맨 앞에 있을텐데, 2까지의 경로 가짓수는 1로 지정

        int[] dp = new int[n + 1];
        dp[2] = 1;

        while(!distPq.isEmpty()) {
            PqFormat now = distPq.poll();

            // 현재 노드와 연결되어 있는 노드 순회
            for(Node node : connections[now.index]) {
                // 현재 노드에 연결되어 있는 노드가 2까지 가는 최단경로가 짧다면
                // 연결되어 있는 노드의 가짓수를 모두 현재 노드에 더해줌
                if(dist[node.next] < dist[now.index]) {
                    dp[now.index] += dp[node.next];
                }
            }
            if(now.index == 1) {
                break;
            }
        }

        return dp[1];
    }
    static int[] dijkstra(int n, List<Node>[] connections) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[2] = 0;    // 문제에서 도착점은 2로 고정 => 역방향 다익스트라이기 때문에 2가 시작점이 됨

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<PqFormat> pq = new PriorityQueue<>();
        pq.add(new PqFormat(2, 0));

        while(!pq.isEmpty()) {
            PqFormat now = pq.poll();
            if(visited[now.index] == true) continue;
            visited[now.index] = true;

            for(Node next : connections[now.index]) {
                // 다음 갈 곳의 dist값이 현재까지의 dist + 현재 위치에서 다음 갈 곳까지의 비용보다 크면 갱신
                if(dist[next.next] > dist[now.index] + next.cost) {
                    dist[next.next] = dist[now.index] + next.cost;
                    pq.add(new PqFormat(next.next, dist[next.next]));
                }
            }
        }

        return dist;
    }

    static class Node {
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static class PqFormat implements Comparable<PqFormat> {
        int index, dist;

        public PqFormat(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(PqFormat o) {
            // dist 기준 오름차순 정렬
            return this.dist - o.dist;
        }
    }

}
