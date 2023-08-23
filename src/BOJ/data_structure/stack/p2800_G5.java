package BOJ.data_structure.stack;

/**
 * 괄호 제거
 * 골드 5
 * https://www.acmicpc.net/problem/2800
 */

import java.util.*;

public class p2800_G5 {

    static PriorityQueue<String> answer;
    static String input;
    static List<Bracket> brackets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        brackets = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < input.length() ; i ++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                brackets.add(new Bracket(stack.pop(), i));
            }
        }

        answer = new PriorityQueue<>();
        dfs(0, new boolean[brackets.size()], 0);

        String before = "";
        String after;
        while (!answer.isEmpty()) {
            after = answer.poll();
            if (!before.equals(after)) {
                System.out.println(after);
            }
            before = after;
        }
    }

    private static void dfs(int step, boolean[] erased, int eraseCnt) {
        if (step == brackets.size()) {
            if (eraseCnt != 0) {
                String temp = input;
                for (int i = 0 ; i < brackets.size() ; i ++) {
                    if (erased[i]) {
                        temp = temp.substring(0, brackets.get(i).startIdx) + "_" + temp.substring(brackets.get(i).startIdx + 1);
                        temp = temp.substring(0, brackets.get(i).endIdx) + "_" + temp.substring(brackets.get(i).endIdx + 1);
                    }
                }
                answer.add(temp.replaceAll("_", ""));
            }
        } else {
            erased[step] = false;
            dfs(step + 1, erased, eraseCnt);
            erased[step] = true;
            dfs(step + 1, erased, eraseCnt + 1);
        }
    }

    private static class Bracket {
        int startIdx, endIdx;

        Bracket(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }
}
