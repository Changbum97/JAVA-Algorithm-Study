package Programmers.PCCP;

import java.util.*;

public class p2_4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 4, new int[][]{{2, 3}, {3, 3}}));
        System.out.println(s.solution(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}}));
        System.out.println(s.solution(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}}));
    }
    static class Solution {
        public int solution(int n, int m, int[][] hole) {
            int answer = 0;

            // 빈칸:0, hole:1, 시작점,끝점:2
            int[][] arr = new int[n + 1][m + 1];
            for(int i = 0 ; i < hole.length ; i ++) {
                arr[hole[i][0]][hole[i][1]] = 1;
            }
            arr[1][1] = 2;
            arr[n][m] = 2;

            int[][] fromStart = new int[n + 1][m + 1];
            int[][] fromEnd = new int[n + 1][m + 1];
            int tempMax = 1111111;

            for(int i = 1 ; i <= n ; i ++) {
                for(int j = 1 ; j <= m ; j ++) {
                    fromStart[i][j] = tempMax;
                    fromEnd[i][j] = tempMax;
                }
            }
            fromStart[1][1] = 0;
            fromEnd[n][m] = 0;

            int[] row = new int[]{1, -1, 0, 0};
            int[] col = new int[]{0, 0, 1, -1};

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 1));
            while(!queue.isEmpty()) {
                Node node = queue.poll();

                for(int i = 0 ; i < 4 ; i ++) {
                    int nextX = node.x + row[i];
                    int nextY = node.y + col[i];

                    if(nextX <= 0 || nextX > n) continue;
                    if(nextY <= 0 || nextY > m) continue;
                    if(arr[nextX][nextY] == 1) continue;

                    if(fromStart[nextX][nextY] <= fromStart[node.x][node.y] + 1) continue;

                    fromStart[nextX][nextY] = fromStart[node.x][node.y] + 1;
                    queue.add(new Node(nextX, nextY));
                }
            }

            queue = new LinkedList<>();
            queue.add(new Node(n, m));
            while(!queue.isEmpty()) {
                Node node = queue.poll();

                for(int i = 0 ; i < 4 ; i ++) {
                    int nextX = node.x + row[i];
                    int nextY = node.y + col[i];

                    if(nextX <= 0 || nextX > n) continue;
                    if(nextY <= 0 || nextY > m) continue;
                    if(arr[nextX][nextY] == 1) continue;

                    if(fromEnd[nextX][nextY] <= fromEnd[node.x][node.y] + 1) continue;

                    fromEnd[nextX][nextY] = fromEnd[node.x][node.y] + 1;
                    queue.add(new Node(nextX, nextY));
                }
            }

            answer = fromStart[n][m];

            for(int i = 1 ; i <= n ; i ++) {
                for(int j = 1 ; j <= m ; j ++) {
                    for(int l = 0 ; l < 4 ; l ++) {
                        int jumpI = i + (row[l] * 2);
                        int jumpJ = j + (col[l] * 2);

                        if(jumpI <= 0 || jumpI > n) continue;
                        if(jumpJ <= 0 || jumpJ > m) continue;

                        if(answer > fromStart[i][j] + fromEnd[jumpI][jumpJ] + 1) {
                            answer = fromStart[i][j] + fromEnd[jumpI][jumpJ] + 1;
                        }
                    }
                }
            }

            if(answer == tempMax) {
                return -1;
            }
            return answer;
        }

        class Node {
            int x, y;
            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
