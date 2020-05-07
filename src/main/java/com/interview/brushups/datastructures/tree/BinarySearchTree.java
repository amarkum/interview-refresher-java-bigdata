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

    public boolean insert(Node node, int value){

        if(node == null){
            node = new Node(value);
        }

        Node current = node;

        if(current.getData()>value){
            insert(current.getLeftChild(),value);
        }
        else {
            insert(current.getRightChild(),value);
        }
        return false;
    }

    public Node recursiveInsert(Node node, int value){

        if(node == null){
            return new Node(value);
        }

        if(node.getData() > value){
            node.setLeftChild(recursiveInsert(node.getLeftChild(), value));
        }
        else if(node.getData() < value){
            node.setRightChild(recursiveInsert(node.getRightChild(), value));
        }
        else {
            return node;
        }

        return node;
    }

    /**
     *
     * @param root
     * @return
     * Find Height of a Binary Search Tree
     *
     * Find Height of left subtree right subtree
     * Return greater height value of left or right subtree (plus 1)
     */
    public int findHeight(Node root) {
        //Base case, leaf nodes have 0 height
        if (root == null) return -1;
        else {
            return 1 + Math.max(findHeight(root.getLeftChild()),findHeight(root.getRightChild()));
        }
    }

   /**
    * 3 conditions for delete
    *  1. Node is Leaf Node.
    *  2. Node has 1 Child.
    *  3. Node has 2 Children.
    **/
    boolean delete(int value, Node currentNode) {

        // If there are no elements in the tree, return false
        if (root == null) {
            return false;
        }

        // Create a Node Parent, which hold the Previous/Parent Node of Current
        Node parent = null;

        // Traverse until Tree fully traversed or We find the Correct Node
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();
        }

        // If the traversal is complete, and there was no node with the value, return false.
        if(currentNode == null) {
            return false;
        }

        // Suppose, we got the matching data, and it appears to be a leaf node.
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node

                //if that leaf node is the root (a tree with just root)
                if(root.getData() == currentNode.getData()){
                    setRoot(null);
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(null);
                    return true;
                }
                else{
                    parent.setRightChild(null);
                    return true;
            }
        }

        // 2. Node has 1 Child
        else if(currentNode.getRightChild() == null) {

                if(root.getData() == currentNode.getData()){
                    setRoot(currentNode.getLeftChild());
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(currentNode.getLeftChild());
                    return true;
                }
                else{
                    parent.setRightChild(currentNode.getLeftChild());
                    return true;
                }
        }

        else if(currentNode.getLeftChild() == null) {

                if(root.getData() == currentNode.getData()){
                    setRoot(currentNode.getRightChild());
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(currentNode.getRightChild());
                    return true;
                }
                else{
                    parent.setRightChild(currentNode.getRightChild());
                    return true;
                }

        }

        // 3. Node has 2 Children.
        else {
                //Find Least Value Node in right-subtree of current Node
                Node leastNode = findLeastNode(currentNode.getRightChild());
                //Set CurrentNode's Data to the least value in its right-subtree
                int temp = leastNode.getData();
                delete(temp, root);
                currentNode.setData(temp);
                //Delete the leafNode which had the least value
                return true;
        }

    }

    //Helper function to find least value node in right-subtree of currentNode
    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }
}
