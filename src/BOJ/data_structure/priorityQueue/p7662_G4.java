package BOJ.data_structure.priorityQueue;

/**
 * 이중 우선순위 큐
 * 골드 4
 * https://www.acmicpc.net/problem/7662
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p7662_G4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0 ; tc < t ; tc ++) {
            int n = sc.nextInt();
            int cnt = 0;

            PriorityQueue<MinClass> minHeap = new PriorityQueue<>();
            PriorityQueue<MaxClass> maxHeap = new PriorityQueue<>();

            boolean[] deleted = new boolean[n];
            Arrays.fill(deleted, true);

            for (int i = 0 ; i < n ; i ++) {
                String op = sc.next();
                long num = sc.nextLong();

                if (op.equals("I")) {   // 값 삽입
                    maxHeap.add(new MaxClass(num, i));
                    minHeap.add(new MinClass(num, i));
                    deleted[i] = false;
                    cnt ++;
                } else if (cnt > 0) {
                    if (num == 1) {     // 최댓값 삭제
                        while (true) {
                            MaxClass mc = maxHeap.poll();
                            if (!deleted[mc.idx]) {
                                cnt --;
                                deleted[mc.idx] = true;
                                break;
                            }
                        }
                    } else {        // 최솟값 삭제
                        while (true) {
                            MinClass mc = minHeap.poll();
                            if (!deleted[mc.idx]) {
                                cnt --;
                                deleted[mc.idx] = true;
                                break;
                            }
                        }
                    }
                }

                if (cnt == 0) {
                    maxHeap.clear();
                    minHeap.clear();
                }
            }

            if (cnt == 0) {
                System.out.println("EMPTY");
            } else {
                while (true) {
                    MaxClass mc = maxHeap.poll();
                    if (!deleted[mc.idx]) {
                        System.out.print(mc.num + " ");
                        break;
                    }
                }
                while (true) {
                    MinClass mc = minHeap.poll();
                    if (!deleted[mc.idx]) {
                        System.out.println(mc.num);
                        break;
                    }
                }
            }
        }
    }

    private static class MaxClass implements Comparable<MaxClass> {
        long num;
        int idx;
        MaxClass (long num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(MaxClass mc) {
            if (mc.num > this.num) {
                return 1;
            }
            return -1;
        }
    }

    private static class MinClass implements Comparable<MinClass> {
        long num;
        int idx;
        MinClass (long num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(MinClass mc) {
            if (this.num > mc.num) {
                return 1;
            }
            return -1;
        }
    }
}
