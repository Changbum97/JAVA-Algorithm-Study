package Programmers.greedy;

public class p12979 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(11, new int[]{4, 11}, 1));
        System.out.println(s.solution(16, new int[]{9}, 2));
    }
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int start = 1;
            int end;
            int cover = 2 * w + 1;

            for(int i = 0 ; i < stations.length ; i ++) {
                end = stations[i] - w - 1;
                if(start <= end) {
                    answer += (end - start) / cover + 1;
                }
                start = stations[i] + w + 1;
            }
            end = n;
            if(start <= end) {
                answer += (end - start) / cover + 1;
            }

            return answer;
        }
    }
}
