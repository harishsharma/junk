package trie;

/**
 * 
 * @author harish.sharma
 *
 */
public class Trie {

    public void initialize(Node vertex) {
        vertex.words = 0;
        vertex.prefixes = 0;
        vertex.children = new Node[26];
    }

    public void addWord(Node vertex, String word) {
        if (word.isEmpty()) {
            vertex.words = vertex.words + 1;
        } else {
            vertex.prefixes += 1;
            char first = word.charAt(0);
            word = word.substring(1);
            if (vertex.children[first - 'a'] == null) {
                vertex.children[first - 'a'] = new Node();
            }
            addWord(vertex.children[first - 'a'], word);
        }
    }

    public Integer countPrefixes(Node vertex, String prefix) {
        if (prefix.isEmpty())
            return vertex.prefixes;
        else if (vertex.children[prefix.charAt(0) - 'a'] == null)
            return 0;
        else {
            return countPrefixes(vertex.children[prefix.charAt(0) - 'a'], prefix.substring(1));
        }
    }

    public Integer countWords(Node vertex, String prefix) {
        if (prefix.isEmpty())
            return vertex.words;
        else if (vertex.children[prefix.charAt(0) - 'a'] == null)
            return 0;
        else {
            return countWords(vertex.children[prefix.charAt(0) - 'a'], prefix.substring(1));
        }
    }


    public static class Node {
        Integer words;
        Integer prefixes;
        Node[]  children;

        public Node() {
            words = 0;
            prefixes = 0;
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Node root = new Node();
        trie.addWord(root, "harish");
        trie.addWord(root, "harit");
        System.out.println(trie.countPrefixes(root, "har"));
        System.out.println(trie.countWords(root, "harish"));
    }
}
