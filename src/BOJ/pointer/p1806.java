package BOJ.pointer;

import java.util.Scanner;

public class p1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 숫자의 개수
        int goal = sc.nextInt();    // 목표 숫자
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        sum[0] = 0;

        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i - 1] + arr[i];
        }

        int left = 1;
        int right = 1;
        int answer = Integer.MAX_VALUE;

        while(right <= n) {
            if (sum[right] - sum[left - 1] >= goal) {
                answer = Math.min(answer, right - left + 1);
                left ++;
            } else {
                right ++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
