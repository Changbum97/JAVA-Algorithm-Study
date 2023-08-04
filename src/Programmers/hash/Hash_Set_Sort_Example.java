package Programmers.hash;

/**
 * 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * Hash와 Set을 사용하고 Arrays.Sort 설정하여 사용한 예제
 */

import java.util.*;

public class Hash_Set_Sort_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}) == false);
        System.out.println(s.solution(new String[]{"123", "456", "789"}) == true);
        System.out.println(s.solution(new String[]{"12", "123", "1235", "567", "88"}) == false);
        System.out.println(s.solution(new String[]{"12", "2121212", "1"}) == false);
    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            // 문자열 길이를 기준으로 오름차순 정렬
            Arrays.sort(phone_book, (o1, o2) -> {
                return o1.length() - o2.length();
            });

            Set<String> set = new HashSet<>();
            for(String phone : phone_book) {

                String temp = "";
                for (int i = 0 ; i < phone.length() ; i ++) {
                    temp += phone.charAt(i);
                    if (set.contains(temp)) {
                        return false;
                    }
                }
                set.add(phone);
            }

            return true;
        }
    }
}
