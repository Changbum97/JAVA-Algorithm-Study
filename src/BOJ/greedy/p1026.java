package BOJ.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        Integer[] brr = new Integer[n];
        for (int i = 0 ; i < n ; i ++) {
            brr[i] = sc.nextInt();
        }
        Arrays.sort(brr, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0 ; i < n ; i ++) {
            answer += arr[i] * brr[i];
        }

        System.out.println(answer);
    }
}
