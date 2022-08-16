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

    public static String getPassword(int lineNumber) {
        String userPassword = "";
        try {
            FileInputStream fs = new FileInputStream("database.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            // move to the line where user is saved
            for (int i = 1; i < lineNumber; i++) {
                br.readLine();
            }

            int i;
            char ch;

            for (int j = 0; j < 2; j++) {
                do {
                    i = br.read();
                } while (i != ';');
            }
            // check userPassword
            userPassword += br.readLine();
            System.out.println(userPassword);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userPassword;
    }

    public static void changePassword(File database, String userPassword, int lineNumber) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new password: ");
        String newPassword = sc.next();
        String currentLine;
        int tempLines = 0;

        try {
            FileWriter tempWriter = new FileWriter("temp.txt");
            FileInputStream fs = new FileInputStream("database.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            // move to the line where user is saved
            for (int i = 1; i < lineNumber; i++) {
                currentLine = br.readLine();
                tempWriter.write(currentLine);
                tempLines++;
                tempWriter.write('\n');
            }
            int i;
            char ch;

            for (int j = 0; j < 2; j++) {
                do {
                    i = br.read();
                    tempWriter.write(i);
                } while (i != ';');
            }
            for (int j = 0; j < newPassword.length(); j++) {
                tempWriter.write(newPassword.charAt(j));
            }
            tempWriter.write('\n');

            while (br.readLine() != null) {
                currentLine = br.readLine();
                tempWriter.write(currentLine);
            }
            tempWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedReader getDatabaseBufferReader(){
        FileInputStream fs = new FileInputStream("database.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        return br;
    }

    public static void main(String[] args) {

        String mailAddress, userPassword, attemptedPassword;
        boolean isValid = false;
        int userIndex, userOption;
        while (!isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your e-mail address: ");
            mailAddress = scanner.next();
            if ((userIndex = isRegistered(mailAddress)) == -1) {
                System.out.println("You have entered an invalid e-mail address. Please try again.");
            } else {
                userPassword = getPassword(userIndex);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your password: ");
                attemptedPassword = sc.nextLine();
                if (attemptedPassword.equals(userPassword)) {
                    System.out.println("Welcome, " + getUserName(userIndex));
                    isValid = true;
                    System.out.println("1. Log out");
                    System.out.println("2. Change password");
                    userOption = Integer.parseInt(sc.next());
                    if (userOption == 1) {
                        isValid = false;
                    } else {
                        File database = new File("database.txt");
                        File temp = new File("temp.txt");
                        changePassword(database, userPassword, userIndex);
                        System.out.println("Password is changed.");
                        //Delete the original file
                        if (!database.delete()) {
                            System.out.println("Could not delete file");
                            return;
                        }

                        //Rename the new file to the filename the original file had.
                        if (!temp.renameTo(database))
                            System.out.println("Could not rename file");
                    }
                } else {
                    System.out.println("Wrong password.");
                    isValid = true;
                }
            }
        }
    }
}
