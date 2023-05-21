package BOJ.etc;

import java.util.Scanner;

public class p7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];

        for (int i = 0 ; i < n ; i ++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            people[i] = new Person(w, h);
        }

        int[] result = new int[n];
        for (int i = 0 ; i < n ; i ++) {

            int bigCount = 0;
            for (int j = 0 ; j < n ; j ++) {
                if (i == j) continue;;

                if (people[i].bigger(people[j])) {
                    bigCount ++;
                }
            }

            result[i] = bigCount + 1;
        }

        for (int i = 0 ; i < n ; i ++) {
            System.out.print(result[i] + " ");
        }
    }

    private static class Person {
        int weight, height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        boolean bigger(Person p) {
            if (p.height > this.height && p.weight > this.weight) {
                return true;
            }
            return false;
        }
    }
}
