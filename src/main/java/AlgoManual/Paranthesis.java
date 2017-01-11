package AlgoManual;

import java.util.Stack;

/**
 * Created by harish.sharma on 2/14/16.
 */
public class Paranthesis {

    public static boolean isBalanced(String parans) {
        char[] paranArray = parans.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < paranArray.length; i++) {
            if (paranArray[i] == ')' && stack.isEmpty()) return false;
            else if (paranArray[i] == ')') stack.pop();
            else stack.push('(');
        }
        return true;
    }

    public static void main(String[] argv) {
        System.out.println(isBalanced("(())"));
        System.out.println(isBalanced("(()()())"));
        System.out.println(isBalanced("(())())("));
    }
}
