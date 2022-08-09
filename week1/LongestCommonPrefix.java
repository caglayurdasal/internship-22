/**
 * This program checks whether there is a common prefix in an array of strings.
 * If so, it displays the prefix.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        boolean check = false;  //
        // Find the shortest string
        String shortest = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortest.length()) {
                shortest = strs[i];
            }
        }

        // Traverse the letters to find the longest common prefix
        for (int i = 0; i < shortest.length(); i++) {
            char currentLetter = shortest.charAt(i);

            // Traverse the strings to compare letter at index i
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) == currentLetter) {
                    check = true;
                } else {
                    return longestPrefix;
                }
            }
            if (check) {
                longestPrefix += currentLetter;
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
