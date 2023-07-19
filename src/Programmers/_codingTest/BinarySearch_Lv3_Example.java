package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// BinarySearch LV3 예제

public class BinarySearch_Lv3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
        System.out.println(s.solution(new int[]{5}, 1));
    }

    static class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;

            int left = stones[0];
            int right = stones[0];
            for (int i = 0; i < stones.length; i++) {
                left = Math.min(left, stones[i]);
                right = Math.max(right, stones[i]);
            }

            while (left <= right) {
                int mid = (left + right) / 2;

                boolean pass = true;
                int cnt = 0;
                for (int i = 0; i < stones.length; i++) {
                    if (stones[i] < mid) {
                        cnt++;
                    } else {
                        cnt = 0;
                    }

                    if (cnt == k) {
                        pass = false;
                        break;
                    }
                }

                if (pass == false) {
                    right = mid - 1;
                } else {
                    answer = mid;
                    left = mid + 1;
                }
            }

            return answer;
        }
    }
}
