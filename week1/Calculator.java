import java.util.Scanner;

public class Calculator {
    public static double calculateResult(String operation, double num1, double num2) {
        switch (operation) {
            case "a":
                return num1 + num2;
            case "s":
                return num1 - num2;
            case "m":
                return num1 * num2;
            case "d":
                if (num2 == 0.0) {
                    System.out.print("Divisor can not be 0. ");
                    return -1;
                }
                return num1 / num2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation;
        String prompt;
        double num1, num2;
        System.out.println("Welcome!");
        do {
            System.out.println("Addition: 'a', Subtraction: 's', Multiplication: 'm', Division: 'd'");
            operation = scanner.next();

            if (operation.equals("a") || operation.equals("s") || operation.equals("m") || operation.equals("d")) {

                while (true) {
                    System.out.println("Enter num1 and num2:");
                    try{
                        num1 = Double.parseDouble(scanner.next());
                        num2 = Double.parseDouble(scanner.next());
                        break;
                    } catch (NumberFormatException ignore){
                        System.out.println("Invalid input! Please only enter numerical values.");
                    }
                }

                double result = calculateResult(operation, num1, num2);
                if (result == -1) {
                    System.out.println("Invalid entry!");
                } else {
                    System.out.println("\t=> " + result);
                }
            } else {
                System.out.println("Invalid entry! Please only enter a,s,m or d.");
            }

            System.out.println("Would you like to start over? Press any key to exit or enter \"yes\" to continue.");
            prompt = scanner.next();
        } while (prompt.equals("yes"));

        System.out.println("Hasta la vista!");
    }
}
