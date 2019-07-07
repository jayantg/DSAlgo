package com.tree.binary;

/**
 * Pre order traversal
 * 1 2 4 5 3 6 7
 * In order traversal
 * 4 2 5 1 6 3 7
 */
public class TreeFromInAndPreOrder {
    int current = 0;
    public static void main(String[] args) {
        TreeFromInAndPreOrder app = new TreeFromInAndPreOrder();
        String[] pre = {"1","2","4","5","3","6","7"};
        String[] in =  {"4","2","5","1","6","3","7"};
        Node root = app.makeTree(pre,in,0,6);
        BinaryTree tree = new BinaryTree();
        tree.setRoot(root);
        System.out.println("Pre");
        tree.preOrder();
        System.out.println();
        System.out.println("In");
        tree.inOrder();
        System.out.println();
        System.out.println("Post");
        tree.postOrder();
    }

    private Node makeTree(String[] pre, String[] in, int start, int end) {
        if(current>=pre.length || start>end){
            return null;
        }
        int n = Integer.parseInt(pre[current]);
        Integer i = findInOrder(n, in, start,end);
        if (i == null) {
            return null;
        }
        Node node = new Node(n);
        current = current + 1;
        Node left = makeTree(pre, in, start, i - 1);
        if (left != null) {
            current = current + 1;
        }
        Node right = makeTree(pre, in, i + 1, end);
        if (right == null) {
            current = current - 1;
        }
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    private Integer findInOrder(int n, String[] in, int start, int end) {
        for (int i = start; i <= end; i++) {
            if(Integer.parseInt(in[i]) == n){
                return i;
            }
        }
        return null;
    }
}
