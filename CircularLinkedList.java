class CircularLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    // ------------------ TRAVERSAL ------------------
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Circular List: ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // -------------- INSERT AT BEGINNING --------------
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        // Find last node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert at beginning
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // --------------- INSERT AT END ------------------
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        // Find last node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert at end
        temp.next = newNode;
        newNode.next = head;
    }

    // -------------- INSERT AT POSITION --------------
    // Position is 1-based indexing
    public void insertAtPosition(int data, int pos) {

        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        // Position 1 = beginning
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        // If list is empty and pos != 1
        if (head == null) {
            System.out.println("List is empty. Only position 1 allowed.");
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;

        // Move to (pos-1)th node
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        // Insert after temp
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ------------- DELETE FROM BEGINNING -------------
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If only one node
        if (head.next == head) {
            head = null;
            return;
        }

        // Find last node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Delete head
        head = head.next;
        temp.next = head;
    }

    // ---------------- DELETE FROM END ----------------
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If only one node
        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;

        // Move to second last node
        while (temp.next.next != head) {
            temp = temp.next;
        }

        // Delete last node
        temp.next = head;
    }

    // -------------- DELETE FROM POSITION --------------
    // Position is 1-based indexing
    public void deleteFromPosition(int pos) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        // Case 1: Delete from beginning
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        int count = 1;

        // Move to (pos-1)th node
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        // If position is out of range
        if (temp.next == head) {
            System.out.println("Position out of range!");
            return;
        }

        // Delete node
        temp.next = temp.next.next;
    }

    // ------------------ MAIN METHOD ------------------
    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();

        // Insert at end
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.display();  // 10 20 30

        // Insert at beginning
        cll.insertAtBeginning(5);
        cll.display();  // 5 10 20 30

        // Insert at position
        cll.insertAtPosition(25, 4);
        cll.display();  // 5 10 20 25 30

        // Delete from beginning
        cll.deleteFromBeginning();
        cll.display();  // 10 20 25 30

        // Delete from end
        cll.deleteFromEnd();
        cll.display();  // 10 20 25

        // Delete from position
        cll.deleteFromPosition(2);
        cll.display();  // 10 25
    }
}
