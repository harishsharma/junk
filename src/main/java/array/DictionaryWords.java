package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a matrix of characters and a dictionary find out how many words can be formed from matrix which are in
 * dictionary.
 * 
 * @author harish.sharma
 *
 */
public class DictionaryWords {

    public static Set<String> solve(char[][] mat, Set<String> dict) {
        Set<String> res = new HashSet<>();
        int row = mat.length;
        int col = mat[0].length;
        StringBuilder sb = new StringBuilder("");
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                solveInternal(mat, dict, res, i, j, sb, isVisited);
            }
        }
        return res;
    }

    private static void solveInternal(char[][] mat, Set<String> dict, Set<String> res, int startX, int startY,
            StringBuilder sb, boolean[][] isVisited) {
        if (startX < 0 || startX > mat[0].length - 1 || startY < 0 || startY > mat.length - 1) return;
        if (isVisited[startX][startY]) return;
        String str = sb.append(mat[startX][startY]).toString();
        if (dict.contains(str)) res.add(str);
        isVisited[startX][startY] = true;
        solveInternal(mat, dict, res, startX + 1, startY, sb, isVisited);
        solveInternal(mat, dict, res, startX - 1, startY, sb, isVisited);
        solveInternal(mat, dict, res, startX, startY + 1, sb, isVisited);
        solveInternal(mat, dict, res, startX, startY - 1, sb, isVisited);
        sb.deleteCharAt(sb.length() - 1);
        isVisited[startX][startY] = false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("poll");
        dict.add("at");
        dict.add("ear");
        dict.add("all");
        dict.add("pot");
        dict.add("top");
        dict.add("lot");
        char[][] mat = { { 'a', 'l', 'l'}, { 't', 'o', 'p'}, { 'e', 'a', 'r'}};
        System.out.println(solve(mat, dict));
    }
}
