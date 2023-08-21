package BOJ.segmentTree;

/**
 * 구간 합 구하기
 * 골드 1
 * https://www.acmicpc.net/problem/2042
 */

import java.util.Scanner;

public class p2042 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt() + sc.nextInt();

        long[] input = new long[n];
        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextLong();
        }

        int start = 1;
        while (true) {
            if (n > start) {
                start *= 2;
            } else {
                break;
            }
        }

        long[] tsp = new long[start * 2];
        for (int i = 0 ; i < n ; i ++) {
            tsp[start + i] = input[i];
        }
        for (int i = start - 1 ; i >= 1 ; i --) {
            tsp[i] = tsp[i * 2] + tsp[i * 2 + 1];
        }

        for (int i = 0 ; i < m ; i ++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            long y = sc.nextLong();

            if (op == 1) {  // x번째 수를 y로 교체
                int idx = start + x - 1;
                long diff = y - tsp[idx];
                while(idx > 0) {
                    tsp[idx] += diff;
                    idx /= 2;
                }
            } else {    // x번째 수부터 y번째 수까지의 합
                long sum = 0;
                int left = start + x - 1;
                int right = (int)(start + y - 1);

                while (left <= right) {
                    if (left % 2 == 1) {    // left는 오른쪽 노드일때만 더해줌
                        sum += tsp[left];
                    }
                    left = (left + 1) / 2;

                    if (right % 2 == 0) {   // right는 왼쪽 노드일때만 더해줌
                        sum += tsp[right];
                    }
                    right = (right - 1) / 2;
                }
                System.out.println(sum);
            }
        }
    }
}
