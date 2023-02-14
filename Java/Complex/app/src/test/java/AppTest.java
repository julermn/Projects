import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private final Complex complex = new Complex(1, 2);
    private final Complex complexNew = new Complex(1, 2);
    private final Complex complex2 = new Complex(2, 3);
    private final Complex complexZeroRe1 = new Complex(0, 1);
    private final Complex complexZeroRe2 = new Complex(0, -1);
    private final Complex complexZeroIm = new Complex(1, 0);
    private final Complex complexZeroAll = new Complex(0, 0);
    private final double two = 2.0;
    private final double zero = 0.0;

    @Test
    void complexToString() {
        assertEquals("1.0+2.0i", complex.toString());
        assertEquals("1.0i", complexZeroRe1.toString());
        assertEquals("-1.0i", complexZeroRe2.toString());
        assertEquals("1.0", complexZeroIm.toString());
        assertEquals("0", complexZeroAll.toString());
    }

    @Test
    void complexEquals() {
        assertTrue(complex.equals(complexNew));
    }

    @Test
    void complexAdd() {
        assertEquals(new Complex(2, 4), Complex.add(complex, complex));
        assertEquals(new Complex(1, 3), Complex.add(complex, complexZeroRe1));
        assertEquals(new Complex(1, 1), Complex.add(complex, complexZeroRe2));
        assertEquals(new Complex(1, 2), Complex.add(complex, complexZeroAll));

        assertEquals(new Complex(3, 2), Complex.add(complex, two));
        assertEquals(new Complex(-1, 2), Complex.add(complex, -two));
    }

    @Test
    void complexSub() {
        assertEquals(new Complex(0, 0), Complex.sub(complex, complex));
        assertEquals(new Complex(1, 2), Complex.sub(complex, complexZeroAll));
        assertEquals(new Complex(1, 3), Complex.sub(complex, complexZeroRe2));

        assertEquals(new Complex(-1, 2), Complex.sub(complex, two));
        assertEquals(new Complex(1, -2), Complex.sub(two, complex));
    }

    @Test
    void complexMul() {
        assertEquals(new Complex(-4, 7), Complex.mul(complex, complex2));
        assertEquals(new Complex(2, 4), Complex.mul(complex, two));
        assertEquals(new Complex(0, 0), Complex.mul(complex, zero));
    }

    @Test
    void complexDiv() {
        assertEquals(new Complex(0.615, 0.077).toString(), Complex.div(complex, complex2).toString());
        Exception e = assertThrows(ArithmeticException.class,
                () -> Complex.div(complex, complexZeroAll));
        assertEquals("/ by zero", e.getMessage());

        assertEquals(new Complex(0.5, 1), Complex.div(complex, two));
        e = assertThrows(ArithmeticException.class,
                () -> Complex.div(complex, zero));
        assertEquals("/ by zero", e.getMessage());

        assertEquals(new Complex(0.4, -0.8), Complex.div(two, complex));
        e = assertThrows(ArithmeticException.class,
                () -> Complex.div(two, complexZeroAll));
        assertEquals("/ by zero", e.getMessage());
    }

    @Test
    void complexPolar() {
        assertAll("abs and arg", () -> {
            double abs = Complex.abs(complex);
            double arg = Complex.arg(complex);
            assertEquals(2.23606797749979, abs);
            assertEquals(1.1071487177940904, arg);
            assertAll("polar", () -> {
                assertEquals(complex.toString(), Complex.getPolarComplex(abs, arg).toString());
            });
        });
    }

    @Test
    void complexNeg() {
        assertEquals(new Complex(-1, -2), Complex.neg(complex));
    }

    @Test
    void complexGetters() {
        assertAll("properties",
                () -> assertEquals(1, complex.getRe()),
                () -> assertEquals(2, complex.getIm()));
    }

    @Test
    void complexConj() {
        assertEquals(new Complex(1, -2), Complex.conj(complex));
    }

    @Test
    void complexTrigonometric() {
        assertEquals(new Complex(2.033, -3.052).toString(), Complex.cos(complex).toString());
        assertEquals(new Complex(3.166, 1.96).toString(), Complex.sin(complex).toString());
        assertEquals(new Complex(-0.642, 1.069).toString(), Complex.cosh(complex).toString());
        assertEquals(new Complex(-0.489, 1.403).toString(), Complex.sinh(complex).toString());
        assertEquals(new Complex(0.034, 1.015).toString(), Complex.tan(complex).toString());
        assertEquals(new Complex(1.167, -0.243).toString(), Complex.tanh(complex).toString());

        assertEquals(new Complex(-1.131, 2.472).toString(), Complex.exp(complex).toString());
        assertEquals(new Complex(0.805, 1.107).toString(), Complex.log(complex).toString());
        assertEquals(new Complex(0.349, 0.481).toString(), Complex.log10(complex).toString());
    }

    @Test
    void complexSQRT() {
        assertEquals(new Complex(1.272, 0.786).toString(),
                Complex.sqrt(complex).toString());
    }

    @Test
    void complexPow() {
        assertEquals(new Complex(-0.015, -0.18).toString(), Complex.pow(complex, complex2).toString());
        assertEquals(new Complex(-3.0, 4.0).toString(), Complex.pow(complex, two).toString());
        assertEquals(new Complex(0.367, 1.966).toString(), Complex.pow(two, complex).toString());
    }
}
