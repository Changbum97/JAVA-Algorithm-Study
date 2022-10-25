package BOJ.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p12920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Thing> things = new ArrayList<>();
        things.add(new Thing(0, 0));        // index를 1부터 하기 위해 null값 하나 추가
        for(int i = 0 ; i < n ; i ++ ) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());   // 물건의 무게
            int c = Integer.parseInt(st.nextToken());   // 물건의 가치
            int k = Integer.parseInt(st.nextToken());   // 물건의 개수

            int tempK = 1;
            while(tempK <= k) {
                things.add(new Thing(tempK * v, tempK * c));
                k -= tempK;
                tempK *= 2;
            }
            if(k != 0) {
                things.add(new Thing(k * v, k * c));
            }
        }

        int[][] dp = new int[things.size() + 1][m + 1];
        for(int i = 1 ; i < things.size() ; i ++) {
            for(int j = 1 ; j <= m ; j ++) {
                if(j < things.get(i).weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things.get(i).weight] + things.get(i).value);
                }
            }
        }

        System.out.println(dp[things.size() - 1][m]);
    }

    static class Thing {
        int weight, value;

        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
