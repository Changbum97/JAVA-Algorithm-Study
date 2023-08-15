package Programmers.bfs_dfs;

/**
 * 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * BFS, Graph를 사용한 Level3 예제
 */

import java.util.*;

public class Bfs_Graph_Level3_Example2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}) == 2);
    }

    static class Solution {
        public int solution(int n, int[][] results) {

            List<Integer>[] winList = new ArrayList[n + 1];
            List<Integer>[] loseList = new ArrayList[n + 1];
            for (int i = 1 ; i <= n ; i ++) {
                winList[i] = new ArrayList<>();
                loseList[i] = new ArrayList<>();
            }

            for(int[] result : results) {
                winList[result[0]].add(result[1]);
                loseList[result[1]].add(result[0]);
            }

            int answer = 0;
            for (int player = 1 ; player <= n ; player ++) {
                int winToPlayer = bfs(winList, player, n);
                int loseToPlayer = bfs(loseList, player, n);

                if (winToPlayer + loseToPlayer == n - 1) {
                    answer ++;
                }
            }

            return answer;
        }

        public static int bfs(List<Integer>[] list, int player, int n) {
            boolean[] check = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(player);
            check[player] = true;
            int result = 0;

            while(!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : list[now]) {
                    if (check[next] == false) {
                        result ++;
                        queue.add(next);
                        check[next] = true;
                    }
                }
            }

            return result;
        }
    }
}
