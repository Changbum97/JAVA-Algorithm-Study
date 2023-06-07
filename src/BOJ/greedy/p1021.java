package BOJ.greedy;

import java.util.Scanner;

public class p1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 큐의 크기 (1~50)
        int m = sc.nextInt();   // 뽑으려는 수의 개수

        int[] arr = new int[5000];
        for (int i = 1 ; i <= n ; i ++) {
            arr[2500 + i] = i;
        }

        int answer = 0;
        int start = 2501;
        int end = 2500 + n;
        for (int i = 1 ; i <= m ; i ++) {
            int target = sc.nextInt();
            int targetIdx = start;

            for (int j = start ; j <= end ; j ++) {
                if (arr[j] == target) {
                    targetIdx = j;
                    break;
                }
            }

            if (targetIdx - start <= end - targetIdx + 1) {
                // 앞에 수들을 뒤로 보내고 추출한 경우
                answer += (targetIdx - start);
                while(start < targetIdx) {
                    arr[++ end] = arr[start ++];
                }
                start ++;
            } else {
                // 뒤에 수들을 앞으로 보내고 추출한 경우
                answer += (end - targetIdx + 1);
                while(end > targetIdx) {
                    arr[-- start] = arr[end --];
                }
                end --;
            }
        }

        System.out.println(answer);
    }
}
