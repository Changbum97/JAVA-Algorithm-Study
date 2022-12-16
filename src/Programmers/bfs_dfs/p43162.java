package Programmers.bfs_dfs;

import java.util.*;

public class p43162 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 2, 1}}));
    }
    static class Solution {

        static int[] group;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            group = new int[n];

            for(int g = 0 ; g < n ; g ++) {
                if(group[g] != 0) continue;

                group[g] = ++ answer;

                dfs(g, n, computers, answer);

            }

            return answer;
        }

        public void dfs(int now, int n, int[][] computers, int groupCnt) {
            for(int i = 0 ; i < n ; i ++) {
                if(i == now || group[i] != 0) continue;
                if(computers[now][i] == 1) {
                    group[i] = groupCnt;
                    dfs(i, n, computers, groupCnt);
                }
            }
        }
    }
}
