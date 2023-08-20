package BOJ.binarySearch.lis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p12015 {

    static List<Integer> dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
        }

        dp = new ArrayList<>();
        dp.add(0);
        dp.add(arr[0]);

        for (int i = 1 ; i < n ; i ++) {
            if (arr[i] > dp.get(dp.size() - 1)) {
                dp.add(arr[i]);
            } else {
                // dp에서 arr[i]보다 작은값 중 가장 큰 값 바로 뒤의 값을 arr[i]로 수정
                // arr[i]보다 작은값 중 가장 큰 값을 찾기 위해 이분 탐색 사용
                binary_search(arr[i]);
            }
        }

        System.out.println(dp.size() - 1);
    }

    private static void binary_search(int x) {
        int left = 0;
        int right = dp.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (dp.get(mid) >= x) {
                right = mid - 1;
            } else {
                if (dp.get(mid) < x && dp.get(mid + 1) >= x) {
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        dp.set(mid + 1, x);
    }
}
