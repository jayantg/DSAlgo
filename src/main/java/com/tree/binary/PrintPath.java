package com.tree.binary;

public class PrintPath {
    public static void main(String[] args) {
        PrintPath printPath = new PrintPath();
        BinaryTree tree = BinaryTree.buildTestTree();
        System.out.println("Print All path");
        int[] array = new int[256];
        printPath.printAllPath(tree.getRoot(), array, 0);
        System.out.println("Print path from root to node");
        printPath.printPathTo(tree.getRoot(),7);
        System.out.println();
        System.out.println("Print path between two node");
        printPath.printPathBetween(tree.getRoot(), 5, 3);
    }

    private boolean printPathBetween(Node node, int a, int b) {
        if (node == null) {
            return false;
        }
        boolean l = printPathBetween(node.getLeft(), a, b);
        boolean r = printPathBetween(node.getRight(), a, b);
        if(node.getData() == a || node.getData() == b || l || r){
            System.out.print(node.getData() + " ");
            return true;
        }
        return false;
    }

    private boolean printPathTo(Node node, int n) {
        if (node != null) {
            boolean l = printPathTo(node.getLeft(), n);
            boolean r = printPathTo(node.getRight(), n);
            if(node.getData() == n || l || r){
                System.out.print( node.getData() + " ");
                return true;
            }
        }
        return false;
    }

    private void printAllPath(Node node, int[] array, int len) {
        if (node != null) {
            array[len] = node.getData();
            len++;
            if (node.getLeft() == null && node.getRight() == null) {
                printList(array, len);
                return;
            }
            printAllPath(node.getLeft(),array, len);
            printAllPath(node.getRight(),array, len);
        }else {
            printList(array, len);
        }
    }

    private void printList(int[] array, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
