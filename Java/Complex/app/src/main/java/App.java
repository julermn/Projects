public class App {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1, 2);
        int p1 = 3;
        double p2 = 4.3;
        Complex complex2 = new Complex(3, 4);
        Complex two = new Complex(2.0, 0.0);
        Complex complex3 = new Complex(-3, 0.0);

        // Base functions of Complex.class
        System.out.println(complex1.toString());
        System.out.println("Re: " + complex1.getRe());
        System.out.println("Im: " + complex1.getIm());
        System.out.println("Negation: " + Complex.neg(complex1).toString());
        System.out.println("Conjugate: " + Complex.conj(complex1).toString());
        System.out.println();

        // Complex.pow()
        System.out.println(complex1.toString() + " to the " + p1 + " power: " +
                Complex.pow(complex1, p1).toString());
        System.out.println(p2 + " to the " + complex1.toString() + " power: " +
                Complex.pow(p2, complex1).toString());
        System.out.println(complex3.toString() + " to the " + complex1.toString() +
                " power: " + Complex.pow(complex3, complex1).toString());
        System.out.println();

        System.out.println("Complex from constructor: " + complex1.toString());
        System.out.println("Complex from getPolarComplex(): " +
                Complex.getPolarComplex(Complex.abs(complex1), Complex.arg(complex1)).toString());
        System.out.println();

        // Complex.add()
        System.out.println("(" + complex1.toString() + ") + (" + complex2.toString() + ") = "
                + Complex.add(complex1, complex2));
        System.out.println("(" + Complex.neg(complex1).toString() + ") + " + p2 + " = " +
                Complex.add(Complex.neg(complex1), p2));
        System.out.println();

        // Complex.sub()
        System.out.println("(" + complex1.toString() + ") - (" + complex2.toString() + ") = "
                + Complex.sub(complex1, complex2));
        System.out.println("(" + complex1.toString() + ") - " + p2 + " = " +
                Complex.sub(complex1, p2));
        System.out.println(p2 + " - (" + complex1.toString() + ") = " +
                Complex.sub(p2, complex1));
        System.out.println();

        // Complex.mul()
        System.out.println("(" + complex1.toString() + ") * " + two.toString() + " = "
                + Complex.mul(complex1, two));
        System.out.println("(" + complex1.toString() + ") * " + p2 + " = " +
                Complex.mul(complex1, p2));
        System.out.println();

        // Complex.div()
        System.out.println("(" + complex1.toString() + ") / " + "(" + complex2.toString() + ") = "
                + Complex.div(complex1, complex2));
        System.out.println("(" + complex1.toString() + ") / " + p2 + " = " +
                Complex.div(complex1, p2));
        System.out.println(p2 + " / (" + complex1.toString() + ") = " +
                Complex.div(p2, complex1));
        System.out.println();
    }
}
