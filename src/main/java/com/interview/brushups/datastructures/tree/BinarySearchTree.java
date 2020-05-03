package com.interview.brushups.datastructures.tree;

/**
 * Binary Search Tree - (Ordered Binary Tree)
 * BST - is a variant of Binary Tree with a strict condition based on node value.
 * Left Child will always have lesser value than the node, while right has greater value.
 */
public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     *   Iterative Function to insert a value in BST
     */
    public boolean add(int value) {

        //If Tree is empty then insert Root with the given value inside Tree
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }
        //Starting from root
        Node currentNode = root;

        //Traversing the tree until valid position to insert the value
        while (currentNode != null) {

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            //If the value to insert is less than root value then move to left subtree
            //else move to right subtree of root
            //and before moving check if the subtree is null, if it's then insert the value.
            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            } //end of else
        } //end of while
        return false;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty()
    {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(Node current)
    {
        if (current == null) return;

        System.out.println(current.getData());
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }

}
