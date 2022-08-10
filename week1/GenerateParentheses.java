import java.util.*;

public class GenerateParentheses {
    public static List<String> trackParentheses(int opening, int closing, int n) {
        List<String> parentheses = new ArrayList<String>();
        String pair = "";
        if (opening == closing && opening == n && closing == n) {
            parentheses.add(pair); // Add all generated parentheses pairs to resulting list
            return parentheses;
        }
        if (opening < n) {
            pair += "(";
            trackParentheses(opening + 1, closing, n);
        }
        if (closing < n) {
            pair += ")";
            trackParentheses(opening, closing + 1, n);
        }
        return parentheses;
    }

    public static List<String> returnParenthesis(int n) {
        int opening = 0, closing = 0;
        return trackParentheses(opening, closing, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of parentheses: ");
        int numParentheses = sc.nextInt();
        System.out.println(returnParenthesis(numParentheses));
    }
}
