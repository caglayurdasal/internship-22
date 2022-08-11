import java.io.*;
import java.util.*;

public class userDatabase {
    public static int isRegistered(String userMail) {
        int lineNumber = 0;
        try (FileReader database = new FileReader("database.txt"); // Create a new file instance
             BufferedReader br = new BufferedReader(database)) {           // Create buffering character input stream
            String mail = br.readLine();
            while (mail != null) {  // Read the file until last line, unless user mail is found
                lineNumber++;
                if (mail.contains(userMail)) {
                    return lineNumber;
                }
                mail = br.readLine();   // Keep reading the file if current line is different from the user mail
            }
            return -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserName(int lineNumber) {
        String userName = "";
        try {
            FileInputStream fs = new FileInputStream("database.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int i = 1; i < lineNumber; i++) {
                br.readLine();
            }
            int i;
            char ch;

            while ((i = br.read()) != ';') {
                ch = (char) i;  // Convert integer to character
                userName += ch; // Add character to username string
            }
            return userName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        String mailAddress;
        boolean isValid = false;
        int userIndex, userOption;
        while (!isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your e-mail address: ");
            mailAddress = scanner.nextLine();
            if ((userIndex = isRegistered(mailAddress)) == -1) {
                System.out.println("You have entered an invalid e-mail address. Please try again.");
            } else {
                System.out.println(userIndex);
                System.out.println("Welcome, " + getUserName(userIndex));
                isValid = true;
                System.out.println("1. Log out");
                System.out.println("2. Change password");
                userOption=Integer.parseInt(scanner.next());
                if (userOption==1){
                    isValid=false;
                }
//                else{
//
//                }

            }
        }


    }
}
