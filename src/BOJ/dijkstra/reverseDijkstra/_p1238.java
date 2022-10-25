package BOJ.dijkstra.reverseDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _p1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] connections = new ArrayList[n + 1];
        ArrayList<Node>[] reverseConnections = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<>();
            reverseConnections[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connections[s].add(new Node(e, v));
            reverseConnections[e].add(new Node(s, v));
        }

        int[] dist1 = dijkstra(connections, x, n);      // 모든 노드 -> x
        int[] dist2 = dijkstra(reverseConnections, x, n);   // x -> 모든 노드

        int max = 0;
        for(int i = 1 ; i <= n ; i ++) {
            max = Math.max(max, dist1[i] + dist2[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(ArrayList<Node>[] connections, int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<PqFormat> pq = new PriorityQueue<>();
        pq.add(new PqFormat(start, 0));

        while(!pq.isEmpty()) {
            PqFormat now = pq.poll();
            if(visited[now.index] == true) continue;

            visited[now.index] = true;
            for(Node node : connections[now.index]) {
                // dist[다음노드] > dist[현재노드] + 현재노드에서 다음노드로 가는 비용이면 갱신
                if(dist[node.next] > dist[now.index] + node.cost) {
                    dist[node.next] = dist[now.index] + node.cost;
                    pq.add(new PqFormat(node.next, dist[node.next]));
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
