package Programmers.PCCP;

import java.util.Arrays;

public class p2_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution("GRGLGRG")));
        System.out.println(Arrays.toString(s.solution("GRGRGRB")));
    }
    static class Solution {
        public int[] solution(String command) {
            int[] answer = new int[]{0, 0};

            int[] row = new int[]{1, 0, -1, 0};
            int[] col = new int[]{0, 1, 0, -1};
            int direction = 0;

            for(int i = 0 ; i < command.length() ; i ++) {
                char c = command.charAt(i);

                if(c == 'G') {
                    answer[1] += row[direction];
                    answer[0] += col[direction];
                } else if(c == 'R') {
                    if(direction == 3) {
                        direction = 0;
                    } else {
                        direction ++;
                    }
                } else if(c == 'L') {
                    if(direction == 0) {
                        direction = 3;
                    } else {
                        direction --;
                    }
                } else {
                    answer[1] -= row[direction];
                    answer[0] -= col[direction];
                }
            }

            return answer;
        }
    }
}
