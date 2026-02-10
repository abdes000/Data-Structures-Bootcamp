class Node {
    int data;
    Node next;
    Node(int new_data){
        this.data = new_data;
        this.next = null;
    }
}
public class SinglyLinkedList {
    public static void traverseList(Node head){
        while(head != null){
            System.out.println(head.data);
            if(head.next != null){
                System.out.print("->");
                head = head.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        
        // Node temp = head;
        // while(temp != null){
        //     System.out.print(temp.data + " ");
        //     temp = temp.next;
        // }

        traverseList(head);
    }
}
