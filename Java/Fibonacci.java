import java.util.Scanner;//For input data

public class Fibonacci {
    public static void main(String[] args) {
        // Processing user input
        System.out.println("Enter a number for Fibonacci sequence:");
        Scanner scanner = new Scanner(System.in);
        long n = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number! Try again:");
            scanner.next();
        }
        n = scanner.nextInt();
        while (n > 92 || n < 0) {
            // Program will generate a Fibonacci sequence to number n
            // If n is greater than 92, that program will fail, because "long" will overflow
            System.out.println("Decimal place should be more 0 and less or equals 92! Try again:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number! Try again:");
                scanner.next();
            }
            n = scanner.nextInt();
        }
        scanner.close();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n >= 1) {
            System.out.println(1);
        }
        long count = n - 1;
        long buf = 0;
        long f1 = 0;
        long f2 = 1;
        while (count > 0) {
            buf = f2;
            f2 += f1;
            System.out.println(f2);
            f1 = buf;
            --count;
        }
    }
}