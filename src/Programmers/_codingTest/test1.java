package Programmers._codingTest;

import java.util.*;

public class test2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3));
        System.out.println(s.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 1, 2));
    }

    static class Solution {
        public int solution(int[][] relationships, int target, int limit) {

            ArrayList<Integer>[] connections = new ArrayList[105];
            int n = 0;
            for (int i = 1 ; i < 105 ; i ++) {
                connections[i] = new ArrayList<>();
            }
            for (int i = 0 ; i < relationships.length ; i ++) {
                int x = relationships[i][0];
                int y = relationships[i][1];
                n = Math.max(n, x);
                n = Math.max(n, y);

                connections[x].add(y);
                connections[y].add(x);
            }
            for (int i = 1 ; i <= n ; i ++) {
                Collections.sort(connections[i]);
            }

            int answer = 0;
            boolean[] check = new boolean[n + 1];
            Arrays.fill(check, false);

            Queue<Node> queue = new LinkedList<>();
            check[target] = true;
            queue.add(new Node(target, 0));

            while(!queue.isEmpty()) {
                Node now = queue.poll();
                for (int next : connections[now.idx]) {
                    if (check[next] == false) {
                        check[next] = true;
                        queue.add(new Node(next, now.step + 1));

                        if (now.step == 0) {
                            answer += 5;
                        } else if (now.step <= limit - 1){
                            answer += 11;
                        } else {
                            return answer;
                        }
                    }
                }
            }

            return answer;
        }
        static class Node {
            int idx, step;
            Node(int idx, int step) {
                this.idx = idx;
                this.step = step;
            }
        }
    }
}
