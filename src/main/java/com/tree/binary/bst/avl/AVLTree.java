package com.tree.binary.bst.avl;

public class AVLTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {

        int[] arr1 = {10,20,5,3};
        insertExample(arr1, 1,"Left Left Rotation(LL)");

        insertExample(arr1, 4,"Left Right Rotation(LR)");

        int[] arr2 = {10,20,5,30};
        insertExample(arr2, 40,"Right Right Rotation(RR)");

        insertExample(arr2, 25,"Right Left Rotation(RL)");
    }

    private static void insertExample(int[] arr, int data, String type){
        AVLTree tree = new AVLTree();
        for (int i : arr) {
            tree.setRoot(tree.insert(tree.root,i));
        }
        System.out.println("\n" + type);
        tree.print(tree.root);
        tree.insert(tree.root,data);
        System.out.println();
        tree.print(tree.root);
    }

    public Node insert(Node node, int data){
        if (node == null) {
            return new Node(data);
        }else if(node.getData() >= data){
            node.setLeft(insert(node.getLeft(), data));
        }else{
            node.setRight(insert(node.getRight(),data));
        }
        int balance = height(node.getLeft()) - height(node.getRight());
        if (balance > 1){
            if(height(node.getLeft().getLeft())> height(node.getLeft().getRight())){
                node = rotateRight(node);
            }else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        if (balance<-1){
            if(height(node.getRight().getRight())>height(node.getRight().getLeft())){
                node = rotateLeft(node);
            }else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        node.setHeight(1+ Math.max(height(node.getLeft()),height(node.getRight())));
        return node;
    }

    private Node rotateLeft(Node node) {
        Node current = node.getRight();
        node.setRight(current.getLeft());
        current.setLeft(node);
        current.setHeight(1+ Math.max(height(current.getLeft()),height(current.getRight())));
        node.setHeight(1+ Math.max(height(node.getLeft()),height(node.getRight())));
        return current;
    }

    private Node rotateRight(Node node) {
        Node current = node.getLeft();
        node.setLeft(current.getRight());
        current.setRight(node);
        current.setHeight(1+ Math.max(height(current.getLeft()),height(current.getRight())));
        node.setHeight(1+ Math.max(height(node.getLeft()),height(node.getRight())));
        return current;
    }

    private int height(Node node) {
        return node != null?node.getHeight():0;
    }

    public void print(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " ");
        print(node.getLeft());
        print(node.getRight());
    }
}
