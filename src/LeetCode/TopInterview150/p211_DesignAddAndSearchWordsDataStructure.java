package LeetCode.TopInterview150;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=study-plan-v2&envId=top-interview-150
 * https://velog.io/@changbum/211.-Design-Add-and-Search-Words-Data-Structure
 */

public class p211_DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad") == false);
        System.out.println(wordDictionary.search("bad") == true);
        System.out.println(wordDictionary.search(".ad") == true);
        System.out.println(wordDictionary.search("b..") == true);
    }

    static class WordDictionary {

        private Node root;

        public WordDictionary() {
            this.root = new Node();
        }

        public void addWord(String word) {
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
            current = this.root;
            return detailSearch(word, 0, 0);
        }

        public boolean detailSearch(String word, int startIdx, int checkCnt) {

            int idx = startIdx;
            for (; idx < word.length() ; idx ++) {
                char c = word.charAt(idx);
                if (c == '.') {
                    for (int j = 0 ; j < 26 ; j ++) {
                        if (current.children[j] != null) {
                            Node temp = current;
                            current = current.children[j];
                            if (detailSearch(word, idx + 1, checkCnt + 1)) {
                                return true;
                            }
                            current = temp;
                        }
                    }
                } else {
                    if (current.children[c - 'a'] == null) return false;
                    current = current.children[c - 'a'];
                    checkCnt ++;
                }
            }

            if (idx == checkCnt) {
                return current.isEndOfWord;
            } else {
                return false;
            }
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
