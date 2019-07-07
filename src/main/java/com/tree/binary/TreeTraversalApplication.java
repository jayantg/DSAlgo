package com.tree.binary;

import java.util.Scanner;

public class TreeTraversalApplication {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        Scanner s = new Scanner(System.in);
        int numOfNodes = s.nextInt();

        for (int i = 0; i < numOfNodes; i++) {
            tree.insert(new Node(s.nextInt()));
        }

        System.out.println("Pre order traversal");
        tree.preOrder();
        System.out.println();
        System.out.println("In order traversal");
        tree.inOrder();
        System.out.println();
        System.out.println("Post order traversal");
        tree.postOrder();
        System.out.println();
        System.out.println("Level order traversal");
        tree.levelOrder();
    }
}

