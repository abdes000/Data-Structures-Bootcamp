
import java.util.Scanner;

public class AddLastDigitsOfNumbers {

    public static int addLastDigitsOfNumbers(int num1, int num2) {
        int temp1 = num1 % 10;
        int temp2 = num2 % 10;

        int digit1 = Math.abs(temp1);
        int digit2 = Math.abs(temp2);

        int sum = digit1 + digit2;

        return sum;

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        scanner.close();
        System.out.println("Sum of last digits of the given two numbers " + num1 + " and " + num2 + " is: " + addLastDigitsOfNumbers(num1, num2));
    }
}
