import java.util.Objects;

public class Complex {
    // Real part of complex
    private double re;
    // Imagine part of complex
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // Return real part
    public double getRe() {
        return re;
    }

    // Return imagine part
    public double getIm() {
        return im;
    }

    // Addition of complex numbers
    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.re + c2.re, c1.im + c2.im);
    }

    // Addition of complex and scalar
    public static Complex add(Complex c, double d) {
        return new Complex(c.re + d, c.im);
    }

    // Negation of complex
    public static Complex neg(Complex c) {
        return new Complex(-c.re, -c.im);
    }

    // Substraction a complex from other complex
    public static Complex sub(Complex c1, Complex c2) {
        return add(c1, neg(c2));
    }

    // Substraction a scalar from complex
    public static Complex sub(Complex c, double d) {
        return new Complex(c.re - d, c.im);
    }

    // Substraction a complex from scalar
    public static Complex sub(double d, Complex c) {
        return new Complex(-c.re + d, -c.im);
    }

    // Multiply of complex numbers
    public static Complex mul(Complex c1, Complex c2) {
        return new Complex(c1.re * c2.re - c1.im * c2.im,
                c1.re * c2.im + c1.im * c2.re);
    }

    // Multiply of complex and scalar
    public static Complex mul(Complex c, double d) {
        return new Complex(c.re * d, c.im * d);
    }

    // Divide complex by complex
    public static Complex div(Complex c1, Complex c2) throws ArithmeticException {
        if (c2.re == 0 && c2.im == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return new Complex((c1.re * c2.re + c1.im * c2.im) / (c2.re * c2.re + c2.im * c2.im),
                (c1.im * c2.re - c1.re * c2.im) / (c2.re * c2.re + c2.im * c2.im));
    }

    // Divide complex by scalar
    public static Complex div(Complex c, double d) throws ArithmeticException {
        if (d == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return new Complex(c.re / d, c.im / d);
    }

    // Divide scalar by complex
    public static Complex div(double d, Complex c) throws ArithmeticException {
        if (c.re == 0 && c.im == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return div(new Complex(d, 0.0), c);
    }

    // Return absolute value of complex
    public static double abs(Complex c) {
        double x = c.re;
        double y = c.im;
        double s = Math.max(Math.abs(x), Math.abs(y));
        if (s == 0)
            return s;
        x /= s;
        y /= s;
        return s * Math.sqrt(x * x + y * y);
    }

    // Return argument of complex
    public static double arg(Complex c) {
        return Math.atan2(c.im, c.re);
    }

    // Return complex number with arguments of this function an absolute and an
    // angle phi
    public static Complex getPolarComplex(double abs, double phi) {
        return new Complex(abs * Math.cos(phi), abs * Math.sin(phi));
    }

    // Return conjugate of the complex
    public static Complex conj(Complex c) {
        return new Complex(c.re, -c.im);
    }

    // Return cosine of complex
    public static Complex cos(Complex c) {
        double x = c.re;
        double y = c.im;
        return new Complex(Math.cos(x) * Math.cosh(y), -Math.sin(x) * Math.sinh(y));
    }

    // Return hyperbolic cosine of complex
    public static Complex cosh(Complex c) {
        double x = c.re;
        double y = c.im;
        return new Complex(Math.cosh(x) * Math.cos(y), Math.sinh(x) * Math.sin(y));
    }

    // Return exponential of complex
    public static Complex exp(Complex c) {
        return getPolarComplex(Math.exp(c.re), c.im);
    }

    // Return natural logarithm of complex
    public static Complex log(Complex c) {
        return new Complex(Math.log(abs(c)), arg(c));
    }

    // Return 10 logarithm of complex
    public static Complex log10(Complex c) {
        return div(log(c), Math.log(10.0));
    }

    // Return sine of complex
    public static Complex sin(Complex c) {
        double x = c.re;
        double y = c.im;
        return new Complex(Math.sin(x) * Math.cosh(y), Math.cos(x) * Math.sinh(y));
    }

    // Return hyperbolic sine of complex
    public static Complex sinh(Complex c) {
        double x = c.re;
        double y = c.im;
        return new Complex(Math.sinh(x) * Math.cos(y), Math.cosh(x) * Math.sin(y));
    }

    // Return square root of complex
    public static Complex sqrt(Complex c) {
        return pow(c, 0.5);
    }

    // Return tangent of complex
    public static Complex tan(Complex c) {
        return div(sin(c), cos(c));
    }

    // Return hyperbolic tangent of complex
    public static Complex tanh(Complex c) {
        return div(sinh(c), cosh(c));
    }

    // Return c to the p power.
    public static Complex pow(Complex c, double p) {
        if (c.im == 0.0 && c.re > 0.0)
            return new Complex(Math.pow(c.re, p), 0.0);
        Complex newC = log(c);
        return getPolarComplex(Math.exp(p * newC.re), p * newC.im);
    }

    // Return c1 to the c2 power.
    public static Complex pow(Complex c1, Complex c2) {
        return c1.re == 0.0 && c1.im == 0.0 ? new Complex(0.0, 0.0) : exp(mul(c2, log(c1)));
    }

    // Return p to the c power.
    public static Complex pow(double p, Complex c) {
        return p > 0.0 ? getPolarComplex(Math.pow(p, c.re), c.im * Math.log(p))
                : pow(new Complex(p, 0.0), c);
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Objects.isNull(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Complex other = (Complex) obj;
        if (this.re != other.re) {
            return false;
        }
        if (this.im != other.im) {
            return false;
        }
        return true;
    }

    // Overriding hashCode()
    @Override
    public int hashCode() {
        int hash = 37;
        hash = 37 * hash + Objects.hashCode(this.re);
        hash = 37 * hash + Objects.hashCode(this.im);
        return hash;
    }

    // String form of the complex with rounding
    @Override
    public String toString() {
        double reRound = Math.round(re * 1000.0) / 1000.0;
        double imRound = Math.round(im * 1000.0) / 1000.0;

        if (reRound == 0 && imRound == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(reRound == 0 ? "" : reRound);
        if (imRound == 0) {
            return sb.toString();
        }
        if (imRound < 0) {
            sb.append(imRound);
        } else {
            sb.append(reRound == 0 ? "" : "+");
            sb.append(imRound);
        }
        sb.append("i");
        return sb.toString();
    }

}