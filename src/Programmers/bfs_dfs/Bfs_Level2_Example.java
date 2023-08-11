package Programmers.bfs_dfs;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * DFS Level2 예제
 */
public class Bfs_Level2_Example {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3) == 5);
        System.out.println(s.solution(new int[]{4, 1, 2, 1}, 4) == 2);
    }

    static class Solution {
        static int answer;

        public int solution(int[] numbers, int target) {
            answer = 0;

            dfs(0, new boolean[numbers.length], numbers, target);

            return answer;
        }

        public static void dfs(int step, boolean[] plus, int[] numbers, int target) {
            if (step == numbers.length ) {
                int temp = 0;
                for (int i = 0 ; i < numbers.length ; i ++) {
                    if (plus[i]) {
                        temp += numbers[i];
                    } else {
                        temp -= numbers[i];
                    }
                }
                if (temp == target) {
                    answer ++;
                }
            } else {
                plus[step] = true;
                dfs(step + 1, plus, numbers, target);
                plus[step] = false;
                dfs(step + 1, plus, numbers, target);
            }
        }
    }
}
