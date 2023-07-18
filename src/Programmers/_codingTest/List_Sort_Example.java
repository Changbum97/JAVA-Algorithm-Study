package Programmers._codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990?language=java
// ArrayList 정렬 예제

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List_Sort_Example {

    static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];

            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();

            for (int i = 0 ; i < wallpaper.length ; i ++) {
                for (int j = 0 ; j < wallpaper[i].length() ; j ++) {
                    char c = wallpaper[i].charAt(j);
                    if (c == '#') {
                        xList.add(i);
                        yList.add(j);
                    }
                }
            }

            Collections.sort(xList, Collections.reverseOrder());
            Collections.sort(yList, Collections.reverseOrder());

            answer[0] = xList.get(0);
            answer[1] = yList.get(0);
            answer[2] = xList.get( xList.size() - 1 ) + 1;
            answer[3] = yList.get( yList.size() - 1 ) + 1;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] answer1 = s.solution(new String[]{".#...", "..#..", "...#."});
        for (int num : answer1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] answer2 = s.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
        for (int num : answer2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] answer3 = s.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        for (int num : answer3) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] answer4 = s.solution(new String[]{"..", "#."});
        for (int num : answer4) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
