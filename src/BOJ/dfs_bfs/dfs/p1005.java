package BOJ.dfs_bfs.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class p1005 {

    private static ArrayList[] connections;
    private static int[] maxCost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTestCase = sc.nextInt();
        for (int t = 0 ; t < totalTestCase ; t ++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] time = new int[n + 1];
            connections = new ArrayList[n + 1];
            for (int i = 1 ; i <= n ; i ++) {
                time[i] = sc.nextInt();
                connections[i] = new ArrayList<Node>();
            }

            for (int i = 1 ; i <= k ; i ++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                connections[y].add(new Node(x, time[x]));
            }

            int w = sc.nextInt();
            maxCost = new int[n + 1];
            maxCost[w] = time[w];
            dfs(w);

            int max = 0;
            for (int i = 1 ; i <= n ; i ++) {
                max = Math.max(max, maxCost[i]);
            }
            System.out.println(max);
        }
    }

    private static void dfs(int now) {
        for (Object obj : connections[now]) {
            Node node = (Node) obj;

            if (maxCost[node.next] < maxCost[now] + node.cost) {
                maxCost[node.next] = maxCost[now] + node.cost;
                dfs(node.next);
            }
        }
    }

    private static class Node {
        int next, cost;
        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
