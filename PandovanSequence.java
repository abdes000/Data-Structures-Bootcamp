
import java.util.Scanner;

public class PandovanSequence {
    public static int Pandovan(int terms) {
        if (terms == 0 || terms == 1 || terms == 2) {
            return 1;
        }
        return Pandovan(terms - 2) + Pandovan(terms - 3);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();
        scanner.close();
        System.out.println("Pandovan Sequence up to " + terms + " elements: \n");
        for (int i = 0; i < terms; i++) {
            System.out.print(Pandovan(i) + " ");
        }
        System.out.println();
    }
}
