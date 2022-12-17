package Programmers.greedy;

public class p42883 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("1924", 2));
        System.out.println(s.solution("1231234", 3));
        System.out.println(s.solution("4177252841", 4));
    }
    static class Solution {
        public String solution(String number, int k) {
            int len = number.length();
            String answer = "";

            int startIdx = 0;
            int rest = len - k;

            for(int endIdx = k + 1 ; endIdx <= len ; endIdx ++) {

                int max = -1;
                int maxIdx = 0;

                for(int i = startIdx ; i < endIdx ; i ++) {
                    if(max < number.charAt(i) - '0') {
                        max = number.charAt(i) - '0';
                        maxIdx = i;
                    }
                    if(max == 9) break;
                }
                answer += (char)(max + '0');
                startIdx = maxIdx + 1;
            }

            return answer;
        }
    }
}
