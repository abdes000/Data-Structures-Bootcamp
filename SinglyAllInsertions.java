class SinglyAllInsertions {
    Node head;
    // 1) Insert at the Beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // new node points to old head
        head = newNode;       // head becomes new node
    }
    // 2) Insert at the End
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) { // go till last node
            temp = temp.next;
        }

        temp.next = newNode; // last node points to new node
    }

    // 3) Insert in the Middle (After a given position)
    // Example: position = 2 means insert after 2nd node
    void insertAtMiddle(int data, int position) {
        Node newNode = new Node(data);

        // If inserting at beginning (position 0)
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;

        // Move temp to (position-1)th node
        for (int i = 1; i < position; i++) {
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }

        // If temp becomes null
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        // Insert new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Print Linked List
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Driver Code
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.display();  // 20 -> 10 -> null
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.display();  // 20 -> 10 -> 30 -> 40 -> null
        list.insertAtMiddle(25, 2); // Insert after position 2
        list.display();  // 20 -> 10 -> 25 -> 30 -> 40 -> null
    }
}
