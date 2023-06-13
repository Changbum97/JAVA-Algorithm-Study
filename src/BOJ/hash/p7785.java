package BOJ.hash;

import java.util.*;

public class p7785 {
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
