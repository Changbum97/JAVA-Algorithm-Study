package BOJ.data_structure.priorityQueue;

/**
 * 나는 기말고사형 인간이야
 * 골드 5
 * https://www.acmicpc.net/problem/23254
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class p23254_G5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt() * 24;
        int n = sc.nextInt();

        int[] temp = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            temp[i] = sc.nextInt();
        }

        PriorityQueue<SE> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i ++) {
            pq.add(new SE(temp[i], sc.nextInt()));
        }

        for (int i = 0 ; i < hour ; i ++) {
            SE se = pq.poll();
            pq.add(new SE(Math.min(100, se.score + se.eff), se.eff));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll().score;
        }
        System.out.println(answer);
    }

    private static class SE implements Comparable<SE>{
        int score, eff;

        SE (int score, int eff) {
            this.score = score;
            this.eff = eff;
        }

        public int compareTo(SE se) {
            // eff 기준으로 내림차순 정렬
            // 단, 현재 스코어 + 한 시간 효과가 100이 넘으면 eff가 아닌 100 - score로 계산
            return Math.min(se.eff, 100 - se.score) - Math.min(this.eff, 100 - this.score);
        }
    }
}
