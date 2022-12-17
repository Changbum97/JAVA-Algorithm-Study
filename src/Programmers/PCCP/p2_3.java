package Programmers.PCCP;

public class p2_3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10));
        System.out.println(s.solution(new int[]{5, 12, 30}, new int[]{2, 1, 0, 0, 0, 1, 0}, 10));
        System.out.println(s.solution(new int[]{5}, new int[]{0, 0, 0, 0, 0}, 5));
        System.out.println(s.solution(new int[]{5, 6, 7, 11}, new int[]{1, 2, 3, 3, 2, 1, 1}, 10));
    }
    static class Solution {
        public int solution(int[] menu, int[] order, int k) {
            int max = 0;

            for(int i = 0 ; i < order.length ; i ++) {
                order[i] = menu[ order[i] ];
                if(max < order[i]) {
                    max = order[i];
                }
            }

            int[] arr = new int[max * order.length + 1];

            int end = 0;
            int answer = 1;

            for(int i = 0 ; i < order.length ; i ++) {
                int start = i * k;

                if(end < start) {
                    end = start + order[i];
                } else {
                    end += order[i];
                }

                for(int j = start ; j < end ; j ++) {
                    arr[j] ++;
                    if(arr[j] > answer) {
                        answer = arr[j];
                    }
                }
            }
            return answer;
        }
    }
}
