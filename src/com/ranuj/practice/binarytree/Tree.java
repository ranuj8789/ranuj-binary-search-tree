package com.ranuj.practice.binarytree;

import java.util.Stack;

public class Tree {
    public Node rootNode;

    public void addNode(int data) {
        rootNode = addNodeRecursive(rootNode, data);
    }

    public Node addNodeRecursive(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data > node.data) {
            node.rightNode = addNodeRecursive(node.rightNode, data);
        } else {
            node.leftNode = addNodeRecursive(node.leftNode, data);
        }
        return node;
    }

    public void addNodeIterative(int data) {
        if (rootNode == null) {
            rootNode = new Node(data);
            return;
        }
        Node currNode = rootNode;
        Node prevNode = rootNode;
        while (currNode != null) {
            prevNode = currNode;
            if (data > currNode.data) {
                currNode = currNode.rightNode;
            } else {
                currNode = currNode.leftNode;
            }
        }
        if (data > prevNode.data) {
            prevNode.rightNode = new Node(data);
        } else {
            prevNode.leftNode = new Node(data);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print(node.data + " ");
            inOrder(node.rightNode);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.data + " ");
        }
    }

    public void inOrderIterative() {
        Stack<Node> stackNode = new Stack<>();
        Node currNode = rootNode;
        while (!stackNode.isEmpty() || currNode != null) {
            if (currNode != null) {
                stackNode.push(currNode);
                currNode = currNode.leftNode;
            } else {
                Node tempNode = stackNode.pop();
                System.out.print(tempNode.data + " ");
                currNode = tempNode.rightNode;
            }
        }
    }

    public void preOrderIterative() {
        Stack<Node> stackNode = new Stack<>();
        Node currNode = rootNode;
        stackNode.push(rootNode);
        while (!stackNode.isEmpty()) {
            Node tempNode = stackNode.pop();
            System.out.print(tempNode.data + " ");
            if (tempNode.rightNode != null) {
                stackNode.push(tempNode.rightNode);
            }
            if (tempNode.leftNode != null) {
                stackNode.push(tempNode.leftNode);
            }
        }
    }

    public void postOrderIterative() {
        Stack<Node> tempStack = new Stack<>();
        Stack<Node> outStack = new Stack<>();
        Node currNode = rootNode;
        tempStack.push(currNode);
        while (!tempStack.isEmpty()) {
            Node outNode = tempStack.pop();
            outStack.push(outNode);
            if (outNode.leftNode != null) {
                tempStack.push(outNode.leftNode);
            }
            if (outNode.rightNode != null) {
                tempStack.push(outNode.rightNode);
            }
        }
        while (!outStack.isEmpty()) {
            System.out.print(outStack.pop().data + " ");
        }
    }
}
