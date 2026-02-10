import java.util.*;

class TreeTerminology {

    // Node class (Linked representation)
    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    // ---------- TREE CREATION ----------
    public static Node createTree() {

        // Creating nodes
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

        // Root is A
        return A;
    }

    // ---------- LEVEL OF A NODE ----------
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

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Node root = createTree();

        System.out.println("Tree Created Successfully!");
        System.out.println();

        // 1) Root Node
        System.out.println("1) Root Node: " + root.data);


        // 3) Leaf Nodes
        System.out.print("4) Leaf Nodes: ");
        printLeafNodes(root);
        System.out.println();

        // 4) Internal Nodes
        System.out.print("5) Internal Nodes: ");
        printInternalNodes(root);
        System.out.println();

        // 5) Level of Node
        char key = 'I';
        int level = findLevel(root, key, 0);
        System.out.println("6) Level of node " + key + " = " + level);

    }
}
