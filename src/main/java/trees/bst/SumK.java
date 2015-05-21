package trees.bst;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Given a Binary Search Tree with integers at every node and an integer k, write code that decides whether or not there
 * exists two nodes a and b such that a+b=k
 * 
 * @author harish.sharma
 *
 */
public class SumK {
    public static boolean solve(Node<Integer> root, int k) {
        List<Integer> arr = Lists.newArrayList();
        inOrder(root, arr);
        int len = arr.size();
        for (int i = 0, j = len - 1; i < j;) {
            int left = arr.get(i);
            int right = arr.get(j);
            if (left + right == k)
                return true;
            else if (left + right > k)
                j--;
            else
                i++;
        }

        return false;
    }

    private static void inOrder(Node<Integer> root, List<Integer> arr) {
        if (root == null) return;
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5);
        root.left = new Node<>(3);
        root.left.left = new Node<>(2);
        root.left.left.left = new Node<>(1);
        root.left.right = new Node<>(4);
        root.right = new Node<>(6);
        root.right.right = new Node<>(8);
        System.out.println(solve(root, 5));
        System.out.println(solve(root, 9));
        System.out.println(solve(root, 10));
        System.out.println(solve(root, 7));
        System.out.println(solve(root, 3));
        System.out.println(solve(root, 15));
    }

}
