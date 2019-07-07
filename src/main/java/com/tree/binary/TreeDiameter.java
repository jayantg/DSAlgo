package com.tree.binary;

public class TreeDiameter {
    int diameter;
    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();
        BinaryTree tree = BinaryTree.buildTestTree();
        tree.levelOrder();
        treeDiameter.diameter(tree.getRoot(), treeDiameter);
        System.out.println();
        System.out.println("Diameter of tree: " + treeDiameter.diameter);
    }

    private int diameter(Node node, TreeDiameter treeDiameter) {
        if (node == null) {
            return 0;
        }
        int left = diameter(node.getLeft(), treeDiameter);
        int right = diameter(node.getRight(), treeDiameter);
        if(left + right > treeDiameter.diameter){
            treeDiameter.diameter = left + right;
        }
        return Math.max(left,right) + 1;
    }
}
