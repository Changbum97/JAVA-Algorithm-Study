package Programmers.binary;

public class p17681 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] answer = s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21 ,17, 28});
        answer = s.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
        for(int i = 0 ; i < answer.length ; i ++) {
            System.out.println(answer[i]);
        }
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String padding = " ".repeat(n);

            for(int i = 0 ; i < n ; i ++) {
                // or 연산을 통해 하나라도 1이면 1, 둘 다 0이면 0
                int line = arr1[i] | arr2[i];

                // 한 줄을 binary String으로 전환
                String binaryString = Integer.toBinaryString(line);

                // padding과 substring을 사용해서 자리수 맞추기
                answer[i] = (padding + binaryString).substring(binaryString.length());

                // 1 -> #, 0 -> 빈칸 으로 변환
                answer[i] = answer[i]
                        .replace('1', '#')
                        .replace('0', ' ');
            }

            return answer;
        }
    }
}
