import java.util.Scanner;

/**
 * This program checks if parentheses in the given string are balanced
 */
public class CheckParentheses {
    public static boolean checkParentheses(String str) {
        String parentheses = "";

        for (int i = 0; i < str.length(); i++) {
            // If first parentheses is a closing parentheses, string is unbalanced
            if (parentheses.length() == 0 && (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')) {
                return false;
            } else {
                if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                    parentheses += str.charAt(i);
                } else if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
                    if (parentheses.charAt(parentheses.length() - 1) == '(' && str.charAt(i) != ')' ||
                            parentheses.charAt(parentheses.length() - 1) == '{' && str.charAt(i) != '}' ||
                            parentheses.charAt(parentheses.length() - 1) == '[' && str.charAt(i) != ']') {
                        return false;
                    } else {
                        // Remove last open parentheses to check next pair of parentheses
                        parentheses = parentheses.substring(0, parentheses.length() - 1);
                    }
                }
            }
        }
        // If an opening parentheses has no pair, string is unbalanced
        return parentheses.length() == 0;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = userInput.next();

        System.out.println("=> " + checkParentheses(userString));
    }
}
