
import java.util.Scanner;

public class AlternateStringCombiner {

    public static String alternateStringCombiner(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLength = Math.max(len1, len2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxLength - 1; i++) {
            if (i < len1) {
                sb.append(str1.charAt(i));
            }
            if (i < len2) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the first string: ");
        String str2 = scanner.nextLine();
        scanner.close();
        System.out.println("Alternate Combined String: " + alternateStringCombiner(str1, str2));
    }
}
