package BOJ.binarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class p20191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String str = sc.nextLine();
        // str로 target을 만들어야 됨

        ArrayList<Integer>[] positionList = new ArrayList[26];
        for(int i = 0 ; i < str.length() ; i ++) {
            char c = str.charAt(i);
            int charToInt = c - 'a';

            if(positionList[charToInt] == null) {
                positionList[charToInt] = new ArrayList<>();
            }
            positionList[charToInt].add(i);
        }

        int index = -1;     // 현재 str의 몇번째에 있는지
        int ans = 1;        // str을 몇개 썻는지
        for(int i = 0 ; i < target.length() ; i ++) {
            char c = target.charAt(i);
            int charToInt = c - 'a';

            // 나와야 되는 문자가 str에 한번도 없는 경우
            if(positionList[charToInt] == null) {
                ans = -1;
                break;
            } else {
                // 직전에 str에서 사용한 문자 이후에 만들어야 되는 문자가 나오지 않는 경우
                // 만들어야 되는 문자의 가장 첫번째 위치를 index로 지정, ans ++
                if(positionList[charToInt].get(positionList[charToInt].size() - 1 ) <= index) {
                    ans ++;
                    index = positionList[charToInt].get(0);
                } else {
                    // 이 상황에서는 index보다는 크지만, str에서 가장 먼저 나오는 문자를 찾아야 됨
                    index = search(index, 0, positionList[charToInt].size() - 1, positionList[charToInt]);
                }
            }
        }

        System.out.println(ans);
    }

    // list에서 index보다 크면서 가장 작은 값 찾기
    static int search(int index, int left, int right, ArrayList<Integer> list) {
        while(left < right) {
            int mid = (left + right) / 2 + 1;

            if(list.get(mid) > index && list.get(mid - 1) <= index ) {
                return list.get(mid);
            } else if(list.get(mid) > index && list.get(mid - 1) >= index) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
