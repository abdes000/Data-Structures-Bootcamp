
import java.util.Scanner;

public class LinearSearch {

    public static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter element to search: ");
        int key = scanner.nextInt();
        int result = linearSearch(arr, n, key);
        if (result == -1) {
            System.out.println("Element not found!"); 
        }else {
            System.out.println("Element found at position: " + result);
        }
        scanner.close(); 
    }
}
