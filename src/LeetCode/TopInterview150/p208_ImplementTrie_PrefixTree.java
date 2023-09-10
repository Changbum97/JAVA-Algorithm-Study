package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/208.-Implement-Trie-Prefix-Tree
 */

public class p208_ImplementTrie_PrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple") == true);
        System.out.println(trie.search("app") == false);
        System.out.println(trie.startsWith("app") == true);
        trie.insert("app");
        System.out.println(trie.search("app") == true);
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

        static Node current;

        public boolean search(String word) {
            if (!startsWith(word)) return false;
            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            current = this.root;

            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (current.children[idx] == null) return false;

                current = current.children[idx];
            }
            return true;
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
