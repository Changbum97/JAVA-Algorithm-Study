package BOJ.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _p1717 {
    static int[] rep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rep = new int[n + 2];
        for(int i = 0 ; i <= n ; i ++) {
            rep[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aRep = getRep(a);
            int bRep = getRep(b);

            // 합집합 연산
            if(op == 0) {
                rep[aRep] = bRep;
            }
            // 두 원소가 같은 집합인지 판단
            else {
                if(aRep == bRep) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    // 대표값 구하기
    static int getRep(int index) {
        if(rep[index] == index) {
            return index;
        } else {
            rep[index] = getRep(rep[index]);
            return rep[index];
        }
    }
}
