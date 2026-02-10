import java.util.Arrays;

public class QuickSortMiddle {
    int partition(int[] arr, int low, int high) {
        int pivot = arr[(low+high)/2];
        while(low<=high){
            while(arr[low]<pivot){
                low++;
            }
            while(arr[high]>pivot){
                high--;
            }
            if(low <= high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
    void recursiveSort(int[] arr, int low, int high){
        int pi = partition(arr, low, high);

        if(low < pi -1){
            recursiveSort(arr, low, pi-1);
        }
        if(pi < high) {
            recursiveSort(arr, pi, high);
        }
    }

    void printArray(int[] arr) {
            System.out.println(Arrays.toString(arr));

    }
    public static void main(String[] args) {
        int[] arr = {15, 9, 7, 13, 12, 16, 4, 18, 11};
        int len = arr.length;
        QuickSortMiddle qsm = new QuickSortMiddle();
        qsm.recursiveSort(arr, 0, len-1);
        qsm.printArray(arr);
    }
}
