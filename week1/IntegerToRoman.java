import java.util.*;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] numsInt = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] numsRoman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String newNum="";
        List<Integer> intParts = new ArrayList<Integer>();
        int remainder, numDigits = 0;
        while (num > 0) {
            remainder = num % 10;
            intParts.add((int) (remainder * Math.pow(10, numDigits)));
            numDigits++;
            num /= 10;
        }
        System.out.println(intParts);
        for (int i = intParts.size() - 1; i >= 0; i--) {
            if(intParts.get(i)!=0){
                for(int j=0;j<numsInt.length;j++){
                    if (numsInt[j]==intParts.get(i)){
                        newNum+=numsRoman[j];
                    }
                }
            }
        }
        return newNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = scanner.nextInt();
        System.out.println(intToRoman(num));
    }
}
