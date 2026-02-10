class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    // ---------------- FORWARD TRAVERSAL ----------------
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------- BACKWARD TRAVERSAL ----------------
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // ---------------- INSERT AT BEGINNING ----------------
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ---------------- INSERT AT END ----------------
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // ---------------- INSERT AT POSITION (1-based) ----------------
    public void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        // If position is greater than length, insert at end
        if (temp == null || temp.next == null) {
            insertAtEnd(data);
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // ---------------- DELETE FROM BEGINNING ----------------
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If only one node
        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // ---------------- DELETE FROM END ----------------
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        // If only one node
        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // ---------------- DELETE FROM POSITION (1-based) ----------------
    public void deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Delete first node
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.next;
        }

        // Invalid position
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        // If last node
        if (temp == tail) {
            deleteFromEnd();
            return;
        }

        // Delete middle node
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert operations
        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);

        dll.displayForward();   // 10 20 30 40
        dll.displayBackward();  // 40 30 20 10

        // Insert at position
        dll.insertAtPosition(25, 3);
        dll.displayForward();   // 10 20 25 30 40

        // Delete from beginning
        dll.deleteFromBeginning();
        dll.displayForward();   // 20 25 30 40

        // Delete from end
        dll.deleteFromEnd();
        dll.displayForward();   // 20 25 30

        // Delete from position
        dll.deleteFromPosition(2);
        dll.displayForward();   // 20 30

        dll.displayBackward();  // 30 20
    }
}
