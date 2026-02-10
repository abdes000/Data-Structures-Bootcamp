
public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; 
            }else if (arr[mid] < key) {
                low = mid + 1; 
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int key = 50;
        int result = binarySearch(arr, key);
        if(result == -1)
            System.out.println("Element is not present in array.");
        else
            System.out.println("Element is present at index " + result);
    }
}
