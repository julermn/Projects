import java.util.Scanner;//For input data

public class E {
    public static void main(String[] args) {
        // Processing user input
        System.out.println("Enter a decimal place for generating E up to:");
        int arg = 0;
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number! Try again:");
            scanner.next();
        }
        arg = scanner.nextInt();
        while (arg > 15) {
            // There is rounding to the 15 decimal place,
            // because double may contains only 15 places
            System.out.println("Decimal place should be less or equals 15! Try again:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number! Try again:");
                scanner.next();
            }
            arg = scanner.nextInt();
        }
        scanner.close();
        long dec = (long) Math.pow(10, arg);
        double E = Math.floor(Math.E * dec) / dec;
        System.out.println(E);
    }
}