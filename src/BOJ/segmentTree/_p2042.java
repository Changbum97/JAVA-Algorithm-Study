package BOJ.segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _p2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        int depth = 0;
        while(Math.pow(2, depth) < n) {
            depth ++;
        }
        depth ++;
        int arraySize = (int)Math.pow(2, depth);
        int startIndex = (int)Math.pow(2, depth - 1);
        long[] tree = new long[arraySize];

        // 입력값들 트리에 넣기
        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            long in = Long.parseLong(st.nextToken());
            tree[startIndex + i] = in;
        }

        // 초기 트리에 자식들의 합 채우기
        for(int i = startIndex - 1 ; i >= 1 ; i --) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            // x번째 수를 y로 변경
            if(op == 1) {
                int targetIndex = (int) (startIndex + x - 1);
                long diff = y - tree[targetIndex];
                while(targetIndex > 0) {
                    tree[targetIndex] += diff;
                    targetIndex /= 2;
                }
            }
            // x부터 y까지의 합
            else {
                int s = (int)x + startIndex - 1;
                int e = (int)y + startIndex - 1;
                long ans = 0;
                while(s <= e) {
                    if(s % 2 == 1) ans += tree[s];
                    if(e % 2 == 0) ans += tree[e];
                    s = (s + 1) / 2;
                    e = (e - 1) / 2;
                }
                System.out.println(ans);
            }
        }
    }
}
