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

    /**
     * Iterative Function to insert a value in BST
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
            }
        }
        return false;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) return;
        System.out.println(current.getData());
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }

    /**
     * Searches a Node in the Tree, returns true if present or false if not present
     * @param value
     * @return
     */
    public boolean booleanSearch(int value) {

        if (isEmpty()) {
            return false;
        }
        Node current = root;

        while (current != null) {

            if (current.getData() == value) {
                return true;
            }
            if (current.getData() > value) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return false;
    }

    /**
     * Searches a value in the Tree
     * @param value
     * @return
     */
    public Node nodeSearch(int value) {

        if (isEmpty()) return null; // if tree is empty simply return null

        Node currentNode = this.root;

        while (currentNode != null) {

            if (currentNode.getData() == value) return currentNode; // compare data from current node

            if (currentNode.getData() > value) //if data from current node is greater than value
                currentNode = currentNode.getLeftChild(); // then move towards left subtree
            else
                currentNode = currentNode.getRightChild(); //else move towards right subtree
        }

        System.out.println(value + " Not found in the Tree!");
        return null;
    }

}
