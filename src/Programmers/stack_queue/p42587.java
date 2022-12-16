package Programmers.stack_queue;

import java.util.*;

public class p42587 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int n = priorities.length;
            Queue<Doc> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
                return o2 - o1;
            });

            for(int i = 0 ; i < n ; i ++) {
                queue.add(new Doc(i, priorities[i]));
                pq.add(priorities[i]);
            }

            int answer = 0;

            while(!queue.isEmpty()) {
                Doc doc = queue.poll();
                if(doc.priority == pq.peek()) {
                    pq.poll();
                    answer ++;
                    if(doc.idx == location) {
                        return answer;
                    }
                } else {
                    queue.add(doc);
                }
            }

            return answer;
        }

        class Doc{
            int idx, priority;
            Doc(int idx, int priority) {
                this.idx = idx;
                this.priority = priority;
            }
        }
    }
}
