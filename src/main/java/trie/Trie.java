package trie;

import java.util.LinkedList;

/**
 * 
 * @author harish.sharma
 *
 */
public class Trie {

    @SuppressWarnings("unused")
    private final TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        if (search(word) == true) return;
    }

    private boolean search(String word) {
        return false;
    }

    /**
     * 
     * @author harish.sharma
     *
     */
    public static class TrieNode {
        char                 data;
        boolean              isEnd;
        int                  count;
        LinkedList<TrieNode> children;

        public TrieNode(char data) {
            this.data = data;
            this.isEnd = false;
            this.count = 0;
            this.children = new LinkedList<>();
        }

        /**
         * returns the node whose data is equals to c or returns null.
         * 
         * @param c
         * @return
         */
        public TrieNode contains(char c) {
            if (children != null) {
                for (TrieNode node : children) {
                    if (node.data == c) {
                        return node;
                    }
                }
            }
            return null;
        }
    }
}
