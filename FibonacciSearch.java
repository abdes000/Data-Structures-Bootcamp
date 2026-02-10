
public class FibonacciSearch {

    static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib2 + fib1;

        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib2 + fib1;
        }
        int offset = -1;
        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);
            if (arr[i] == key) {
                return i; 
            }else if (arr[i] < key) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            }
        }
        if(fib1 == 1 && offset + 1 < n && arr[offset + 1]==key)
            return offset + 1;

        return -1;
    }
    public static void main(String[] args) {
    int[] arr = {10, 20, 30, 40, 50, 60, 70};
    int key = 40;
    System.out.println(fibonacciSearch(arr, key));
    }
}
