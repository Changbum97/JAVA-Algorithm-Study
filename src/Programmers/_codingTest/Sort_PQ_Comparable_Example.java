package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121686
// Sort + Comparable, Priority Queue + Comparable 사용 예제

import java.util.*;

public class Sort_PQ_Comparable_Example {

    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}});
        s.solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0 ,5}, {5, 0, 5}});
    }

    static class Solution {
        public long[] solution(int[][] program) {
            int size = program.length;
            long[] answer = new long[11];
            PriorityQueue<Solution.Program> pq = new PriorityQueue<>();
            Arrays.sort(program, (o1, o2) -> {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });

            long nowTime = 0;
            int index = 0;
            int cnt = 0;

            while(cnt < size) {
                while(index < size && program[index][1] <= nowTime) {
                    pq.add(new Solution.Program(program[index][0], program[index][1], program[index][2]));
                    index ++;
                }
                if(pq.isEmpty()) {
                    nowTime = program[index][1];
                } else {
                    Solution.Program next = pq.poll();
                    answer[next.priority] += (long)(nowTime - next.start);
                    nowTime += next.runningTime;
                    cnt ++;
                }
            }

            answer[0] = nowTime;
            return answer;
        }

        class Program implements Comparable<Program>{
            int priority, start, runningTime;

            public Program(int priority, int start, int runningTime) {
                this.priority = priority;
                this.start = start;
                this.runningTime = runningTime;
            }

            @Override
            public int compareTo(Solution.Program p) {
                if(p.priority == this.priority) {
                    return this.start - p.start;
                }
                return this.priority - p.priority;
            }
        }
    }

}
