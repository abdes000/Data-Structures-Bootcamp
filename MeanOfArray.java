
import java.util.Scanner;
public class MeanOfArray {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no of array elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        double mean;
        for(int i = 0; i <= size - 1; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        mean = sum / (float) size;
        System.out.println("The mean of the given elements = " + mean);
        scanner.close();
    }
}
