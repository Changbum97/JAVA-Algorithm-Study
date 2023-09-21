package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/word-search-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/212.-Word-Search-II
 */

import java.util.*;

public class p212_WordSearch2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> answer1 = s.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
        System.out.println( ( answer1.size() == 2 && answer1.get(0).equals("oath") && answer1.get(1).equals("eat") )
                || ( answer1.size() == 2 && answer1.get(0).equals("eat") && answer1.get(1).equals("oath") ));
        List<String> answer2 = s.findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcd"});
        System.out.println( answer2.size() == 0 );
    }

    static class Solution {

        private static Trie trie;
        private static final int[] row = new int[]{0, 0, 1, -1};
        private static final int[] col = new int[]{1, -1, 0, 0};

        public List<String> findWords(char[][] board, String[] words) {
            trie = new Trie();
            int m = board.length;
            int n = board[0].length;

            boolean[] lenCheck = new boolean[11];
            int cnt = 0;
            for (String word : words) {
                if (lenCheck[word.length()] == false) {
                    lenCheck[word.length()] = true;
                    makeTrie(word.length(), m, n, board);
                    cnt ++;
                }
                if (cnt == 10) break;
            }

            List<String> answer = new ArrayList<>();
            for (String word : words) {
                if (trie.search(word)) {
                    answer.add(word);
                }
            }

            return answer;
        }

        private void makeTrie(int len, int m, int n, char[][] board) {
            for (int i = 0 ; i < m ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    boolean[][] check = new boolean[m][n];
                    check[i][j] = true;
                    dfs(i, j, 1, len, board[i][j] + "", board, check);
                }
            }
        }

        private void dfs(int x, int y, int idx, int len, String word, char[][] board, boolean[][] check) {
            if (idx == len) {
                trie.insert(word);
                return;
            }

            for (int i = 0 ; i < 4 ; i ++) {
                int newX = x + row[i];
                int newY = y + col[i];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
                if (check[newX][newY]) continue;

                check[newX][newY] = true;
                dfs(newX, newY, idx + 1, len, word + board[newX][newY], board, check);
                check[newX][newY] = false;
            }
        }
    }

    static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node current = this.root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (current.children[idx] == null) {
                    current.children[idx] = new Node();
                }
                current = current.children[idx];
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            Node current = this.root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (current.children[idx] == null) return false;

                current = current.children[idx];
            }

            return current.isEndOfWord;
        }
    }

    static class Node {
        Node[] children;
        boolean isEndOfWord;

        Node() {
            this.children = new Node[26];
            this.isEndOfWord = false;
        }
    }
}
