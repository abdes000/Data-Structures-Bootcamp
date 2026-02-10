class Node {
    int head;
    Node next;
    String data;
    public Node(int new_data){
        head = new_data;
        this.next = null;
    }
}

// class NodeDeletions {

// }
public class SinglyLinkedListOperations {
        Node head;
    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
    }
    void insertAtMiddle(int data, int position){
        Node newNode = new Node(data);

        if(position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;

        for(int i = 1; i < position; i++){
            if(temp == null){
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void display() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        SinglyLinkedListOperations list = new SinglyLinkedListOperations();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.display();
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.display();
        list.insertAtMiddle(25, 2);
        list.display();
        
    }
}
