class SinglyDeletions {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // ---------------- INSERT METHODS ----------------

    // Insert at end (for building list easily)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // ---------------- DELETE METHODS ----------------

    // 1) Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        head = head.next;
        System.out.println("Deleted from beginning.");
    }

    // 2) Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        // If only one node
        if (head.next == null) {
            head = null;
            System.out.println("Deleted from end.");
            return;
        }

        Node temp = head;

        // Traverse till second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        System.out.println("Deleted from end.");
    }

    // 3) Delete from specific position (1-based index)
    public void deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        // If position is 1, delete first node
        if (pos == 1) {
            head = head.next;
            System.out.println("Deleted from position " + pos);
            return;
        }

        Node temp = head;

        // Move temp to (pos-1)th node
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        // Invalid position check
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position. Cannot delete.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Deleted from position " + pos);
    }

    // ---------------- DISPLAY METHOD ----------------

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Insert values
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("Initial List:");
        list.display();

        // Delete from beginning
        list.deleteFromBeginning();
        list.display();

        // Delete from end
        list.deleteFromEnd();
        list.display();

        // Delete from specific position
        list.deleteFromPosition(2);
        list.display();
    }
}
