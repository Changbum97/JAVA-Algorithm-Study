package Programmers.bfs_dfs;

import java.util.*;

public class p49191 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
        System.out.println(s.solution(7, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}, {5, 6}, {6,7}}));
    }
    static class Solution {

        static int cnt = 0;
        static boolean[] check;

        public int solution(int n, int[][] results) {
            int answer = 0;

            // i번째 List에는 i가 이긴 선수들 저장
            List<Integer>[] winList = new ArrayList[n + 1];
            List<Integer>[] loseList = new ArrayList[n + 1];

            for(int i = 1 ; i <= n ; i ++) {
                winList[i] = new ArrayList<>();
                loseList[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < results.length ; i ++) {
                int winner = results[i][0];
                int loser = results[i][1];

                winList[winner].add(loser);
                loseList[loser].add(winner);
            }

            for(int i = 1 ; i <= n ; i ++) {
                cnt = 0;
                check = new boolean[n + 1];
                check[i] = true;
                dfs(winList, i, n);
                dfs(loseList, i, n);

                if(cnt == n - 1) {
                    answer ++;
                }
            }

            return answer;
        }

        public void dfs(List<Integer>[] connections, int idx, int n) {
            for(int next : connections[idx]) {
                if(check[next] == false) {
                    check[next] = true;
                    cnt ++;
                    dfs(connections, next, n);
                }
            }
        }
    }
}
