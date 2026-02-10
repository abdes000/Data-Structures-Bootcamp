

public class ArrayQueue {
    int[] arr;
    int front, rear, size, capacity;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    boolean isFull() {
        return size == capacity;
    }
    boolean isEmpty() {
        return size == 0;
        }
    void enqueue(int x){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        rear++;
        arr[rear]=x;
        size++;
        System.out.println(x + " ");
    }

    int dequeue(int x) {
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        int removed = arr[front];
        front++;
        size--;
        arr[front] = x;
        return removed;
        
    }

    int peek() {
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    void display() {
        System.out.println("Queue Elements: ");
        for(int i = 0; i <= rear; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();
        System.out.println("Dequeued: " + q.dequeue(1));
        q.display();
        System.out.println("Front Element: " + q.peek());
    }
}
