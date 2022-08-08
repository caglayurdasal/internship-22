import java.util.Scanner;

/** This program takes user input as integer n, then finds n. prime number.  */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = userInput.nextInt();

        int primeCounter = 0;
        int currentNumber = 1;  // Current number being primality checked
        while (primeCounter != n) {
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

        System.out.println(n + ". prime: " + currentNumber);
    }
}
