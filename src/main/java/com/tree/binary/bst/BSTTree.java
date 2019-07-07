package com.tree.binary.bst;

import com.tree.binary.Node;

public class BSTTree {
    private Node root;

    public static void main(String[] args) {
        //Delete node with no children
        int[] arr1 = {6,2,8,1,5};
        deleteExample(arr1, 5);
        //Delete node with one child
        int[] arr2 = {6,2,8,1,4,3};
        deleteExample(arr2, 4);
        //Delete node with both children
        int[] arr3 = {4,2,8,5,1,7,9};
        deleteExample(arr3, 8);

        BSTTree tree = new BSTTree();
        for (int i:arr3) {
            tree.insert(i);
        }
        System.out.println();
        tree.print(tree.root);
        System.out.println("\nMax Element: " +tree.findMax());
        System.out.println("Min Element: " +tree.findMin());
        System.out.println("Is element 9 present? " + tree.find(tree.root, 9));
        System.out.println("Is element 6 present? " + tree.find(tree.root, 6));
    }

    private static void deleteExample(int[] arr, int delete){
        BSTTree tree = new BSTTree();
        for (int i : arr) {
            tree.insert(i);
        }
        System.out.println("\nPre Order ");
        tree.print(tree.root);
        tree.delete(tree.root, delete);
        System.out.println("\nTree after deletion");
        tree.print(tree.root);
    }

    /**
     *
     * @param node
     * @param data
     * @return
     */
    public Node delete(Node node, int data){
        if (node == null) {
            return null;
        }
        if(node.getData()==data){
            if(node.getLeft()==null && node.getRight()==null){
                return null;
            }else if(node.getLeft()==null || node.getRight()==null){
                return node.getLeft()==null ? node.getRight() : node.getLeft();
            }else {
                Node current = node.getLeft();
                while (current.getRight() != null){
                    current = current.getRight();
                }
                node.setData(current.getData());
                node.setLeft(delete(node.getLeft(),current.getData()));
            }
        }else if(node.getData()>data){
            node.setLeft(delete(node.getLeft(),data));
        }else {
            node.setRight(delete(node.getRight(),data));
        }
        return node;
    }
    /**
     * Recursive insert
     * @param node
     * @param data
     * @return
     */
    public Node insert(Node node, int data){
        if (node == null) {
            return new Node(data);
        }
        if(node.getData()>data){
            node.setLeft(insert(node.getLeft(),data));
        }else {
            node.setRight(insert(node.getRight(),data));
        }
        return node;
    }

    /**
     * Iterative insert
     * @param data
     */
    public void insert(int data){
        if (root == null) {
            root = new Node(data);
        }else {
            Node current = root;
            while (true){
                if(data>current.getData()){
                    if(current.getRight()!=null){
                        current=current.getRight();
                    }else {
                        current.setRight(new Node(data));
                        return;
                    }
                }else {
                    if (current.getLeft() != null) {
                        current=current.getLeft();
                    }else {
                        current.setLeft(new Node(data));
                        return;
                    }
                }
            }
        }
    }

    /**
     *
     * @param node Starting node
     * @param data data to be found
     * @return true if found else false
     */
    public boolean find(Node node, int data){
        if (node == null) {
            return false;
        }
        if(node.getData() > data){
            return find(node.getLeft(), data);
        }else if(node.getData() < data){
            return find(node.getRight(), data);
        }else {
            return true;
        }
    }

    /**
     *
     * @return findMin
     */
    public Integer findMin(){
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    /**
     *
     * @return findMax
     */
    public Integer findMax(){
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node.getRight()!=null){
            node=node.getRight();
        }
        return node.getData();
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
