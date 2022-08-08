import java.util.Scanner;

public class NeedleInHaystack {
    public static int getIndex(String haystack, String needle) {
        int firstOccurrence = -1;
        boolean check = true;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                firstOccurrence = i;

                for (int j = 0; j < needle.length(); j++) {
                    if (!(haystack.charAt(i) == needle.charAt(j))) {
                        check = false;
                    }
                    j++;
                }
                if (check) {
                    return firstOccurrence;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Haystack: ");
        String haystack = scanner.next();
        System.out.print("Needle: ");
        String needle = scanner.next();

        System.out.print("=> " + getIndex(haystack, needle));
    }
}
