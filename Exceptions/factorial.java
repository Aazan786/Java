import java.util.Scanner;

class NegativeNumberFactorialException extends Exception {
    public NegativeNumberFactorialException(int num) {
        super("Enter a positive number to compute factorial: " + num);
    }

    public String toString() {
        return "NegativeNumberFactorialException: " + getMessage();
    }
}

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter a positive number:");
                int num = Integer.parseInt(scanner.nextLine());

                if (num <= 0) {
                    throw new NegativeNumberFactorialException(num);
                }

                int fact = 1;
                for (int i = 1; i <= num; i++) {
                    fact *= i;
                }
                System.out.println("Factorial of " + num + " is: " + fact);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive number.");
            } catch (NegativeNumberFactorialException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
