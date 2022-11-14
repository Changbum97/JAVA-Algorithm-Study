package Programmers.digit;

public class p120906 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1234));
        System.out.println(s.solution(930211));
    }

    static class Solution {
        public int solution(int n) {
            int sum = 0;

            while(n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }
}
