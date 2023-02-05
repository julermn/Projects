import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NextPrime {
    public static void main(String[] args) {

        Set<Integer> setOfPrimes = new HashSet<>();
        setOfPrimes.add(1);
        setOfPrimes.add(2);
        setOfPrimes.add(3);
        setOfPrimes.add(5);
        setOfPrimes.add(7);
        setOfPrimes.add(11);
        setOfPrimes.add(13);
        int nextPrime = 1;

        // Processing user input
        System.out.println("Do you want to get next prime number?[Y/N]:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        while (!s.equalsIgnoreCase("n")) {
            if (s.equalsIgnoreCase("y")) {
                // Output next prime number
                System.out.println(nextPrime);
                // And finding next prime number
                for (int i = nextPrime + 1;; ++i) {
                    if (isPrime(setOfPrimes, i)) {
                        nextPrime = i;
                        break;
                    }
                }
                s = scanner.next();
            } else {
                System.out.println("Input must be a symbol 'Y' or 'N'. Try again:");
                s = scanner.next();
            }
        }
        scanner.close();
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
