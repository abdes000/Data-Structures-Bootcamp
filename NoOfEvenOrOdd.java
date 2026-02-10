
import java.util.Scanner;

public class NoOfEvenOrOdd {

    public static int OddOrEven(int a, int b, int c, int d, int e, String type) {
        int count = 0;
        if (type.equals("ODD")) {
            if (a % 2 != 0) {
                count++;
            }
            if (b % 2 != 0) {
                count++;
            }
            if (c % 2 != 0) {
                count++;
            }
            if (d % 2 != 0) {
                count++;
            }
            if (e % 2 != 0) {
                count++;
            }
        } else if (type.equals("EVEN")) {
            if (a % 2 == 0) {
                count++;
            }
            if (b % 2 == 0) {
                count++;
            }
            if (c % 2 == 0) {
                count++;
            }
            if (d % 2 == 0) {
                count++;
            }
            if (e % 2 == 0) {
                count++;
            }
        } else {
            System.out.println("Invalid type!!!");
        }
        return count;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("num1 = ");
        int num1 = scanner.nextInt();
        System.out.print("num2 = ");
        int num2 = scanner.nextInt();
        System.out.print("num3 = ");
        int num3 = scanner.nextInt();
        System.out.print("num4 = ");
        int num4 = scanner.nextInt();
        System.out.print("num5 = ");
        int num5 = scanner.nextInt();
        System.out.print("type = ");
        String type = scanner.next().toUpperCase();
        // int a, b = scanner.nextInt();
        scanner.close();
        System.out.print(OddOrEven(num1, num2, num3, num4, num5, type));
    }
}
