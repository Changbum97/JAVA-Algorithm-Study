package Programmers.bfs_dfs;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 * BFS Level3 예제
 */

import java.util.*;

public class Bfs_Level3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8) == 17);
        System.out.println(s.solution(new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, 9, 7, 6, 1) == 11);
        System.out.println(s.solution(new int[][]{{1,1,5,7}}, 1, 1, 4, 7) == 9);
        System.out.println(s.solution(new int[][]{{2,1,7,5},{6,4,10,10}}, 3, 1, 7, 10) == 15);
        System.out.println(s.solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}}, 1, 4, 6, 3) == 10);
    }

    static class Solution {

        static int[][] arr;

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = 0;
            arr = new int[102][102];

            for (int i = 0 ; i < rectangle.length ; i ++) {
                draw(rectangle[i][0], rectangle[i][1], rectangle[i][2], rectangle[i][3]);
            }

            check();
            answer = start(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

            return answer;
        }

        private int start(int characterX, int characterY, int itemX, int itemY) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(characterX, characterY, 0));

            int[] row = new int[]{0, 0, 1, -1};
            int[] col = new int[]{1, -1, 0, 0};

            while(!queue.isEmpty()) {
                Point p = queue.poll();

                if (p.x == itemX && p.y == itemY) {
                    return p.step / 2;
                }

                for(int i = 0 ; i < 4 ; i ++) {
                    int newX = p.x + row[i];
                    int newY = p.y + col[i];

                    if (newX < 1 || newX > 101 || newY < 1 || newY > 101) continue;
                    if (arr[newX][newY] != 3) continue;

                    arr[newX][newY] = 4;
                    queue.add(new Point(newX, newY, p.step + 1));
                }
            }

            return -1;
        }

        private void draw(int x1, int y1, int x2, int y2) {
            x1 *= 2;
            y1 *= 2;
            x2 *= 2;
            y2 *= 2;

            for (int x = x1 ; x <= x2 ; x ++) {
                arr[x][y1] = 1;
                arr[x][y2] = 1;
            }

            for (int y = y1 ; y <= y2 ; y ++) {
                arr[x1][y] = 1;
                arr[x2][y] = 1;
            }
        }

        private void check() {
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(1, 1, 0));

            int[] row = new int[]{0, 0, 1, -1};
            int[] col = new int[]{1, -1, 0, 0};

            while(!queue.isEmpty()) {
                Point p = queue.poll();

                for(int i = 0 ; i < 4 ; i ++) {
                    int newX = p.x + row[i];
                    int newY = p.y + col[i];

                    if (newX < 1 || newX > 101 || newY < 1 || newY > 101) continue;
                    if (arr[newX][newY] != 0) continue;

                    arr[newX][newY] = 2;
                    queue.add(new Point(newX, newY, 0));
                }
            }

            for (int i = 1 ; i <= 100 ; i ++) {
                for (int j = 1 ; j <= 100 ; j ++) {
                    if (arr[i][j] == 1) {
                        if (arr[i + 1][j] == 2 || arr[i - 1][j] == 2 || arr[i][j + 1] == 2 || arr[i][j - 1] == 2) {
                            arr[i][j] = 3;
                        }
                    }
                }
            }

            for (int i = 1 ; i <= 100 ; i ++) {
                for (int j = 1 ; j <= 100 ; j ++) {
                    if (arr[i][j] == 1) {
                        int cnt = 0;
                        if (arr[i + 1][j] == 3) cnt ++;
                        if (arr[i - 1][j] == 3) cnt ++;
                        if (arr[i][j + 1] == 3) cnt ++;
                        if (arr[i][j - 1] == 3) cnt ++;

                        if (cnt == 2) {
                            arr[i][j] = 3;
                        }
                    }
                }
            }
        }

        private class Point {
            int x, y, step;

            Point(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }
    }
}
