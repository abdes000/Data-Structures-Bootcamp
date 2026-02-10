import java.util.Scanner;

public class Multiple {
    public static int isMultiple(int a, int b){
        if(a==0 || b==0){
            return 3;
        }

        if(a % b == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        scanner.close();
        System.out.println(isMultiple(num1, num2));
    }
}