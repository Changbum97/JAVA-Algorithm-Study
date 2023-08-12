package Programmers.bfs_dfs;

/**
 * 여행 경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * DFS Level3 예제
 */

import java.util.*;

public class Dfs_Level3_Example {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(test(s.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}), new String[]{"ICN", "JFK", "HND", "IAD"}));
        System.out.println(test(s.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}), new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}));
    }

    static boolean test(String[] result, String answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (!result[i].equals(answer[i])) {
                return false;
            }
        }

        return true;
    }

    static class Solution {

        static int[] answer;
        static List<Integer>[] list;
        static List<Boolean>[] check;
        static boolean end;

        public String[] solution(String[][] tickets) {

            // String인 tickets를 int로 변환
            PriorityQueue<String> pq = new PriorityQueue<>();
            for (String[] ticket : tickets) {
                if (!pq.contains(ticket[0])) {
                    pq.add(ticket[0]);
                }
                if (!pq.contains(ticket[1])) {
                    pq.add(ticket[1]);
                }
            }

            Map<String, Integer> map = new HashMap<>();
            Map<Integer, String> map2 = new HashMap<>();
            int idx = 0;
            int start = 0;
            while(!pq.isEmpty()) {
                if (pq.peek().equals("ICN")) {
                    start = idx;
                }
                map.put(pq.peek(), idx);
                map2.put(idx, pq.poll());
                idx ++;
            }

            list = new ArrayList[idx];
            check = new ArrayList[idx];
            for (int i = 0 ; i < idx ; i ++) {
                list[i] = new ArrayList<>();
                check[i] = new ArrayList<>();
            }
            for (String[] ticket : tickets) {
                list[map.get(ticket[0])].add(map.get(ticket[1]));
                check[map.get(ticket[0])].add(false);
            }
            for (int i = 0 ; i < idx ; i ++) {  Collections.sort(list[i]); }

            answer = new int[tickets.length + 1];
            answer[0] = start;
            end = false;

            dfs(1, start, tickets.length);

            String[] strAnswer = new String[tickets.length + 1];
            for (int i = 0 ; i <= tickets.length ; i ++) {
                strAnswer[i] = map2.get(answer[i]);
            }

            return strAnswer;
        }

        public static void dfs(int step, int now, int n) {
            if (step == n + 1) {
                end = true;
            }

            for (int i = 0 ; i < list[now].size() ; i ++) {
                if (check[now].get(i) == false) {
                    check[now].set(i, true);
                    answer[step] = list[now].get(i);
                    dfs(step + 1, list[now].get(i), n);
                    if (end) return;
                    check[now].set(i, false);
                }
            }
        }
    }
}
