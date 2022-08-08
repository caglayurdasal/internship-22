import java.util.Scanner;

public class FirstUniqueChar {
    public static int getFirstUnique(String str) {

        int[] counter = new int[128];  // Keeps track of character count in alphabetical order
        for (int i = 0; i < str.length(); i++) {
            counter[str.charAt(i)]++;   // Increment count at index of current character
        }
        for (int i = 0; i < str.length(); i++) {
            if (counter[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = scanner.next();

        System.out.print("First non-repeating character: '" + userString.charAt(getFirstUnique(userString)) + "'");
    }
}