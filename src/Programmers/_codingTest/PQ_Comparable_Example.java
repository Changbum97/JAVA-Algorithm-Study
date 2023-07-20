package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121686
// Priority Queue + Comparable 사용 예제

import java.util.*;

public class PQ_Comparable_Example {

    public static void main(String[] args) {
        Solution s = new Solution();

        long[] answer1 = s.solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}});
        for (long i : answer1) {
            System.out.print(i + " ");
        }
        System.out.println();

        long[] answer2 = s.solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0 ,5}, {5, 0, 5}});
        for (long i : answer2) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public long[] solution(int[][] program) {
            long[] answer = new long[11];
            PriorityQueue<Program> pq = new PriorityQueue<>();

            for (int i = 0 ; i < program.length ; i ++) {
                pq.add(new Program(program[i][0], program[i][1], program[i][2]));
            }

            long nowTime = 0;
            PriorityQueue<Program2> p2 = new PriorityQueue<>();
            while(!pq.isEmpty()) {
                while(!pq.isEmpty() && pq.peek().callTime <= nowTime) {
                    Program temp = pq.poll();
                    p2.add(new Program2(temp.score, temp.callTime, temp.workTime));
                }

                if (p2.size() == 0) {
                    Program target = pq.poll();
                    nowTime = target.callTime + target.workTime;
                } else {
                    Program2 target = p2.poll();
                    answer[target.score] += nowTime - (long)target.callTime;
                    nowTime += target.workTime;
                }
            }

            while(!p2.isEmpty()) {
                Program2 target = p2.poll();
                answer[target.score] += nowTime - (long)target.callTime;
                nowTime += target.workTime;
            }

            answer[0] = nowTime;
            return answer;
        }

        class Program implements Comparable<Program> {
            int score, callTime, workTime;

            Program (int score, int callTime, int workTime) {
                this.score = score;
                this.callTime = callTime;
                this.workTime = workTime;
            }

            public int compareTo(Program p) {
                if (this.callTime == p.callTime) {
                    return this.score - p.score;
                }
                return this.callTime - p.callTime;
            }
        }

        class Program2 implements Comparable<Program2> {
            int score, callTime, workTime;

            Program2 (int score, int callTime, int workTime) {
                this.score = score;
                this.callTime = callTime;
                this.workTime = workTime;
            }

            public int compareTo(Program2 p) {
                if (this.score == p.score) {
                    return this.callTime - p.callTime;
                }
                return this.score - p.score;
            }
        }
    }
}
