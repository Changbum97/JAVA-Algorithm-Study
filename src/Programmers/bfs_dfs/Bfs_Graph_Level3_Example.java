package Programmers.bfs_dfs;

/**
 * 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * BFS, Graph를 사용한 Level3 예제
 */

import java.util.*;

public class Bfs_Graph_Level3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}) == 3);
    }

    static class Solution {
        public int solution(int n, int[][] edge) {

            List<Integer>[] connections = new ArrayList[n + 1];
            int[] check = new int[n + 1];

            for (int i = 1 ; i <= n ; i ++) {
                connections[i] = new ArrayList<Integer>();
                check[i] = -1;
            }

            for (int[] e : edge) {
                connections[e[0]].add(e[1]);
                connections[e[1]].add(e[0]);
            }

            check[1] = 0;

            Queue<Ns> queue = new LinkedList<>();
            queue.add(new Ns(1, 0));

            int maxStep = 0;
            while(!queue.isEmpty()) {
                Ns now = queue.poll();

                for (int next : connections[now.node]) {
                    if (check[next] == -1) {
                        check[next] = now.step + 1;
                        queue.add(new Ns(next, now.step + 1));
                        maxStep = Math.max(now.step + 1, maxStep);
                    }
                }
            }

            int answer = 0;
            for (int step : check) {
                if (step == maxStep) {
                    answer ++;
                }
            }

            return answer;
        }

        // Node And Step
        class Ns {
            int node, step;

            Ns (int node, int step) {
                this.node = node;
                this.step = step;
            }
        }
    }
}
