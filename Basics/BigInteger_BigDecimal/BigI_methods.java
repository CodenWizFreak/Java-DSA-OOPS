import java.math.BigInteger;

public class BigIntegerFunctions {
    public static void main(String[] args) {
        // Creating BigInteger instances
        BigInteger a = new BigInteger("12345678901234567890");
        BigInteger b = new BigInteger("98765432109876543210");

        // 1. Arithmetic operations
        System.out.println("Add:        " + a.add(b));           // a + b
        System.out.println("Subtract:   " + b.subtract(a));      // b - a
        System.out.println("Multiply:   " + a.multiply(b));      // a * b
        System.out.println("Divide:     " + b.divide(a));        // b / a
        System.out.println("Mod:        " + b.mod(a));           // b % a

        // 2. Comparisons
        System.out.println("a > b?      " + (a.compareTo(b) > 0));   // false
        System.out.println("a == b?     " + a.equals(b));            // false

        // 3. Math functions
        System.out.println("GCD:        " + a.gcd(b));           // greatest common divisor
        System.out.println("Power:      " + a.pow(2));           // a^2
        System.out.println("Abs:        " + a.negate().abs());   // absolute value

        // 4. Bit operations
        System.out.println("Bit count:  " + a.bitCount());       // count of 1s in binary
        System.out.println("Bit length: " + a.bitLength());      // length in bits
        System.out.println("Shift left: " + a.shiftLeft(2));     // a << 2
        System.out.println("Shift right:" + a.shiftRight(2));    // a >> 2

        // 5. Primality check
        System.out.println("Is prime?   " + a.isProbablePrime(10)); // probably prime?

        // 6. Max/Min
        System.out.println("Max:        " + a.max(b));
        System.out.println("Min:        " + a.min(b));
    }
}
