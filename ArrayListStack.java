
import java.util.ArrayList;

public class ArrayListStack {

    ArrayList<Integer> arr = new ArrayList<>();

    void push(int x) {
        arr.add(x);
    }

    int pop() {
        if (arr.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return val;
    }

    int peek() {
        if (arr.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr.get(arr.size() - 1);
    }

    boolean isEmpty() {
        return arr.isEmpty();
    }

    int size() {
        return arr.size();
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
        ArrayListStack st = new ArrayListStack();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        
        System.out.println(st.toString());

        System.out.println("Popped: " + st.pop());
        System.out.println("Top element: " + st.peek());
        System.out.println("Stack isEmpty: " + (st.isEmpty() ? "True" : "False"));
        System.out.println("Current Size: " + st.size());
    }
}
