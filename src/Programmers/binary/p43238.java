package Programmers.binary;

public class p43238 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[]{7, 10}));
    }
    static class Solution {
        public long solution(int n, int[] times) {
            long left = 1;
            long right = 9876543210000L;
            long mid = 0;

            while(left <= right) {
                mid = (left + right) / 2;
                long people = calc(mid, times);

                if(people >= n) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        public long calc(long time, int[] times) {
            long people = 0;
            for(int i = 0 ; i < times.length ; i ++) {
                people += time / times[i];
            }
            return people;
        }
    }
}
