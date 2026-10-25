

public class Tree {
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    private Node root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.val) {
            node.left = insertRec(node.left, val);
        }else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    public boolean search(int val) {
        Node curr = root;

        while (curr != null) {
            if (curr.val == val) return true;
            if (curr.val > val) {
                curr = curr.left;
            }else if (curr.val < val) {
                curr = curr.right;
            }
        }
        return false;
    }
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRec(node.right), heightRec(node.left));
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.println(node.val);
        inOrderRec(node.right); 
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node == null) return;
        postOrderRec(node.left);
        postOrderRec(node.right); 
        System.out.println(node.val);
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node == null) return;
        System.out.println(node.val);
        preOrderRec(node.left);
        preOrderRec(node.right); 
        
    }
    
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] vals = {50, 30, 70, 20, 40, 60, 80, 10, 5, 35, 45};
        for (int v : vals) t.insert(v);

        t.inOrder(); 
        t.postOrder();
        t.preOrder();
    }
}