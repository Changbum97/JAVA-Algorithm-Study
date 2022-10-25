package dfs_bfs.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class p2188 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 소들이 원하는 축사 리스트
        ArrayList<Integer>[] wantList = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            wantList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= n ; i ++) {
            int cnt = sc.nextInt();
            for(int j = 0 ; j < cnt ; j ++) {
                wantList[i].add(sc.nextInt());
            }
        }

        int[] home = new int[m + 1];    // 축사 (들어가는 값은 소 번호)
        for(int i = 1 ; i <= n ; i ++) {

            // i 번째 소가 원하는 축사에 바로 배정 받았는지 체크
            boolean assigned = false;

            // i 번째 소가 원하는 축사중에 들어갈 수 있는 곳이 있다면 바로 들어가게 함
            for(int wantHome : wantList[i]) {
                if(home[wantHome] == 0) {
                    home[wantHome] = i;
                    assigned = true;
                    break;
                }
            }
            if(assigned) continue;

            // i 번째 소가 원하는 축사에 바로 배정받지
        }
    }
}
