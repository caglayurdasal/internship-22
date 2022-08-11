import java.io.*;
import java.util.*;

public class readDatabase {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean isInFile(String userMail) {
        try (FileReader database = new FileReader("database.txt"); // Create a new file instance
             BufferedReader br = new BufferedReader(database)) {           // Create buffering character input stream
            String mail = br.readLine();
            while (mail != null) {  // Read the file until last line, unless user mail is found
                if (mail.contains(userMail)) {
                    System.out.println("Welcome, " + userMail);
                    return true;
                }
                mail = br.readLine();   // Keep reading the file if current line is different from the user mail
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
