public class ArrayStack {

    // array to store elements;
    private final int[] arr;
    //maximum size of array;
    private final int capacity;
    //index of top element
    private int top;

    //constructor
    public ArrayStack(int cap) {
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        System.out.print("[ ");
        for(int x : arr){
            System.out.print(x + " ");
        }
        return "]";
    }

    public static void main(String[] args) {
        ArrayStack st = new ArrayStack(4);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        
        System.out.println(st.toString());

        System.out.println("Top element: " + st.peek());

        System.out.println("Pop element: " + st.pop());

        System.out.println("Stack isEmpty: " + (st.isEmpty() ? "True" : "False"));
        System.out.println("Stack isFull: " + (st.isFull() ? "True" : "False"));
    }
}
