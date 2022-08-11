import java.io.*;
import java.util.*;

public class readDatabase {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean isInFile(String userMail) {
        try (FileReader database = new FileReader("database.txt");
             BufferedReader br = new BufferedReader(database)) {
            String mail = br.readLine();
            while (mail != null) {
                if (mail.contains(userMail)) {
                    System.out.println("Welcome, " + userMail);
                    return true;
                }
                mail = br.readLine();
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your e-mail address: ");
        String mailAddress = scanner.nextLine();
        while (!isInFile(mailAddress)) {
            System.out.println("You have entered an invalid e-mail address. Please try again.");
            mailAddress = scanner.nextLine();
        }

    }
}
