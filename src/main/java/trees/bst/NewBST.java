package trees.bst;

/**
 * Created by harish.sharma on 2/10/16.
 */
public class NewBST {

    private Node root;

    public NewBST() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data < data) root.right = insert(root.right, data);
        else root.left = insert(root.left, data);
        return root;
    }

    public void printBST() {
        printBST(root);
    }

    private void printBST(Node root) {
        if (root == null) return;
        printBST(root.left);
        System.out.println(root.data);
        printBST(root.right);
    }


    public static void main(String[] arg) {
        NewBST bst = new NewBST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        bst.printBST();
    }

    public class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
