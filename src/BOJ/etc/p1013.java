package BOJ.etc;

import java.util.Scanner;

public class p1013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int t = 0 ; t < n ; t ++) {
            String str = sc.nextLine();
            String answer = "YES";

            // status = 0 => 이전 문자열이 끝난 상황
            // status = 1 -> 01이 나올 상황
            // status = 2 -> 100+1+가 나올 상황, 0이 나오고 있는 상황
            // status = 3 -> 100+1+가 나올 상황, 1이 나오고 있는 상황
            int status = 0;
            for (int i = 0 ; i < str.length() ; i ++) {
                char c = str.charAt(i);
                if (status == 0) {
                    if (c == '0') {
                        // 이후에 01이 나와야 함
                        status = 1;
                    } else {
                        // 이후에 100+1+가 나와야 함
                        status = 2;
                    }
                } else if (status == 1) {
                    if (c == '1') {
                        // 01이 나온 경우
                        status = 0;
                    } else {
                        // 01이 나와야 하는데 00이 나온 경우
                        answer = "NO";
                        break;
                    }
                } else if (status == 2) {
                    if (c == '1') {
                        // 이전에 0이 최소 2개는 있어야 함
                        if (str.charAt(i - 1) != '0' || str.charAt(i - 2) != '0') {
                            answer = "NO";
                            break;
                        } else {
                            status = 3;
                        }
                    }
                } else if (status == 3) {
                    if (c == '0') {
                        // 100+1+가 나오다가 0을 마주친 상황 => (1001)100... or (10011)01
                        if (i == str.length() - 1) {
                            // 마지막에 0이 나왔다면 잘못된 상황
                            answer = "NO";
                            break;
                        } else if (str.charAt(i + 1) == '1') {
                            // 100+1+가 끝나고 01이 나온 경우
                            i ++;
                            status = 0;
                        } else {
                            // 100+1+가 끝나고 100+1+가 나온 경우 => 앞에 1이 최소 2개 있어야 하고, 뒤에 0이 하나는 더 있어야 함
                            if (str.charAt(i - 1) != '1' || str.charAt(i - 2) != '1' || str.charAt(i + 1) != '0') {
                                answer = "NO";
                                break;
                            } else {
                                status = 2;
                            }
                        }
                    }
                }
            }

            // 이전에 01이 나오고 끝나거나 100+1+의 1이 나오던중 끝난 경우만 YES
            if (status != 0 && status != 3) {
                answer = "NO";
            }
            System.out.println(answer);
        }
    }
}
