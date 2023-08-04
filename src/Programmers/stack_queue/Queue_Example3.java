package Programmers.stack_queue;

/**
 * 다리를 지나는 트럭
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * Queue(FIFO)를 사용한 예제
 */

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Example3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 10, new int[]{7,4,5,6}) == 8);
        System.out.println(s.solution(100, 100, new int[]{10}) == 101);
        System.out.println(s.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}) == 110);
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 1;
            int idx = 1;
            int truckSum = 0;

            Queue<WT> queue = new LinkedList<>();
            queue.add(new WT(truck_weights[0], 1));
            truckSum = truck_weights[0];

            while(!queue.isEmpty()) {
                WT wt = queue.peek();

                if (answer == wt.time + bridge_length) {
                    queue.poll();
                    truckSum -= wt.weight;
                }

                if (answer != 1 && idx < truck_weights.length && truckSum + truck_weights[idx] <= weight) {
                    truckSum += truck_weights[idx];
                    queue.add( new WT(truck_weights[idx], answer) );
                    idx ++;
                }

                answer ++;
            }

            return answer - 1;
        }

        // Weight And Time
        class WT {
            int weight, time;

            WT (int weight, int time) {
                this.weight = weight;
                this.time = time;
            }
        }
    }
}
