package Programmers.stack_queue;

/**
 * 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Queue(FIFO)를 사용한 예제
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue_Example2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{2, 1, 3, 2}, 2) == 1);
        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0) == 5);
    }

    static class Solution {

        static int[] priorityCnt;

        public int solution(int[] priorities, int location) {

            Queue<PI> queue = new LinkedList<>();
            priorityCnt = new int[10];

            for (int i = 0 ; i < priorities.length ; i ++) {
                queue.add(new PI(priorities[i], i));
                priorityCnt[priorities[i]] ++;
            }

            int nowPriority = getNowPriority(10);
            int answer = 1;
            while(!queue.isEmpty()) {
                PI pi = queue.poll();
                if (pi.priority != nowPriority) {
                    queue.add(pi);
                } else {
                    if (pi.index == location) {
                        return answer;
                    } else {
                        answer ++;
                        priorityCnt[nowPriority] --;

                        if (priorityCnt[nowPriority] == 0) {
                            nowPriority = getNowPriority(nowPriority);
                        }
                    }
                }
            }

            return answer;
        }

        int getNowPriority(int x) {
            for(int i = x - 1 ; i >= 1 ; i --) {
                if(priorityCnt[i] != 0) {
                    return i;
                }
            }
            return 1;
        }

        // Priority And Index
        class PI {
            int priority, index;

            PI (int priority, int index) {
                this.priority = priority;
                this.index = index;
            }
        }
    }
}
