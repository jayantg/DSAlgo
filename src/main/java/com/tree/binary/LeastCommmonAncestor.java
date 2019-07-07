package com.tree.binary;

public class LeastCommmonAncestor {
    public static void main(String[] args) {
        LeastCommmonAncestor lcaApp = new LeastCommmonAncestor();
        BinaryTree tree = BinaryTree.buildTestTree();
        int a; int b; Node result;

        a=4; b=5;
        result = lcaApp.getLCANode(tree.getRoot(), a, b);
        System.out.println(String.format("LCA of %d and %d is %d", a, b, result.getData()));

        a=4; b=6;
        result = lcaApp.getLCANode(tree.getRoot(), a, b);
        System.out.println(String.format("LCA of %d and %d is %d", a, b, result.getData()));

        a=3; b=4;
        result = lcaApp.getLCANode(tree.getRoot(), a, b);
        System.out.println(String.format("LCA of %d and %d is %d", a, b, result.getData()));

        a=2; b=4;
        result = lcaApp.getLCANode(tree.getRoot(), a, b);
        System.out.println(String.format("LCA of %d and %d is %d", a, b, result.getData()));
    }

    private Node getLCANode(Node node, int a, int b) {
        if (node == null) {
            return null;
        }
        if(node.getData() == a || node.getData() == b){
            return node;
        }
        Node lca_left = getLCANode(node.getLeft(), a, b);
        Node lca_right = getLCANode(node.getRight(), a, b);
        if (lca_left != null && lca_right != null){
            return node;
        }
        return lca_left != null ? lca_left : lca_right;
    }
}
