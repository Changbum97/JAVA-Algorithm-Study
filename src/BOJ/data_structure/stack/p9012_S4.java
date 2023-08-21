package BOJ.data_structure.stack;

/**
 * 괄호
 * 실버 4
 * https://www.acmicpc.net/problem/9012
 */

import java.util.Scanner;
import java.util.Stack;

public class p9012_S4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0 ; i < n ; i ++) {
            String str = sc.nextLine();
            System.out.println(check(str));
        }
    }

    private static String check(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < str.length() ; i ++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "NO";
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
