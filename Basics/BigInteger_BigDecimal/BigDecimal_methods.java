//Read more from Documentation: https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html


import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("19.99");
        BigDecimal quantity = new BigDecimal("3");

        BigDecimal total = price.multiply(quantity); // 19.99 * 3
        System.out.println("Total: " + total); // 59.97

        BigDecimal taxRate = new BigDecimal("0.0825");
        BigDecimal tax = total.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Tax: " + tax); // rounded to 2 decimal places

        BigDecimal grandTotal = total.add(tax);
        System.out.println("Grand Total: " + grandTotal); // 65.91
    }
}
