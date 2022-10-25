package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2110 {
    static int n, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 집의 개수
        c = Integer.parseInt(st.nextToken());   // 공유기 개수

        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt( new StringTokenizer(br.readLine()).nextToken() );
        }
        Arrays.sort(arr);

        // 거리의 최소 : 1, 거리의 최대 : 마지막 집주소 - 처음 집주소
        int ans = binarySearch(1, arr[n - 1] - arr[0]);
        System.out.println(ans);
    }
    static int binarySearch(int left, int right) {
        if(left >= right) {
            return left;
        }

        int mid = (left + right) / 2 + 1;
        int count = 1;

        // temp가 이전 집 주소
        int temp = arr[0];
        for(int i = 1 ; i < n ; i ++) {
            // 이전 집과의 거리가 mid 이상이면 공유기 추가
            if(arr[i] - temp >= mid) {
                count ++;
                temp = arr[i];
                if(count >= c) {
                    // c개 이상 설치되면 뒷부분 return
                    return binarySearch(mid, right);
                }
            }
        }

        // c개 미만 설치되면 앞부분 return
        return binarySearch(left, mid - 1);
    }
}
