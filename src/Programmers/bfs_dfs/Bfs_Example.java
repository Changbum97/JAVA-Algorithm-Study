package Programmers.bfs_dfs;

/**
 * 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * BFS를 사용한 예제
 */

import java.util.*;

public class Bfs_Example {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}) == 3);
        System.out.println(s.solution(4, new int[][]{{1,2},{2,3},{3,4}}) == 0);
        System.out.println(s.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}) == 1);
    }

    static class Solution {

        static List<Integer>[] connections;

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            connections = new ArrayList[n + 1];
            for (int i = 1 ; i <= n ; i ++) {
                connections[i] = new ArrayList<>();
            }

            for (int[] wire : wires) {
                connections[wire[0]].add(wire[1]);
                connections[wire[1]].add(wire[0]);
            }

            for (int[] wire : wires) {
                int result = bfs(n, wire);
                answer = Math.min(answer, Math.abs(result - (n - result)));
            }

            return answer;
        }

        static int bfs(int n, int[] wire) {
            boolean[] check = new boolean[n + 1];
            Arrays.fill(check, false);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(wire[0]);
            check[wire[0]] = true;

            int result = 1;
            connections[wire[0]].remove(new Integer(wire[1]));
            connections[wire[1]].remove(new Integer(wire[0]));

            while(!queue.isEmpty()) {
                int now = queue.poll();

                for (int i : connections[now]) {
                    if (check[i] == false) {
                        check[i] = true;
                        result ++;
                        queue.add(i);
                    }
                }
            }

            connections[wire[0]].add(new Integer(wire[1]));
            connections[wire[1]].add(new Integer(wire[0]));


            return result;
        }
    }
}
