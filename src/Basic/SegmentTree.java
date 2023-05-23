// https://www.acmicpc.net/problem/2042

package Basic;

import java.util.Scanner;

public class SegmentTree {

    static long[] tree;
    static int startIdx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 수의 개수
        int m = sc.nextInt() + sc.nextInt();    // 계산 횟수

        // 트리 깊이 구하기 => n개의 수가 트리 가장 하단에 들어갈 예정  (Ex n=5 => depth=3)
        int depth = getDepth(n);
        // n=5 => depth=3 => startIndex=8 => tree[8]에 0번째 수가 들어갈 예정
        startIdx = (int) Math.pow(2, depth);
        tree = new long[startIdx * 2];

        makeTree(n, sc);

        for (int i = 0 ; i < m ; i ++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            long y = sc.nextLong();

            if (op == 1) {
                // op가 1인 경우 (x - 1)번째 수를 y로 교체
                // 문제에선 1부터 시작, Tree Index는 0부터 시작
                change(x - 1, y);
            } else {
                // op가 2인 경우 (x - 1)번째 수부터 (y - 1)번째 수 까지의 합
                System.out.println(getSum(x - 1, (int) (y - 1)));
            }
        }
    }

    private static void change(int idx, long newNumber) {
        idx += startIdx;
        long diff = newNumber - tree[idx];

        while(idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    private static long getSum(int s, int e) {
        s += startIdx;
        e += startIdx;
        long sum = 0;

        while(s <= e) {
            // s는 right인 경우에만 더함 => left라면 형제 노드까지 더해줘야 하기 때문에 부모 단에서 더해줌
            // s가 right인 경우에는 이미 더했기 때문에 부모로 가지 않고 부모 오른쪽 노드로 이동
            // s가 left인 경우에는 더하지 않았기 때문에 부모 노드로 이동
            if (s % 2 == 1) sum += tree[s];
            s = (s + 1) / 2;

            // e는 left인 경우에만 더함 => right라면 형제 노드까지 더해줘야 하기 때문에 부모 단에서 더해줌
            // e가 left인 경우에는 이미 더했기 때문에 부모 왼쪽 노드로 이동
            // e가 right인 경우에는 더하지 않았기 때문에 부모 노드로 이동
            if (e % 2 == 0) sum += tree[e];
            e = (e - 1) / 2;
        }

        return sum;
    }

    private static void makeTree(int n, Scanner sc) {
        for (int i = 0 ; i < n ; i ++) {
            long x = sc.nextLong();
            tree[startIdx + i] = x;
        }

        // 부모는 자식의 합, Root Node = 1
        for (int i = startIdx - 1 ; i >= 1 ; i --) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static int getDepth(int x) {
        int depth = 0;

        while(true) {
            if (Math.pow(2, depth) >= x) {
                return depth;
            }
            depth ++;
        }
    }
}
