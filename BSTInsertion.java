

public class BSTInsertion {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //Recursive insert function
    static Node insert(Node root, int value) {
        //If tree is empty, create new node
        if (root == null ) {
            return new Node(value);
        }
        if (value < root.data){
            root.left =insert(root.right, value);
        } else if(value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);
        System.out.println("Inorder traversal of BST: ");
        inorder(root);
    }
}
