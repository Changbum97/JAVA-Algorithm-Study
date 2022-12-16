package Programmers.stack_queue;

import java.util.*;

public class p42586 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString( s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}) ));
        System.out.println(Arrays.toString( s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}) ));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int n = progresses.length;

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ; i < n ; i ++) {
                if( (100 - progresses[i]) % speeds[i] == 0 ) {
                    queue.add( (100 - progresses[i]) / speeds[i] );
                } else {
                    queue.add( (100 - progresses[i]) / speeds[i] + 1);
                }
            }

            List<Integer> answerList = new ArrayList<>();
            int num = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty()) {
                int now = queue.poll();
                if(now > num) {
                    answerList.add(cnt);
                    num = now;
                    cnt = 1;
                } else {
                    cnt ++;
                }
            }
            answerList.add(cnt);

            int[] answer = new int[answerList.size()];
            for(int i = 0 ; i < answerList.size() ; i ++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }

}
