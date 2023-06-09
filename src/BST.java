import java.lang.reflect.Array;
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
        return helpSearch(this.root, val);
    }

    public boolean helpSearch(BSTNode root, int val) {
        // If the value is in the tree return true and otherwise check if value is greater or less than current root
        // and go through the corresponding side.
        if (root.getVal() == val) {
            return true;
        }

        if(root.getVal() < val) {
            if(root.getRight() == null) {
                return false;
            }
            return helpSearch(root.getRight(), val);
        }
        else {
            if(root.getLeft() == null) {
                return false;
            }
            return helpSearch(root.getLeft(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> arr = new ArrayList<>();
        inHelper(root, arr);
        return arr;
    }

    public  void inHelper(BSTNode root, ArrayList<BSTNode> arr) {
        // If root is not null go left, root, right order of adding nodes
        if (root == null) {
            return;
        }
        else {
            inHelper(root.getLeft(), arr);
            arr.add(root);
            inHelper(root.getRight(), arr);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> arr = new ArrayList<>();
        preHelper(root, arr);
        return arr;
    }
    public  void preHelper(BSTNode root, ArrayList<BSTNode> arr) {
        // If root is not null go root, left, right order of adding nodes
        if (root == null) {
            return;
        }
        else {
            arr.add(root);
            preHelper(root.getLeft(), arr);
            preHelper(root.getRight(), arr);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> arr = new ArrayList<>();
        postHelper(root, arr);
        return arr;
    }

    public  void postHelper(BSTNode root, ArrayList<BSTNode> arr) {
        // If root is not null go left, right, root order of adding nodes
        if (root == null) {
            return;
        }
        else {
            postHelper(root.getLeft(), arr);
            postHelper(root.getRight(), arr);
            arr.add(root);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        insertHelp(val, root);
    }

    public void insertHelp(int val, BSTNode root) {
        // If the root is null then make the value the new root
        if (root == null) {
            root = new BSTNode(val);
        }
        // If the root is in the tree then just return
        if (root.getVal() == val) {
            return;
        }
        // Depending on if the val is greater or less than the root, check if the node on that side is null or not
        // and if it is make that the value and otherwise go further down in the tree
        if (root.getVal() > val) {
            if(root.getLeft() == null) {
                root.setLeft(new BSTNode(val));
                return;
            }
            insertHelp(val, root.getLeft());
        }

        if (root.getVal() < val) {
            if (root.getRight() == null) {
                root.setRight(new BSTNode(val));
                return;
            }
            insertHelp(val, root.getRight());
        }
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
