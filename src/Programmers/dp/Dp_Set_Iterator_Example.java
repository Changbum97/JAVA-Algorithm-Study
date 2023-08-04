package Programmers.dp;

/**
 * N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * DP, HashSet, Iterator를 사용한 예제
 */

import java.util.*;

public class Dp_Set_Iterator_Example {

    static class Solution {
        public int solution(int N, int number) {

            if (N == number) {
                return 1;
            }

            List<Long>[] dp = new ArrayList[10];
            for (int i = 1 ; i <= 8 ; i ++) {
                dp[i] = new ArrayList<>();
            }
            dp[1].add(new Long(N));

            for (int answer = 2 ; answer <= 8 ; answer ++) {
                Set<Long> set = new HashSet<>();
                dp[answer].add(dp[answer-1].get(0) * 10 + N);
                set.add(dp[answer-1].get(0) * 10 + N);

                // N을 i, j개 사용한 것끼리의 조합
                for (int i = 1 ; i <= answer / 2 ; i ++) {
                    int j = answer - i;

                    for (Long iNum : dp[i]) {
                        for (Long jNum : dp[j]) {
                            set.add(iNum + jNum);
                            set.add(iNum - jNum);
                            set.add(jNum - iNum);
                            set.add(iNum * jNum);
                            if (jNum != 0) set.add(iNum / jNum);
                            if (iNum != 0) set.add(jNum / iNum);
                        }
                    }
                }

                if (set.contains(new Long(number))) {
                    return answer;
                } else {
                    Iterator<Long> it = set.iterator();
                    while(it.hasNext()) {
                        Long l = it.next();
                        dp[answer].add(l);
                    }
                }
            }

            return -1;
        }
    }
}
