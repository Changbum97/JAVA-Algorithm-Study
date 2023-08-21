package BOJ.data_structure.segmentTree;

/**
 * 최솟값
 * 골드 1
 * https://www.acmicpc.net/problem/10868
 */

import java.util.Arrays;
import java.util.Scanner;

public class p10868_G1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            input[i] = sc.nextInt();
        }

        int start = 1;
        while(start <= n) {
            start *= 2;
        }

        int[] tree = new int[start * 2];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0 ; i < n ; i ++) {
            tree[start + i] = input[i];
        }
        for (int i = start - 1 ; i >= 1 ; i --) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0 ; i < m ; i ++) {
            int x = sc.nextInt() + start - 1;
            int y = sc.nextInt() + start - 1;
            int answer = Integer.MAX_VALUE;

            while (x <= y) {
                if (x % 2 == 1) {   // x는 오른쪽 노드일 때만 고려
                    answer = Math.min(answer, tree[x]);
                }
                x = (x + 1) / 2;

                if (y % 2 == 0) {   // y는 왼쪽 노드일 때만 고려
                    answer = Math.min(answer, tree[y]);
                }
                y = (y - 1) / 2;
            }
            System.out.println(answer);
        }
    }


}
