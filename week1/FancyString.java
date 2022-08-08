import java.util.Scanner;

public class FancyString {
    public static String makeFancy(String str) {
        String fancy = "";
        char[] counter = new char[127];  // Keeps track of count of each letter in ASCII order.
        for (int i = 0; i < str.length(); i++) {
            // Remove remaining consecutive repeating letters once count is 3
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                counter[str.charAt(i)]++;
                if (counter[str.charAt(i)] < 3) {
                    fancy += str.charAt(i);
                }
            } else {
                if (counter[str.charAt(i)] < 2) {
                    fancy += str.charAt(i);
                }
                counter[str.charAt(i)] = 0;
            }
        }
        return fancy;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = scanner.next();
        System.out.print("=> " + makeFancy(userString));

    }
}
