import java.util.Scanner;

public class CombineStrings {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        scanner.close();
        int len1 = str1.length();
        int len2 = str2.length();
        
        // StringBuilder sb = new StringBuilder();

        // if( len1 < len2) {
        //     sb.append(str1 + str2 + str1);
        // } else {
        //     sb.append(str2 + str1 + str2);
        // }

        String combinedStr;
        if( len1 < len2) {
            combinedStr = str1 + str2 + str1;
        } else { 
            combinedStr = str2 + str1 + str2;
        }
        System.out.println(combinedStr);
    }
}
