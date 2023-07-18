package Programmers._codingTest;

public class Floyd_Lv3_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(s.solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(s.solution(6, 4, 5, 6, new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }

    static class Solution {
        static final int maxValue = 22222222;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = Integer.MAX_VALUE;

            int[][] dist = floyd(n, fares);

            for (int mid = 1 ; mid <= n ; mid ++) {
                answer = Math.min(answer, dist[s][mid] + dist[mid][a] + dist[mid][b]);
            }

            return answer;
        }

        public int[][] floyd(int n, int[][] fares) {
            int[][] dist = new int[n + 1][n + 1];
            for (int i = 1 ; i <= n ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = maxValue;
                    }
                }
            }

            for (int i = 0 ; i < fares.length ; i ++) {
                dist[fares[i][0]][fares[i][1]] = fares[i][2];
                dist[fares[i][1]][fares[i][0]] = fares[i][2];
            }

            for (int i = 1 ; i <= n ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (i == j) continue;
                    for (int k = 1 ; k <= n ; k ++) {
                        if (i == k || j == k) continue;

                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }

            return dist;
        }
    }
}
