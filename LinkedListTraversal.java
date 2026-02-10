// Define a simple Node class

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTraversal {
    Node head;

    // Method to traverse iteratively
    public void traverseIterative() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // move to next node
        }
    }

    public static void main(String[] args) {
        LinkedListTraversal list = new LinkedListTraversal();
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);

        System.out.println("Iterative Traversal:");
        list.traverseIterative();
    }
}



public void traverseRecursive(Node node) {
    if (node == null) {
        return; // base case
    }
    System.out.print(node.data + " ");
    traverseRecursive(node.next); // recursive call
}


System.out.println("\nRecursive Traversal:");
list.traverseRecursive(list.head);
