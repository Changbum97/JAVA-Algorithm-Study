package Programmers.practice;

public class p12951 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("3people unFollowed me"));
        System.out.println(s.solution("for the last week"));
        System.out.println(s.solution("AbCdEF G hi"));
    }
    static class Solution {
        public String solution(String s) {
            String answer = "";

            for(int i = 0 ; i < s.length() ; i ++) {
                boolean check = false;
                if(i == 0 || s.charAt(i - 1) == ' ') {
                    check = true;
                    if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                        answer += (char)(s.charAt(i) + 'A' - 'a');
                    } else {
                        answer += s.charAt(i);
                    }
                }

                if(check == false) {
                    if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                        answer += (char)(s.charAt(i) + 'a' - 'A');
                    } else {
                        answer += s.charAt(i);
                    }
                }
            }

            return answer;
        }
    }
}
