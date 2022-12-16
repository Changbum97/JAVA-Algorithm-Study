package Programmers.binary;

import java.util.*;

public class p67258 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
    static class Solution {
        public int[] solution(String[] gems) {
            int len = gems.length;
            String[] gems2 = new String[len + 1];
            for(int i = 1 ; i <= len ; i ++) {
                gems2[i] = gems[i - 1];
            }

            List<String> type = new ArrayList<>();
            int typeCnt = 0;
            for(int i = 1 ; i <= len; i ++) {
                if(type.contains(gems2[i])) {
                    continue;
                } else {
                    type.add(gems2[i]);
                    typeCnt ++;
                }
            }

            int[] answer = new int[]{1, len};
            int left = typeCnt;
            int right = len;
            int mid = 0;

            while(left < right) {
                mid = (left + right) / 2;
                boolean success = false;
                HashMap<String, Integer> map = new HashMap<>();

                for(int i = 1 ; i <= mid ; i ++) {
                    if(map.get(gems2[i]) == null) {
                        map.put(gems2[i], 1);
                    } else {
                        map.put(gems2[i], map.get(gems2[i]) + 1);
                    }
                }

                for(int i = 1 ; i <= len - mid + 1 ; i ++) {
                    if(map.size() == typeCnt) {
                        success = true;
                        answer[0] = i;
                        answer[1] = i + mid - 1;
                        break;
                    } else {
                        // 맨 앞 삭제
                        if(map.get(gems2[i]) == 1) {
                            map.remove(gems2[i]);
                        } else {
                            map.put(gems2[i], map.get(gems2[i]) - 1);
                        }

                        // 맨 뒤 추가
                        if(i == len - mid + 1) {
                            break;
                        }
                        if(map.get(gems2[i + mid]) == null) {
                            map.put(gems2[i + mid], 1);
                        } else {
                            map.put(gems2[i + mid], map.get(gems2[i + mid]) + 1);
                        }
                    }
                }

                if(success == true) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return answer;
        }
    }
}
