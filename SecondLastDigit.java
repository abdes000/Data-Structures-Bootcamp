
import java.util.Scanner;

public class SecondLastDigit {

    public static int secondLastDigit(int num) {
        if (num % 10 == num) {
            return -1;
        }
        int div = num % 100;
        int temp = div / 10;
        int result = Math.abs(temp);
        return result;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a num: ");
        int num = scanner.nextInt();
        scanner.close();
        System.out.println("Second Last Digit of the number " + num + " is: " + secondLastDigit(num));
    }
}
