import java.util.*;

public class GenerateParentheses {
    public static String pair = "";
    public static List<String> parentheses = new ArrayList<String>();
    public static List<String> trackParentheses(int opening, int closing, int n) {


        if (opening == closing && opening == n && closing == n) {
            parentheses.add(pair); // Add all generated parentheses pairs to resulting list
            return parentheses;
        }
        if (opening < n) {
            pair += "(";
            trackParentheses(opening + 1, closing, n);
            pair = pair.substring(0, pair.length() - 1);
        }
        if (closing < n) {
            // ilk elemanı kontrol et
            if (pair.length()!=0 && closing < opening){
                pair += ")";
                trackParentheses(opening, closing + 1, n);
                pair = pair.substring(0, pair.length() - 1);
            }

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
