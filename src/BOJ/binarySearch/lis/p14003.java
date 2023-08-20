package BOJ.binarySearch.lis;

/**
 * 가장 긴 증가하는 부분 수열 5
 * https://www.acmicpc.net/problem/14003
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p14003 {

    static List<DI> dp;
    static int[] route;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
        }

        dp = new ArrayList<>();
        dp.add(new DI(-1111111111, -1));
        dp.add(new DI(arr[0], 0));

        route = new int[n];
        route[0] = -1;

        for (int i = 1 ; i < n ; i ++) {
            DI beforeDI = dp.get(dp.size() - 1);
            if (arr[i] > beforeDI.value) {
                dp.add(new DI(arr[i], i));
                route[i] = beforeDI.now;
            } else {
                // dp에서 arr[i]보다 작은값 중 가장 큰 값 바로 뒤의 값을 arr[i]로 수정
                // arr[i]보다 작은값 중 가장 큰 값을 찾기 위해 이분 탐색 사용
                binary_search(arr[i], i);
            }
        }

        int answer = dp.size() -1;
        int[] routeAnswer = new int[answer];
        routeAnswer[answer - 1] = dp.get(answer).now;
        for (int i = answer - 2 ; i >= 0 ; i --) {
            routeAnswer[i] = route[ routeAnswer[i + 1] ];
        }

        System.out.println(answer);
        for (int i = 0 ; i < answer ; i ++) {
            System.out.print(arr[routeAnswer[i]] + " ");
        }
    }

    private static void binary_search(int x, int i) {
        int left = 0;
        int right = dp.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (dp.get(mid).value >= x) {
                right = mid - 1;
            } else {
                if (dp.get(mid).value < x && dp.get(mid + 1).value >= x) {
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        dp.set(mid + 1, new DI(x, i));
        route[i] = dp.get(mid).now;
    }

    // DP Index
    static class DI {
        int value, now;

        DI(int value, int now) {
            this.value = value;
            this.now = now;
        }
    }
}
