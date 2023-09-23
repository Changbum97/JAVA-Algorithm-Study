package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/373.-Find-K-Pairs-with-Smallest-Sums
 */

import java.util.*;

public class p373_FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> x1 = new ArrayList<>();
        x1.add(1);
        x1.add(2);
        List<Integer> x2 = new ArrayList<>();
        x2.add(1);
        x2.add(4);
        List<Integer> x3 = new ArrayList<>();
        x3.add(1);
        x3.add(6);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(x1);
        answer.add(x2);
        answer.add(x3);
        System.out.println(test(s.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3), answer));
    }

    static boolean test(List<List<Integer>> result, List<List<Integer>> answer) {
        if (result.size() != answer.size()) return false;

        for (int i = 0 ; i < result.size() ; i ++) {
            for (int j = 0 ; j < result.get(i).size() ; j ++) {
                if (result.get(i).get(j) != answer.get(i).get(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0 ; i < Math.min(nums1.length, k) ; i ++) {
                for (int j = 0 ; j < Math.min(nums2.length, k) ; j ++) {
                    if (pq.size() == k) {
                        Pair temp = pq.peek();

                        if (temp.x + temp.y <= nums1[i] + nums2[j]) {
                            break;
                        } else {
                            pq.poll();
                            pq.add(new Pair(nums1[i], nums2[j]));
                        }
                    } else {
                        pq.add(new Pair(nums1[i], nums2[j]));
                    }
                }
            }

            List<List<Integer>> answer = new ArrayList<>();
            while(k > 0 && !pq.isEmpty()) {
                Pair pair = pq.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(pair.x);
                temp.add(pair.y);

                answer.add(temp);
                k --;
            }
            Collections.reverse(answer);
            return answer;
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair pair) {
            // x + y를 기준으로 내림차순 정렬
            return pair.x + pair.y - this.x - this.y;
        }
    }
}
