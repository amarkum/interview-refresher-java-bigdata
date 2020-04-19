# Trees Notes

### What is a Tree?
 A tree consists of nodes (vertices) that are connected using pointers (edges). <br/>
 Trees are similar to Graphs; the key differentiating point is that a cycle cannot exist in a Tree.
 
 ### Components of a Tree - Nodes: Hold data
- `Root` : The uppermost node of a tree
- `Parent Node` : A node which is connected to one or more nodes on the lower level (Child Nodes).
- `Child Node` : A node which is linked to an upper node (Parent Node)
- `Sibling Node` : Nodes that have the same Parent Node
- `Leaf Node` : A node that doesn’t have any Child Node

### Terminologies in Tree
Here are some other common terminologies used in trees:

- `Sub-tree` :
A subtree is a portion of a tree that can be viewed as a complete tree on its own. Any node in a tree, together with all the connected nodes below it, comprise a subtree of the original tree. Think of the sub-tree as an analogy for the term, proper subset.

- `Degree` :
The degree of a node refers to the total number of sub-trees of a node

- `Depth` :
The number of connections (edges) from the root to a node is known as the depth of that node.

- `Level` :
*(Depth Of Node) + 1(DepthOfNode)+1*

- `Height of a Node` :
The maximum number of connections between the node and a leaf node in its path is known as the height of that node.

- `Height of a Tree` :
The height of a tree is simply the height of its root node.

### Types of Binary Tree
- Complete Binary Tree 
    - All levels are filled except possibly the last one
    - Nodes at the last level are as far left as possible
- Full Binary Tree
    - Every node has 0 or 2 children. No node can have 1 child.
- Perfect Binary Tree
    - A Binary Tree is said to be Perfect if its Full and Complete
    
    
