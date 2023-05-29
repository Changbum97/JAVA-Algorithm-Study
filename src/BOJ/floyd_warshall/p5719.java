package BOJ.floyd_warshall;

import java.util.*;

public class p5719 {

    static List<Node>[] connections;
    static int[][] input;
    static int[][] floydResult;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            n = sc.nextInt();   // 장소 개수 (0 ~ n-1)
            m = sc.nextInt();   // 도로 개수
            if (n == 0 && m == 0) {
                break;
            }

            int s = sc.nextInt();   // 시작 장소
            int e = sc.nextInt();   // 도착 장소
            input = new int[m][3];

            connections = new ArrayList[n];
            floydResult = new int[n][n];
            for (int i = 0 ; i < n ; i ++) {
                connections[i] = new ArrayList<>();
                Arrays.fill(floydResult[i], Integer.MAX_VALUE);
                floydResult[i][i] = 0;
            }

            for (int i = 0 ; i < m ; i ++) {
                input[i][0] = sc.nextInt();
                input[i][1] = sc.nextInt();
                input[i][2] = sc.nextInt();

                floydResult[input[i][0]][input[i][1]] = input[i][2];
            }

            floyd();
            int minCost = floydResult[s][e];
            if (minCost == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }

            for (int i = 0 ; i < m ; i ++) {
                int beforeNode = input[i][0];
                int afterNode = input[i][1];
                int cost = input[i][2];

                if (floydResult[s][beforeNode] != Integer.MAX_VALUE && floydResult[afterNode][e] != Integer.MAX_VALUE
                && floydResult[s][beforeNode] + cost + floydResult[afterNode][e] != minCost) {
                    // a에서 b로 가는데 c만큼의 비용 (단방향)
                    connections[beforeNode].add(new Node(afterNode, cost));
                }
            }

            System.out.println(dijkstra(s, e));
        }
    }

    private static void floyd() {
        // i:중간점   j:시작점   k:끝점
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(floydResult[j][i] == Integer.MAX_VALUE) continue;
                for(int k = 0 ; k < n ; k ++) {
                    if(floydResult[i][k] == Integer.MAX_VALUE) continue;

                    if(floydResult[j][k] > floydResult[j][i] + floydResult[i][k]) {
                        floydResult[j][k] = floydResult[j][i] + floydResult[i][k];
                    }
                }
            }
        }
    }

    private static int dijkstra(int start, int end) {
        boolean[] check = new boolean[n];
        Arrays.fill(check, false);

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        PriorityQueue<PqNode> pq = new PriorityQueue<>();
        pq.add(new PqNode(start, 0));

        while(!pq.isEmpty()) {
            PqNode pqNode = pq.poll();
            if (check[pqNode.idx] == false) {
                check[pqNode.idx] = true;

                for (Node node : connections[pqNode.idx]) {
                    if (result[node.next] > result[pqNode.idx] + node.cost) {
                        result[node.next] = result[pqNode.idx] + node.cost;
                        pq.add(new PqNode(node.next, pqNode.totalCost + node.cost));
                    }
                }
            }
        }

        if (result[end] == Integer.MAX_VALUE) {
            return -1;
        }
        return result[end];
    }

    private static class Node {
        int next, cost;

        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    private static class PqNode implements Comparable<PqNode> {
        int idx, totalCost;

        PqNode(int idx, int totalCost) {
            this.idx = idx;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(PqNode o) {
            // totalCost를 기준으로 오름차순 정렬
            return this.totalCost - o.totalCost;
        }
    }

}