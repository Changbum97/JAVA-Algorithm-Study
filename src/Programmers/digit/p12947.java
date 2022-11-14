package Programmers.digit;

public class p12947 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
        System.out.println(s.solution(11));
        System.out.println(s.solution(12));
        System.out.println(s.solution(13));
    }

    static class Solution{
        public boolean solution(int x) {
            int sumOfDigit = 0;

            int temp = x;
            while(temp != 0) {
                sumOfDigit += temp % 10;
                temp /= 10;
            }

            if(x % sumOfDigit == 0) {
                return true;
            }
            return false;
        }
    }
}
