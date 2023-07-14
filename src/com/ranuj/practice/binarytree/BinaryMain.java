package com.ranuj.practice.binarytree;

public class BinaryMain {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNodeIterative(40);
        tree.addNodeIterative(20);
        tree.addNodeIterative(30);
        tree.addNodeIterative(80);
        tree.addNodeIterative(60);
        tree.inOrder(tree.rootNode);
        System.out.println();
        tree.inOrderIterative();

        System.out.println();

        tree.preOrder(tree.rootNode);
        System.out.println();
        tree.preOrderIterative();

        System.out.println();

        tree.postOrder(tree.rootNode);
        System.out.println();
        tree.postOrderIterative();


    }
}
