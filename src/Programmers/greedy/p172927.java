package Programmers.greedy;

import java.util.*;

public class p172927 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(s.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }

    static class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int totalPicks = picks[0] + picks[1] + picks[2];

            List<Integer> sumList = new ArrayList<>();

            int tempSum = 0;
            int tempIdx = 0;

            for (int i = 0 ; i < minerals.length ; i ++) {
                if (i % 5 == 0) {
                    if (tempIdx != 0) {
                        sumList.add(tempSum);
                    }

                    tempSum = 0;
                    tempIdx ++;
                    if (tempIdx > totalPicks) {
                        tempIdx --;
                        break;
                    }
                }

                if (minerals[i].equals("diamond")) {
                    tempSum += 100;
                } else if (minerals[i].equals("iron")) {
                    tempSum += 10;
                } else {
                    tempSum += 1;
                }
            }

            if (tempSum != 0) {
                sumList.add(tempSum);
            }

            Collections.sort(sumList, Collections.reverseOrder());

            for (int sum : sumList) {
                int diamond = sum / 100;
                int iron = (sum / 10) % 10;
                int stone = sum % 10;

                if (picks[0] > 0) {
                    answer += diamond + iron + stone;
                    picks[0] --;
                } else if (picks[1] > 0) {
                    answer += (diamond * 5) + iron + stone;
                    picks[1] --;
                } else if (picks[2] > 0) {
                    answer += (diamond * 25) + (iron * 5) + stone;
                } else {
                    break;
                }
            }

            return answer;
        }
    }
}
