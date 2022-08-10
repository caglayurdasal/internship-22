import java.util.*;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        List<Integer> intParts = new ArrayList<Integer>();
        String newNum = "";
        int remainder, numDigits = 0;
        while (num > 0) {
            remainder = num % 10;
            intParts.add((int) (remainder * Math.pow(10, numDigits)));
            numDigits++;
            num /= 10;
        }
        System.out.println(intParts);
        /* Thresholds:
         *  1-5-10-50-100-500-1000
         */

        while (intParts.size() != 0) {
            int lastIndex = intParts.get(intParts.size() - 1);
            if (lastIndex >= 900) {
                if (lastIndex == 900) {
                    newNum += "CM";
                } else {
                    while (lastIndex > 0) {
                        newNum += "M";
                        lastIndex -= 100;
                    }
                }

                intParts.remove(lastIndex);
            } else if (lastIndex >= 500) {
                if (lastIndex == 400) {
                    newNum += "CD";
                } else {
                    while (lastIndex > 0) {
                        newNum += "D";
                        lastIndex -= 100;
                    }
                intParts.remove(lastIndex);
            }
        }
//        String[] intPartsArray=intParts.toArray(new String[intParts.size()]);
//
//        while(intPartsArray.length != 0){
//            if (intParts[intPartsArray.length-1] >)
//        }

        return "all iz wel.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = scanner.nextInt();
        System.out.println(intToRoman(num));
    }
}
