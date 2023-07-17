package Programmers._codingTest;

import java.util.Arrays;

public class test3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"}));
        System.out.println(s.solution(new String[]{"비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식", "토스커피사일로 베이", "토스커피사일로&베이커리"}));
    }

    static class Solution {
        public String[] solution(String[] merchantNames) {
            Arrays.sort(merchantNames, (o1, o2) -> {
                if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return 1;
                }
            });

            int n = merchantNames.length;
            boolean[] check = new boolean[n];
            Arrays.fill(check, true);

            for (int i = 0 ; i < n ; i ++) {
                if (check[i] == true) {
                    String temp = new String(merchantNames[i]);

                    for (int j = i + 1 ; j < n ; j ++) {
                        if (check[j] == false) continue;
                        int checkResult = checkSame(temp, merchantNames[j]);

                        if (checkResult == 1) {
                            check[j] = false;
                        } else if (checkResult == 2) {
                            check[i] = false;
                            temp = new String(merchantNames[j]);
                        }
                    }
                }
            }

            int size = 0;
            for (int i = 0 ; i < n ; i ++) {
                if (check[i] == true) {
                    size ++;
                }
            }

            String[] answer = new String[size];
            int idx = 0;
            for (int i = 0 ; i < n ; i ++) {
                if (check[i] == true) {
                    answer[idx] = String.valueOf(merchantNames[i]);
                    idx ++;
                }
            }
            return answer;
        }

        static int checkSame(String a, String b) {
            int aCnt = 0;
            int bCnt = 0;
            for (int i = 0 ; i < a.length() ; i ++) {
                if (a.charAt(i) == '&' || a.charAt(i) == '(' || a.charAt(i) == ')' || a.charAt(i) == '.' || a.charAt(i) == ',' || a.charAt(i) == '-') {
                    aCnt ++;
                }
            }
            for (int i = 0 ; i < b.length() ; i ++) {
                if (b.charAt(i) == '&' || b.charAt(i) == '(' || b.charAt(i) == ')' || b.charAt(i) == '.' || b.charAt(i) == ',' || b.charAt(i) == '-') {
                    bCnt ++;
                }
            }

            String tempA = a.replace("&", "").replace("(", "").replace(")","")
                    .replace(".", "").replace(",", "").replace("-", "").replace(" ", "");

            String tempB = b.replace("&", "").replace("(", "").replace(")","")
                    .replace(".", "").replace(",", "").replace("-", "").replace(" ", "");


            if (a.length() >= b.length() && tempA.contains(tempB) && aCnt >= bCnt) {
                return 1;
            } else if (b.length() >= a.length() && tempB.contains(tempA) && bCnt >= aCnt) {
                return 2;
            } else {
                return 3;
            }
        }
    }
}
