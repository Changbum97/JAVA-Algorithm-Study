// https://www.acmicpc.net/problem/1717

package Basic;

import java.util.Scanner;

public class UnionFind {

    static int[] rep;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 집합 수
        int m = sc.nextInt();   // 입력 수

        rep = new int[n + 1];     // rep[i] = i가 속해있는 그룹의 대표

        for (int i = 1 ; i <= n ; i ++) {
            rep[i] = i;
        }

        for (int i = 0 ; i < m ; i ++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int xRep = getRep(x);
            int yRep = getRep(y);

            // 두 집합을 더함
            if (op == 0) {
                rep[xRep] = yRep;
            }
            // 두 집합이 같은 집합인지 여부 출력
            else if (op == 1) {
                if (xRep == yRep) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static int getRep(int x) {
        if (x == rep[x]) {
            return x;
        } else {
            // x의 대표를 구하되, 구한 대표로 갱신까지
            rep[x] = getRep(rep[x]);
            return rep[x];
        }
    }
}
