package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/150368
// DFS LV2 예제

public class Dfs_Lv2_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer1[] = s.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(answer1[0] + " " + answer1[1]);
        int answer2[] = s.solution(new int[][]{{40, 2900},{23, 10000},{11, 5200},{5, 5900},{40, 3100},{27, 9200},{32, 6900}}, new int[]{1300, 1500, 1600, 4900});
        System.out.println(answer2[0] + " " + answer2[1]);
    }

    static class Solution {

        static int maxJoin = 0;
        static int totalPrice = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2];

            dfs(0, users, emoticons, new int[emoticons.length]);

            answer[0] = maxJoin;
            answer[1] = totalPrice;
            return answer;
        }

        public void dfs(int step, int[][] users, int[] emoticons, int[] discount) {
            if (step >= emoticons.length) {
                int tempJoin = 0;
                int tempTotalPrice = 0;

                for (int i = 0 ; i < users.length ; i ++) {
                    int tempSum = 0;

                    for (int j = 0 ; j < emoticons.length ; j ++) {
                        if (users[i][0] <= discount[j]) {
                            tempSum += emoticons[j] / 100 * (100 - discount[j]);
                        }
                    }

                    if (tempSum < users[i][1]) {
                        tempTotalPrice += tempSum;
                    } else {
                        tempJoin ++;
                    }
                }

                if (tempJoin > maxJoin) {
                    maxJoin = tempJoin;
                    totalPrice = tempTotalPrice;
                } else if (tempJoin == maxJoin) {
                    totalPrice = Math.max(tempTotalPrice, totalPrice);
                }

                return;
            }

            for (int i = 10 ; i <= 40 ; i += 10) {
                discount[step] = i;
                dfs(step + 1, users, emoticons, discount);
            }
        }
    }
}
