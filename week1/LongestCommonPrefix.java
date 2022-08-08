public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int lenStrs = strs.length;
        String longestPrefix = "";

        // Iterate through first string to compare character by character
        for (int i = 0; i < strs[0].length(); i++) {
            boolean check = false; // Checks if current character is common in all strings

            // Iterate through strings in the array to find common prefix
            for (int j = 0; j < lenStrs; j++) {

                // If current character is common in all strings, add it to longestPrefix
                if (i < strs[j].length() - 1 && strs[j].charAt(i) == strs[0].charAt(i)) {
                    check = true;
                } else {
                    check = false;
                }
            }
            // If current character is not commmon, return longestPrefix, else append
            // it to currentLongestPrefix
            if (!check) {
                return longestPrefix;

            } else {
                longestPrefix += strs[0].charAt(i);
            }
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = { "cir", "car" };
        System.out.println(longestCommonPrefix(strs3));

        String[] strs4 = { "flower", "fkow" };
        System.out.println(longestCommonPrefix(strs4));
    }
}
