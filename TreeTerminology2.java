import java.util.*;

class TreeTerminology2 {

    // ---------- NODE CLASS ----------
    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    // ---------- TREE CREATION ----------
    public static Node createTree() {

        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node I = new Node('I');
        Node J = new Node('J');

        // Connecting nodes
        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.right = F;

        E.left = I;
        E.right = J;

        return A; // root
    }

    // ---------- FIND LEVEL ----------
    public static int findLevel(Node root, char key, int level) {
        if (root == null) return -1;

        if (root.data == key) return level;

        int left = findLevel(root.left, key, level + 1);
        if (left != -1) return left;

        return findLevel(root.right, key, level + 1);
    }

    // ---------- PRINT LEAF NODES ----------
    public static void printLeafNodes(Node root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    // ---------- PRINT INTERNAL NODES ----------
    public static void printInternalNodes(Node root) {
        if (root == null) return;

        if (!(root.left == null && root.right == null)) {
            System.out.print(root.data + " ");
        }

        printInternalNodes(root.left);
        printInternalNodes(root.right);
    }

    // ---------- FIND NODE ----------
    public static Node findNode(Node root, char key) {
        if (root == null) return null;

        if (root.data == key) return root;

        Node left = findNode(root.left, key);
        if (left != null) return left;

        return findNode(root.right, key);
    }

    // ---------- FIND PARENT ----------
    public static Node findParent(Node root, char key) {
        if (root == null) return null;

        if ((root.left != null && root.left.data == key) ||
            (root.right != null && root.right.data == key)) {
            return root;
        }

        Node left = findParent(root.left, key);
        if (left != null) return left;

        return findParent(root.right, key);
    }

    // ---------- PRINT SIBLINGS ----------
    public static void printSiblings(Node root, char key) {
        Node parent = findParent(root, key);

        if (parent == null) {
            System.out.println("No siblings (root node or not found).");
            return;
        }

        boolean printed = false;

        if (parent.left != null && parent.left.data != key) {
            System.out.print(parent.left.data + " ");
            printed = true;
        }

        if (parent.right != null && parent.right.data != key) {
            System.out.print(parent.right.data + " ");
            printed = true;
        }

        if (!printed)
            System.out.print("No siblings");

        System.out.println();
    }

    // ---------- PRINT ANCESTORS ----------
    // prints ancestors from bottom to top
    public static boolean printAncestors(Node root, char key) {
        if (root == null) return false;

        if (root.data == key) return true;

        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

    // ---------- PREORDER TRAVERSAL ----------
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // ---------- PRINT DESCENDANTS ----------
    public static void printDescendants(Node root, char key) {
        Node node = findNode(root, key);

        if (node == null) {
            System.out.println("Node not found.");
            return;
        }

        boolean printed = false;

        if (node.left != null) {
            preorder(node.left);
            printed = true;
        }

        if (node.right != null) {
            preorder(node.right);
            printed = true;
        }

        if (!printed)
            System.out.print("No descendants");

        System.out.println();
    }

    // ---------- PRINT SUBTREE ----------
    public static void printSubtree(Node root, char key) {
        Node node = findNode(root, key);

        if (node == null) {
            System.out.println("Node not found.");
            return;
        }

        preorder(node);
        System.out.println();
    }

    // ---------- PRINT NEIGHBOURS ----------
    public static void printNeighbours(Node root, char key) {
        Node node = findNode(root, key);

        if (node == null) {
            System.out.println("Node not found.");
            return;
        }

        Node parent = findParent(root, key);

        System.out.print("Parent: ");
        if (parent == null) System.out.print("NULL");
        else System.out.print(parent.data);

        System.out.print(" | Children: ");
        if (node.left != null) System.out.print(node.left.data + " ");
        if (node.right != null) System.out.print(node.right.data + " ");

        if (node.left == null && node.right == null)
            System.out.print("No children");

        System.out.println();
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Node root = createTree();

        System.out.println("Tree Created Successfully!");
        System.out.println("--------------------------");

        // Root node
        System.out.println("Root Node: " + root.data);

        // Leaf nodes
        System.out.print("Leaf Nodes: ");
        printLeafNodes(root);
        System.out.println();

        // Internal nodes
        System.out.print("Internal Nodes: ");
        printInternalNodes(root);
        System.out.println();

        // Level
        char keyLevel = 'I';
        System.out.println("Level of " + keyLevel + " = " + findLevel(root, keyLevel, 0));

        // Parent
        char keyParent = 'E';
        Node parent = findParent(root, keyParent);
        System.out.println("Parent of " + keyParent + " = " + (parent != null ? parent.data : "NULL"));

        // Siblings
        char keySibling = 'D';
        System.out.print("Siblings of " + keySibling + " = ");
        printSiblings(root, keySibling);

        // Ancestors
        char keyAncestor = 'J';
        System.out.print("Ancestors of " + keyAncestor + " = ");
        boolean found = printAncestors(root, keyAncestor);
        if (!found) System.out.print("Not found");
        System.out.println();

        // Descendants
        char keyDesc = 'B';
        System.out.print("Descendants of " + keyDesc + " = ");
        printDescendants(root, keyDesc);

        // Subtree
        char keySubtree = 'E';
        System.out.print("Subtree of " + keySubtree + " = ");
        printSubtree(root, keySubtree);

        // Neighbours
        char keyNeighbour = 'E';
        System.out.print("Neighbours of " + keyNeighbour + " = ");
        printNeighbours(root, keyNeighbour);
    }
}
