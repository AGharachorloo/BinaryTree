import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Call the helper function
        return search(root, val);
    }
    private boolean search (BSTNode root, int val) {
        // Check to see if the current node is null, if it is, return false
        if (root == null) {
            return false;
        }
        // If the value of the node is equal to the desired value, return true
        if (root.getVal() == val) {
            return true;
        }
        // If the value is less than the current node, then recurse to the left node
        else if (val < root.getVal()) {
            return search(root.getLeft(), val);
        }
        // Otherwise, recurse to the right node.
        return search(root.getRight(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Make a list and call the helper function
        ArrayList<BSTNode> list = new ArrayList<>();
        getInorder(root, list);
        // Return the list of values in Inorder.
        return list;
    }
    private void getInorder(BSTNode root, ArrayList<BSTNode> list) {
        // While the node is not null
        if (root != null) {
            // Recurse as left as possible
            getInorder(root.getLeft(), list);
            // Add the node
            list.add(root);
            // recurse as right as possible
            getInorder(root.getRight(), list);
        }
    }


    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Make a new list and call helper function
        ArrayList<BSTNode> list = new ArrayList<>();
        getPreorder(root, list);
        // return the list completed
        return list;
    }
    private void getPreorder(BSTNode root, ArrayList<BSTNode> list) {
        // If the root is not null
        if (root != null) {
            // Add the node
            list.add(root);
            // recurse to the left and add each node
            getPreorder(root.getLeft(), list);
            // Recurse to the right and add each node
            getPreorder(root.getRight(), list);
        }
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Make a new list and call helper function
        ArrayList<BSTNode> list = new ArrayList<>();
        getPostorder(root, list);
        // return the list completed
        return list;
    }
    private void getPostorder(BSTNode root, ArrayList<BSTNode> list) {
        // if the root is not null
        if (root != null) {
            // Recurse to the left
            getPostorder(root.getLeft(), list);
            // Recurse to the right
            getPostorder(root.getRight(), list);
            // Add the node to the list after going both ways
            list.add(root);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Call helper function
        root = insert(root, val);
    }
    private BSTNode insert(BSTNode root, int val) {
        // If the node is null
        if (root == null) {
            // Add the new node with the desired value
            return new BSTNode(val);
        }
        // If the desired value is less than that of the node
        if (val < root.getVal()) {
            // Recurse to the left
            root.setLeft(insert(root.getLeft(), val));
        // if the desired value is greater than that of the node
        } else if (val > root.getVal()) {
            // recurse to the right
            root.setRight(insert(root.getRight(), val));
        }
        // return the root
        return root;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
