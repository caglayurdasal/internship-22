/**
 * This program converts uppercase letters in a string to lowercase, if any.
 */
public class ToLowerCase {
    public static String convertLowerCase(String str) {
        
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (65 <= strArray[i] && strArray[i] <= 90) {
                strArray[i] += 32;
            }
        }
        return new String(strArray);
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(convertLowerCase(s1));

        String s2 = "here";
        System.out.println(convertLowerCase(s2));

        String s3 = "LOVELY";
        System.out.println(convertLowerCase(s3));
    }
}
