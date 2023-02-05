import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactorization {
    public static void main(String[] args) {
        // Processing user input
        System.out.println("Enter N:");
        Scanner scanner = new Scanner(System.in);
        long n = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number! Try again:");
            scanner.next();
        }
        n = scanner.nextInt();

        while (n > 2147483647 || n < 0) {
            // Program will generate prime factorization for number n
            // If n is greater than 2147483647, that program will fail, because "int" will
            // overflow
            System.out.println("Decimal place should be more 0 and less or equals 2147483647! Try again:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number! Try again:");
                scanner.next();
            }
            n = scanner.nextInt();
        }
        scanner.close();
        // Output user prime factorizations for n
        System.out.println("Prime factorizations for " + n);
        if (n == 0) {
            System.out.println(0);
        }

        Set<Integer> setOfPrimes = new HashSet<>();
        setOfPrimes.add(1);
        setOfPrimes.add(2);
        setOfPrimes.add(3);
        setOfPrimes.add(5);
        setOfPrimes.add(7);
        setOfPrimes.add(11);
        setOfPrimes.add(13);
        int s = (int) Math.sqrt(n);
        for (int i = 1; i <= s; ++i) {
            if (isPrime(setOfPrimes, i) && n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(Set<Integer> setOfPrimes, int p) {
        if (p <= 3) {
            return true;
        }
        int s = (int) Math.sqrt(p);
        for (int i = 2; i <= s; ++i) {
            if (!setOfPrimes.contains(i)) {
                if (!isPrime(setOfPrimes, i)) {
                    continue;
                }
            }
            if (p % i == 0) {
                return false;
            }
        }
        setOfPrimes.add(p);
        return true;
    }
}
