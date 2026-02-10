class Node {
    int data;
    Node left, right;
    int height;
    Node(int data) {
        this.data = data;
        height = 1;
    }
}
public class AVLTree {
    static int height(Node node){
        return (node == null) ? 0 : node.height;
    }
    static Node getSuccessor(Node curr){
        curr = curr.right;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    static int getBalance(Node node){
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    // LL Rotation Logic (Right Rotation)
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //rotation
        x.right = y;
        y.left = T2;
        //Update heights
        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(y.left), height(x.left));

        return x;
    }

    // RR Rotation Logic (Left Rotation)
    static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        //Rotation
        y.left = x;
        x.right = T2;
        //Update heights
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));
        //Return the new root
        return y;
    }

    static Node insert(Node node, int key) {
        //Normal BST insertion
        if (node == null) 
            return new Node(key);
        if (key < node.data)
            node.left = insert(node.left, key);
        else if(key > node.data)
            node.right = insert(node.right, key);
        else
            return node;
        //Update height
        node.height = 1 + max(height(node.left), height(node.right));
        //Balance factor
        int balance = getBalance(node);
        //4 cases
        //LL
        if(balance>1 && key < node.left.data){
            return rightRotate(node);
        }
        //RR
        if(balance < -1 && key > node.right.data){
            return leftRotate(node);
        }
        //LR
        if (balance > 1 && key > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if(balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    static Node delNode(Node root, int x){
        if(root == null) return root;
        if(root.data > x) {
            root.left = delNode(root.left, x);
        } else if(root.data < x) {
            root.right = delNode(root.right, x);
        } else {
            if(root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
        
        //Node with 2 children
        Node succ = getSuccessor(root);
        root.data = succ.data;
        root.right = delNode(root.right, succ.data);

        return root;
        }

        

    }
    static void inorder(Node root) {
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }


    public static void main(String[] args) {
        Node root = null;
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for(int k : keys) {
            root = insert(root, k);
        }
        System.out.println("Inorder Traversal after AVL Insertion: ");
        inorder(root);
    }

}
