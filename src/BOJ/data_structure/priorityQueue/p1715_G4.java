package BOJ.data_structure.priorityQueue;

/**
 * 카드 정렬하기
 * 골드 4
 * https://www.acmicpc.net/problem/1715
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class p1715_G4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i ++) {
            pq.add(sc.nextInt());
        }

        int answer = 0;
        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            answer += x + y;
            pq.add(x + y);
        }

        System.out.println(answer);
    }
}
