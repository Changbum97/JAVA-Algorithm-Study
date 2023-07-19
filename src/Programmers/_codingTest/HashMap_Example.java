package Programmers._codingTest;

import java.util.*;

public class HashMap_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer1 = s.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        );
        int[] answer2 = s.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4}
        );

        for (int i : answer1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : answer2) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            // <X, Y> = X의 부모가 Y
            Map<String, String> parents = new HashMap<>();
            for (int i = 0 ; i < enroll.length ; i ++) {
                parents.put(enroll[i], referral[i]);
            }

            Map<String, Integer> total = new HashMap<>();
            for (int i = 0 ; i < seller.length ; i ++) {
                int nowPrice = amount[i] * 100;
                String nowSeller = seller[i];

                while(!nowSeller.equals("-")) {

                    int temp = 0;

                    // 이전에 번 돈이 있는 경우
                    if (total.containsKey(nowSeller)) {
                        temp = total.get(nowSeller);
                    }

                    int givePrice = nowPrice / 10;
                    temp += nowPrice - givePrice;
                    total.put(nowSeller, temp);
                    nowPrice = givePrice;

                    if (nowPrice == 0) break;

                    nowSeller = parents.get(nowSeller);
                }
            }

            for (int i = 0 ; i < enroll.length ; i ++) {
                answer[i] = 0;
                if (total.containsKey(enroll[i])) {
                    answer[i] = total.get(enroll[i]);
                }
            }

            return answer;
        }
    }
}
