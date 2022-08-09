import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter userInput: ");
        int userInput = scanner.nextInt();

        int primeCounter = 0;
        int currentNumber = 1;  // Current number being primality checked
        while (primeCounter != userInput) {
            boolean checkPrime = true;
            currentNumber++;
            for (int i = 2; i < currentNumber; i++) {
                if (currentNumber % i == 0) {
                    checkPrime = false;
                    break;
                }
            }
            if (checkPrime) {
                primeCounter++;
            }
        }

        System.out.println(userInput + ". prime: " + currentNumber);
    }
}
