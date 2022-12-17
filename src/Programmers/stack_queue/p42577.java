package Programmers.stack_queue;

import java.util.*;

public class p42577 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(s.solution(new String[]{"123","456","789"}));
        System.out.println(s.solution(new String[]{"12","123","1235","567","88"}));
    }
    static class Solution {
        public boolean solution(String[] phone_book) {
            HashSet<String> set = new HashSet<>();
            int n = phone_book.length;

            for(int i = 0 ; i < n ; i ++) {
                set.add(phone_book[i]);
            }

            for(int i = 0 ; i < n ; i ++) {
                String temp = phone_book[i];
                for(int j = 1 ; j < temp.length() ; j ++) {
                    if(set.contains( temp.substring(0, j) )) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
