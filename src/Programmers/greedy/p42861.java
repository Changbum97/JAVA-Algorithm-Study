package Programmers.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class p42861 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
    static class Solution {
        public int solution(int n, int[][] costs) {
            int answer = 0;

            int[][] dist = new int[n][n];
            for(int i = 0 ; i < n ; i ++) {
                Arrays.fill(dist[i], - 1);
            }

            for(int i = 0 ; i < costs.length ; i ++) {
                dist[costs[i][0]][costs[i][1]] = costs[i][2];
                dist[costs[i][1]][costs[i][0]] = costs[i][2];
            }

            boolean[] check = new boolean[n];
            Arrays.fill(check, false);
            check[0] = true;
            PriorityQueue<Bridge> pq = new PriorityQueue<>((o1, o2) -> {
               return o1.cost - o2.cost;
            });

            for(int i = 0 ; i < n ; i ++) {
                if(dist[0][i] != -1) {
                    pq.add(new Bridge(i, dist[0][i]));
                }
            }

            while(!pq.isEmpty()) {
                Bridge bridge = pq.poll();
                if(check[bridge.next] == true) continue;;

                answer += bridge.cost;
                check[bridge.next] = true;

                for(int i = 0 ; i < n ; i ++) {
                    if(dist[bridge.next][i] != -1) {
                        pq.add(new Bridge(i, dist[bridge.next][i]));
                    }
                }
            }

            return answer;
        }

        class Bridge {
            int next, cost;
            Bridge(int next, int cost) {
                this.next = next;
                this.cost = cost;
            }
        }
    }
}
