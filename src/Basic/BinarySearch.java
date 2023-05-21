// https://www.acmicpc.net/problem/1920

package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // Array 크기 (1~10만)
        arr = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();       // 찾을 개수 (1~10만)
        for (int i = 0 ; i < m ; i ++) {
            int target = sc.nextInt();

            // target이 arr에 존재하는지
            boolean targetExist = binarySearch(target);
            if (targetExist) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static boolean binarySearch(int target) {
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return true;
            }
            else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
