package BOJ.data_structure.stack;

/**
 * 후위 표기식
 * 골드 2
 * https://www.acmicpc.net/problem/1918
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class p1918_G2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "(" + sc.next() + ")";

        List<String> inputList = new ArrayList<>();
        for (int i = 0 ; i < input.length() ; i ++) {
            inputList.add(input.charAt(i) + "");
        }

        while(existBracket(inputList)) {
            int start = 0;
            int end = 0;

            // 가장 내부 괄호를 찾는 로직
            for (int i = 0 ; i < inputList.size() ; i ++) {
                if (inputList.get(i).equals("(")) {
                    start = i;
                } else if (inputList.get(i).equals(")")) {
                    end = i;
                    break;
                }
            }

            // 가장 내부 괄호를 찾아 하나의 String으로 변환
            List<String> temp = new ArrayList<>();
            for (int i = start + 1 ; i < end ; i ++) {
                temp.add(inputList.get(i));
            }

            String result = makeResult(temp);
            inputList = makeNewInputList(inputList, result, start, end);
        }
        System.out.println(inputList.get(0));
    }

    private static List<String> makeNewInputList(List<String> list, String mid, int start, int end) {
        List<String> result = new ArrayList<>();

        for (int i = 0 ; i < start ; i ++) {
            result.add(list.get(i));
        }

        result.add(mid);

        for (int i = end + 1 ; i < list.size() ; i ++) {
            result.add(list.get(i));
        }

        return result;
    }

    // 괄호가 없는 구간
    private static String makeResult(List<String> list) {
        String result = "";
        Stack<String> stack = new Stack<>();

        for (int i = 0 ; i < list.size() ; i ++) {
            if (isOp(list.get(i))) {
                if (list.get(i).equals("*") || list.get(i).equals("/")) {
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        result += stack.pop();
                    }
                    stack.push(list.get(i));
                } else {
                    while (!stack.isEmpty()) {
                        result += stack.pop();
                    }
                    stack.push(list.get(i));
                }
            } else {
                result += list.get(i);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static boolean isOp(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean existBracket(List<String> list) {
        for (String str : list) {
            if (str.equals("(")) {
                return true;
            }
        }
        return false;
    }
}
