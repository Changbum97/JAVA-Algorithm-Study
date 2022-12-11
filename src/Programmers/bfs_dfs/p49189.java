package Programmers.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p49189 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;

            ArrayList<Integer>[] connection = new ArrayList[n + 1];
            for(int i = 1 ; i <= n ; i ++) {
                connection[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < edge.length ; i ++) {
                int x = edge[i][0];
                int y = edge[i][1];
                connection[x].add(y);
                connection[y].add(x);
            }

            int[] check = new int[n + 1];
            int max = -100;
            Arrays.fill(check, -1);
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 0));
            check[1] = 0;

            while(!queue.isEmpty()) {
                Node node = queue.poll();
                for(int num : connection[node.next]) {
                    if(check[num] == -1) {
                        queue.add(new Node(num, node.cost + 1));
                        check[num] = node.cost + 1;
                        if(max < check[num]) {
                            max = check[num];
                        }
                    }
                }
            }

            for(int i = 1 ; i <= n ; i ++) {
                if(check[i] == max) {
                    answer ++;
                }
            }

            return answer;
        }
        class Node {
            int next, cost;
            Node(int next, int cost) {
                this.next = next;
                this.cost = cost;
            }
        }
    }
}
