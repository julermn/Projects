import java.util.Scanner;//For input data

public class Factorial2 {
    public static void main(String[] args) {
        // Processing user input
        System.out.println("Enter a number for factorial:");
        Scanner scanner = new Scanner(System.in);
        long n = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number! Try again:");
            scanner.next();
        }
        n = scanner.nextInt();
        while (n > 20 || n < 0) {
            // Program will generate a Fibonacci sequence to number n
            // If n is greater than 20, that program will fail, because "long" will overflow
            System.out.println("Decimal place should be more 0 and less or equals 20! Try again:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number! Try again:");
                scanner.next();
            }
            n = scanner.nextInt();
        }
        scanner.close();
        long f = 1;
        for (int i = 1; i <= n; ++i) {
            f *= i;
        }
        System.out.println(f);
    }
}