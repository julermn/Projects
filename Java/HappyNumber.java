import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        // Processing user input
        System.out.println("Enter a number:");
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number! Try again:");
            scanner.next();
        }
        n = scanner.nextInt();
        while (n > 1000000 || n <= 0) {
            // Program will generate first n Happy numbers
            // If n is greater than 1000000, that program will fail, because "int" will
            // overflow
            System.out.println("This program can generate only up to 1 000 000 happy numbers! Try again:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number! Try again:");
                scanner.next();
            }
            n = scanner.nextInt();
        }
        scanner.close();

        // Print n first happy numbers
        int count = 0;
        for (int i = 1;; ++i) {
            // if (isHappy(i)) {
            if (isHappyRec(i)) {
                System.out.println(i);
                ++count;
                if (count == n) {
                    break;
                }
            }
        }
    }

    // Without recursion
    public static boolean isHappy(int n) {
        int sum = 0;
        int len = String.valueOf(n).length();
        while (n != 1) {
            len = String.valueOf(n).length();
            for (int i = 1; i <= len; ++i) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            sum = 0;
            if (n == 89 || n == 9) {
                return false;
            }
        }
        return true;
    }

    // With recursion
    public static boolean isHappyRec(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 89 || n == 9) {
            return false;
        }
        int sum = 0;
        int len = String.valueOf(n).length();
        for (int i = 1; i <= len; ++i) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(sum) ? true : false;
    }
}