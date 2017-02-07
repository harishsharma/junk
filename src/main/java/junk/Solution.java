package junk;

import java.util.*;

/**
 * Created by harish.sharma on 9/18/16.
 */
public class Solution {

    public static Integer ref = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right = new TreeNode(70);
        root.right.right = new TreeNode(80);
        root.right.left = new TreeNode(60);

        inorder(root);
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        int data = root.data + ref;
        ref = data;
        root.data = ref;
        System.out.println(root.data);
        inorder(root.left);
    }

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}
