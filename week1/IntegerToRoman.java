import java.util.*;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] numsInt = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] numsRoman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String newNum = "";

        for(int i=numsInt.length-1;i>=0;i--){
            while(num > numsInt[i]){
                num-=numsInt[i];
                newNum += numsRoman[i];
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
