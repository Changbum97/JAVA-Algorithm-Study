package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.StringTokenizer;

public class p19943 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());
        for (int t = 0 ; t < testCase ; t ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            BigDecimal x = new BigDecimal(st.nextToken());
            BigDecimal y = new BigDecimal(st.nextToken());

            Stack<Light> inputStack = new Stack<>();
            inputStack.add(new Light(x, y, y.multiply(y)));

            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = new BigDecimal(st.nextToken());
                y = new BigDecimal(st.nextToken());

                while(!inputStack.isEmpty()) {
                    Light before = inputStack.pop();

                    // 이번 조형물의 높이에 맞게 설치했을 때 저번 조형물이 다 비춰지는 경우
                    if (y.compareTo(before.y) > 0 && y.subtract(x.subtract(before.x)).compareTo(before.y) >= 0) {
                        if (inputStack.isEmpty()) {
                            inputStack.add(new Light(x, y, y.multiply(y)));
                            break;
                        }
                    }
                    // 저번에 설치한 빛에 이번 조형물이 다 비춰지는 경우
                    else if (y.compareTo(before.y) < 0 && (before.y.subtract(x.subtract(before.x))).compareTo(y) >= 0) {
                        inputStack.add(before);
                        break;
                    } else {
                        inputStack.add(before);
                        inputStack.add(new Light(x, y, y.multiply(y)));
                        break;
                    }
                }
            }

            int size = inputStack.size();
            int idx = size - 1;
            BigDecimal[][] newInput = new BigDecimal[size][2];
            while(!inputStack.isEmpty()) {
                newInput[idx][0] = inputStack.peek().x;
                newInput[idx][1] = inputStack.pop().y;
                idx --;
            }

            Stack<Light> stack = new Stack<>();
            stack.add(new Light(newInput[0][0], newInput[0][1], newInput[0][1].multiply(newInput[0][1])));

            for (int i = 1 ; i < size ; i ++) {
                x = newInput[i][0];
                y = newInput[i][1];

                while(!stack.isEmpty()) {
                    Light before = stack.pop();

                    // 이번 조형물의 높이에 맞게 설치했을 때 저번 조형물이 다 비춰지는 경우
                    if (y.compareTo(before.y) > 0 && y.subtract(x.subtract(before.x)).compareTo(before.y) >= 0) {
                        if (stack.isEmpty()) {
                            stack.add(new Light(x, y, y.multiply(y)));
                            break;
                        }
                    }
                    // 저번에 설치한 빛에 이번 조형물이 다 비춰지는 경우
                    else if (y.compareTo(before.y) < 0 && (before.y.subtract(x.subtract(before.x))).compareTo(y) >= 0) {
                        stack.add(before);
                        break;
                    }
                    // 둘 다 아닌 경우
                    else {
                        // 따로 설치한 케이스
                        BigDecimal case1 = before.totalCost.add(y.multiply(y));
                        // 합쳐진 케이스 => 직선 y = x + (before.y - before.x)와 직선 y = -x + (nowX + nowY)의 교점 => (newX, newY)
                        BigDecimal newX = (x.add(y).add(before.x).subtract(before.y)).divide(new BigDecimal(2.0));
                        BigDecimal newY = newX.subtract(before.x).add(before.y);
                        BigDecimal case2 = newY.multiply(newY);

                        if (case2.compareTo(case1) <= 0) {
                            // 이전 빛과 합친다면 그 이전 빛과도 비교해봐야 하기 때문에 break X
                            x = newX;
                            y = newY;

                            if (stack.isEmpty()) {
                                stack.add(new Light(x, y, y.multiply(y)));
                                break;
                            }
                        } else {
                            stack.add(before);
                            stack.add(new Light(x, y, y.multiply(y)));
                            break;
                        }
                    }
                }
            }

            BigDecimal answer = new BigDecimal(0);
            while(!stack.isEmpty()) {
                answer = answer.add(stack.pop().totalCost);
            }
            sb.append(String.format("%.2f", answer)).append("\n");
        }
        System.out.print(sb);
    }

    private static class Light {
        //  x => 수평 위치, y => 높이
        BigDecimal x, y, totalCost;

        Light(BigDecimal x, BigDecimal y, BigDecimal totalCost) {
            this.x = x;
            this.y = y;
            this.totalCost = totalCost;
        }
    }
}
