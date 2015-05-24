package hackerrank;

import java.util.Scanner;

import lombok.ToString;

/**
 * https://www.hackerrank.com/challenges/find-maximum-index-product
 * 
 * @author harish.sharma
 *
 */
public class MaxIndexProduct {

    public static long solve(int[] a) {
        int len = a.length;
        int[] left = new int[len];
        int j = 0;
        for (int i = 1; i < len; i++) {
            for (j = i - 1; j >= 1; j--) {
                if (a[j] > a[i]) {
                    left[i] = j;
                    break;
                }
            }
            if (j == 0) left[i] = j;
        }

        long max = 0;
        int k = 0;
        for (int i = 1; i < len; i++) {
            for (k = i + 1; k < len; k++) {
                if (a[k] > a[i]) {
                    left[i] = left[i] * k;
                    max = Math.max(max, left[i]);
                    break;
                }
            }
            if (k == len) left[i] = 0;
        }
        return max;
    }


    public static long solve1(int[] a) {
        int len = a.length;
        Node root = null;
        for (int i = 1; i < len; i++) {
            root = insert(root, a[i], i);
        }
        return 0l;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve1(a));
        in.close();
    }

    @ToString
    public static class Node {
        int  data;
        int  index;
        Node left;
        Node right;
        Node parent;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private static Node insert(Node root, int data, int index) {
        if (root == null) return new Node(data, index);
        if (data < root.data) {
            root.left = insert(root.left, data, index);
        } else if (data > root.data) {
            root.right = insert(root.right, data, index);
        } else {
            if (root.right != null) {
                Node temp = root.right;
                root.right = new Node(data, index);
                root.right.right = temp;
            } else {
                root.right = new Node(data, index);
            }
        }
        return root;
    }
}
