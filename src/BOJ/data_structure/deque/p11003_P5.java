package BOJ.data_structure.deque;

/**
 * 최솟값 찾기
 * 플래티넘 5
 * https://www.acmicpc.net/problem/11003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p11003_P5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<NI> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        deque.addLast(new NI(Integer.parseInt(st.nextToken()), 0));
        sb.append(deque.getFirst().num).append(" ");
        for (int i = 1 ; i < n ; i ++) {
            int x = Integer.parseInt(st.nextToken());
            if (x <= deque.getFirst().num) {
                deque.clear();
                deque.addLast(new NI(x, i));
            } else {
                while (deque.getLast().num >= x) {
                    deque.removeLast();
                }
                deque.addLast(new NI(x, i));

                while (deque.getFirst().idx <= i - l) {
                    deque.removeFirst();
                }
            }
            sb.append(deque.getFirst().num).append(" ");
        }
        System.out.println(sb);
    }

    private static class NI {
        int num, idx;

        NI (int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
