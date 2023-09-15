package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/383.-Ransom-Note
 */

public class p383_RansomNote {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canConstruct("a", "b") == false);
        System.out.println(s.canConstruct("aa", "ab") == false);
        System.out.println(s.canConstruct("aa", "aab") == true);
    }

    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] alphabet = new int[26];
            for (int i = 0 ; i < magazine.length() ; i ++) {
                char c = magazine.charAt(i);
                alphabet[c - 'a'] ++;
            }

            for (int i = 0 ; i < ransomNote.length() ; i ++) {
                char c = ransomNote.charAt(i);
                alphabet[c - 'a'] --;
                if (alphabet[c - 'a'] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
