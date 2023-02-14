import java.util.Scanner;//For input data

public class Factorial1 {
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
        System.out.println(factorial(n));
    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}