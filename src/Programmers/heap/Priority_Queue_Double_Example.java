package Programmers.heap;

/**
 * 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * Priority Queue를 2개 사용한 예제
 */

import java.util.*;

public class Priority_Queue_Double_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}) == 9);
        System.out.println(s.solution(new int[][]{{0, 3}, {10, 1}}) == 2);
    }

    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;

            PriorityQueue<SW> pq = new PriorityQueue<>();
            for (int[] job : jobs) {
                pq.add(new SW(job[0], job[1]));
            }

            PriorityQueue<SW2> pq2 = new PriorityQueue<>();
            int nowTime = 0;

            while(!pq.isEmpty() || !pq2.isEmpty()) {
                // pq에서 nowTime 이전에 시작한 작업을 pq2로 이동
                while(!pq.isEmpty() && pq.peek().start <= nowTime) {
                    pq2.add(new SW2(pq.peek().start, pq.poll().workTime));
                }

                SW now;
                // pq2가 비어있다면 바로 다음에 시작되는 일 시작
                // 바로 다음에 시작되는 일이 여러개라면 workTime이 작은 일부터 시작
                if (pq2.isEmpty()) {
                    now = pq.poll();
                    while (!pq.isEmpty() && pq.peek().start == now.start) {
                        if (pq.peek().workTime < now.workTime) {
                            pq2.add(new SW2(now.start, now.workTime));
                            now = pq.poll();
                        } else {
                            pq2.add(new SW2(pq.peek().start, pq.poll().workTime));
                        }
                    }
                } else {
                    now = new SW(pq2.peek().start, pq2.poll().workTime);
                }

                if (nowTime < now.start) {
                    nowTime = now.start + now.workTime;
                } else {
                    nowTime += now.workTime;
                }
                answer += nowTime - now.start;

            }

            return answer / jobs.length;
        }

        // Start And Work time, start를 기준으로 오름차순 정렬
        class SW implements Comparable<SW> {
            int start, workTime;

            SW (int start, int workTime) {
                this.start = start;
                this.workTime = workTime;
            }

            // start를 기준으로 오름차순 정렬
            public int compareTo(SW sw) {
                return this.start - sw.start;
            }
        }

        // Start And Work time, workTime을 기준으로 오름차순 정렬
        class SW2 implements Comparable<SW2> {
            int start, workTime;

            SW2 (int start, int workTime) {
                this.start = start;
                this.workTime = workTime;
            }

            // workTime을 기준으로 오름차순 정렬
            // workTime이 같다면 start를 기준으로 내림차순 정렬
            public int compareTo(SW2 sw) {
                if (this.workTime == sw.workTime) {
                    return sw.start - this.start;
                }
                return this.workTime - sw.workTime;
            }
        }
    }
}
