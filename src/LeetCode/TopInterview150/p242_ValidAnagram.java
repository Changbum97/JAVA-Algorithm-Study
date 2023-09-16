package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/242.-Valid-Anagram
 */

public class p242_ValidAnagram {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram", "nagaram") == true);
        System.out.println(s.isAnagram("rat", "car") == false);
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] alphabet = new int[26];
            for (int i = 0 ; i < s.length() ; i ++) {
                char c = s.charAt(i);
                alphabet[c - 'a'] ++;
            }

            for (int i = 0 ; i < t.length() ; i ++) {
                char c = t.charAt(i);
                alphabet[c - 'a'] --;
                if (alphabet[c - 'a'] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
