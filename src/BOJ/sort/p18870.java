package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hashSet.add(arr[i]);
        }

        int newSize = hashSet.size();
        int[] compressedArr = new int[newSize];
        int idx = 0;
        for (int num : hashSet) {
            compressedArr[idx ++] = num;
        }

        Arrays.sort(compressedArr);

        for (int i = 0 ; i < n ; i ++) {
            int target = arr[i];
            int left = 0;
            int right = newSize;
            int mid = 0;

            while(left <= right) {
                mid = (left + right) / 2;
                if (compressedArr[mid] == target) {
                    break;
                }
                else if (compressedArr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(mid).append(" ");
        }
        System.out.println(sb);
    }
}
