package Programmers.stack_queue;

public class p12909 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()()"));
        System.out.println(s.solution("(())()"));
        System.out.println(s.solution(")()("));
        System.out.println(s.solution("(()("));
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;

            int open = 0;
            for(int i = 0 ; i < s.length() ; i ++) {
                if(s.charAt(i) == '(') {
                    open ++;
                } else {
                    open --;
                    if(open == -1) {
                        answer = false;
                        break;
                    }
                }
            }
            if(open != 0) {
                answer = false;
            }

            return answer;
        }
    }
}
