// https://www.acmicpc.net/problem/7785
// Hash + Priority Queue(문자열 사전 정렬)

package Basic;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hash_PQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0 ; i < n ; i ++) {
            String name = sc.next();
            String status = sc.next();

            if (status.equals("enter")) {
                hashSet.add(name);
            } else {
                hashSet.remove(name);
            }
        }

        PriorityQueue<String> result = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (String name : hashSet) {
            result.add(name);
        }

        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}
