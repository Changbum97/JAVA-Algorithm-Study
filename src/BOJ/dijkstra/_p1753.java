package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _p1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] connections = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e ; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            connections[x].add(new Node(y, z));
        }
        /*
            입력          =>      connections
            5 6                  [1] = { (2,2), (3,3) }
            1                    [2] = { (3,4), (4,5) }
            5 1 1                [3] = { (4,6) }
            1 2 2                [4] = {}
            1 3 3                [5] = { (1,1) }
            2 3 4
            2 4 5
            3 4 6
        */

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
                // now.index : 현재 노드 번호    now.dist : 현재 노드의 dist
                // node.next : 현재 노드와 연결된 다음 노드 번호
                // node.cost : 현재 노드에서 다음 노드까지 가는데의 비용

                // dist[다음노드] > dist[현재노드] + 현재노드에서 다음노드 가는 비용이면 갱신
                if(dist[node.next] > dist[now.index] + node.cost) {
                    dist[node.next] = dist[now.index] + node.cost;
                    pq.add(new PqFormat(node.next, dist[node.next]));
                }
            }
        }

        for(int i = 1 ; i <= n ; i ++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    static class Node {
        int next, cost;
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static class PqFormat implements Comparable<PqFormat>{
        int index, dist;
        PqFormat(int index, int dist) {
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
