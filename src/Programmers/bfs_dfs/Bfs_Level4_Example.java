package Programmers.bfs_dfs;

/**
 * 퍼즐 조각 채우기
 * https://school.programmers.co.kr/learn/courses/30/lessons/84021
 * BFS Level4 예제
 */

import java.util.*;

public class Bfs_Level4_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(
                new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
                new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}) == 14);
        System.out.println(s.solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}}, new int[][]{{1,1,1},{1,0,0},{0,0,0}}) == 0);
    }

    static class Solution {

        static int[][] sgb;
        static int[][] st;
        static int n;

        public int solution(int[][] game_board, int[][] table) {
            int answer = 0;
            n = game_board.length;

            sgb = new int[n][n];
            st = new int[n][n];

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    // 비어있는칸 = 1, 채워진칸 = 0으로 수정
                    sgb[i][j] = 1 - game_board[i][j];
                    st[i][j] = table[i][j];
                }
            }

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (sgb[i][j] == 1) {
                        sgb = change(sgb, i, j);
                    }
                    if (st[i][j] == 1) {
                        st = change(st, i, j);
                    }
                }
            }

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (sgb[i][j] != 0) {
                        int temp = sgb[i][j];
                        if (checkSuccess(i, j)) {
                            answer += temp;
                        } else {
                            sgb = fillAround(sgb, i, j, 0);
                        }
                    }
                }
            }

            return answer;
        }

        public static boolean checkSuccess(int x, int y) {
            boolean success = false;
            int block = sgb[x][y];

            int[][] tempSt = new int[n][n];

            for (int turn = 0 ; turn < 4 ; turn ++) {
                for (int i = 0 ; i < n ; i ++) {
                    for (int j = 0 ; j < n ; j ++) {
                        tempSt[i][j] = st[i][j];
                    }
                }
                for (int i = 0 ; i < n ; i ++) {
                    for (int j = 0 ; j < n ; j ++) {
                        if (tempSt[i][j] == block) {
                            boolean bfsSuccess = bfs(tempSt, x, y, i, j);
                            if (bfsSuccess) {
                                sgb = fillAround(sgb, x, y, 0);
                                st = fillAround(st, i, j, 0);
                                return true;
                            } else {
                                tempSt = fillAround(tempSt, i, j, 0);
                            }
                        }
                    }
                }
                st = rotateSt();
            }

            return false;
        }

        public static int[][] rotateSt() {
            int[][] result = new int[n][n];

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    result[i][j] = st[n - 1 - j][i];
                }
            }

            return result;
        }

        public static int[][] fillAround(int[][] arr, int x, int y, int target) {
            int original = arr[x][y];

            Queue<Idx> queue = new LinkedList<>();
            queue.add(new Idx(x, y));
            arr[x][y] = target;

            int[] row = new int[]{1, -1, 0, 0};
            int[] col = new int[]{0, 0, 1, -1};

            while(!queue.isEmpty()) {
                Idx idx = queue.poll();
                for (int i = 0 ; i < 4 ; i ++) {
                    int newX = idx.x + row[i];
                    int newY = idx.y + col[i];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                    if (arr[newX][newY] == original) {
                        arr[newX][newY] = target;
                        queue.add(new Idx(newX, newY));
                    }
                }
            }

            return arr;
        }

        public static boolean bfs(int[][] temp, int x1, int y1, int x2, int y2) {
            Queue<Idx> queue = new LinkedList<>();
            queue.add(new Idx(x1, y1));

            boolean[][] check = new boolean[n][n];
            check[x1][y1] = true;

            int[] row = new int[]{1, -1, 0, 0};
            int[] col = new int[]{0, 0, 1, -1};

            while(!queue.isEmpty()) {
                Idx idx = queue.poll();
                for (int i = 0 ; i < 4 ; i ++) {
                    int newX = idx.x + row[i];
                    int newY = idx.y + col[i];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                    if (check[newX][newY] == true) continue;

                    if (sgb[newX][newY] != 0) {
                        int tempX = x2 + (newX - x1);
                        int tempY = y2 + (newY - y1);
                        if (tempX < 0 || tempX >= n || tempY < 0 || tempY >= n || temp[tempX][tempY] == 0) {
                            return false;
                        } else {
                            queue.add(new Idx(newX, newY));
                            check[newX][newY] = true;
                        }
                    }
                }
            }
            return true;
        }

        public static int[][] change(int[][] arr, int x, int y) {
            List<Idx> idxList = new ArrayList<>();
            idxList.add(new Idx(x, y));

            Queue<Idx> queue = new LinkedList<>();
            queue.add(new Idx(x, y));

            int cnt = 1;
            boolean[][] check = new boolean[n][n];
            check[x][y] = true;

            int[] row = new int[]{1, -1, 0, 0};
            int[] col = new int[]{0, 0, 1, -1};

            while(!queue.isEmpty()) {
                Idx idx = queue.poll();
                for (int i = 0 ; i < 4 ; i ++) {
                    int newX = idx.x + row[i];
                    int newY = idx.y + col[i];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                    if (check[newX][newY] == true) continue;

                    if (arr[newX][newY] == 1) {
                        queue.add(new Idx(newX, newY));
                        idxList.add(new Idx(newX, newY));
                        check[newX][newY] = true;
                        cnt ++;
                    }
                }
            }

            for (Idx idx : idxList) {
                arr[idx.x][idx.y] = cnt;
            }

            return arr;
        }

        static class Idx {
            int x, y;

            Idx(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
