package BOJ.greedy;

import java.util.Scanner;

public class p1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str += '=';
        int ans = 0;
        int temp = 0;
        boolean minus = false;  // minus가 한번 나오면 그 뒤는 모두 빼줌

        for(int i = 0 ; i < str.length() ; i ++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                temp = temp * 10 + (c - '0');
            } else {
                if(minus == true) {
                    ans -= temp;
                } else {
                    ans += temp;
                    if(c == '-') {
                        minus = true;
                    }
                }
                temp = 0;
            }
        }

        System.out.println(ans);
    }
}
