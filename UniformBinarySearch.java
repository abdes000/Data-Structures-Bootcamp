
public class UniformBinarySearch {

    // public static int uniformBinarySearch(int[] arr, int n, int key) {
    //     int step = n / 2;
    //     int index = step;
    //     while (step > 0) {
    //         if (arr[index] == key) {
    //             return index;
    //         } else if (arr[index] < key) {
    //             index = index + step / 2;
    //         } else {
    //             index = index - step / 2;
    //         }
    //         step = step / 2;
    //     }
    //     return -1;
    // }

    // public static int search(int[] arr, int power, int key) {
    //     int index = power - 1;
    //     while (power > 0) {
    //         if (arr[index] == key) {
    //             return index;
    //         }
    //         if (arr[index] < key) {
    //             index = index + power / 2; 
    //         }else {
    //             index = index - power / 2;
    //         }
    //         power /= 2;
    //     }
    //     return -1;
    // }

    static int uniformBinarySearch(int[] arr, int key){
        int n = arr.length;
        int step = 1;
        while(step<=n){
            step = step * 2;
        }
        step /= 2;
        int index = step - 1;
        while(step>0){
            if(index<0)
                index = 0;
            if(index>=n)
                index = n - 1;
            if(arr[index]==key)
                return index;
            step = step / 2;
            if(key > arr[index])
                index = index + step;
            else
                index = index - step;
            }
            return -1;
    }
        public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 10;
        int result = uniformBinarySearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found!"); 
        }else {
            System.out.println("Element fount at index " + result);
        }
        System.out.println("Element fount at index " + result);

    }
}
