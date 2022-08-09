/**
 * This program finds checks whether there is a common prefix in an array of strings.
 * If so, it displays the prefix.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int lenStrs = strs.length;
        String longestPrefix = "";

        // Iterate through first string to compare character by character
        for (int i = 0; i < strs[0].length(); i++) {
            boolean check = false; // Checks if current character is common in all strings

            // Iterate through strings in the array to find common prefix
            for (String str : strs) {
                // If current character is common in all strings, add it to longestPrefix
                check = i < str.length() - 1 && str.charAt(i) == strs[0].charAt(i);
            }
            // If current character is not common, return longestPrefix, else append it to currentLongestPrefix
            if (!check) {
                return longestPrefix;
            } else {
                longestPrefix += strs[0].charAt(i);
            }
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = {"cir", "car"};
        System.out.println(longestCommonPrefix(strs3));

        String[] strs4 = {"flower", "fkow"};
        System.out.println(longestCommonPrefix(strs4));
    }
}
