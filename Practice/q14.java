import java.util.*;

public class Main {

    public static String decimalToBinary(int n) {
        // Write your code here
        if (n == 0) 
            return "0";
        StringBuilder bin = new StringBuilder();
        while (n > 0) {
            bin.insert(0, n % 2); // Inserts at the front, so no reversal needed!
            n /= 2;
        }
        return bin.toString();
    }

    public static String decimalToOctal(int n) {
        // Write your code here
        if(n==0)
            return "0";
        StringBuilder oct = new StringBuilder();
        while (n > 0) {
            oct.insert(0, n % 8); // Inserts at the front, so no reversal needed!
            n /= 8;
        }
        return oct.toString();
    }

    public static String decimalToHexadecimal(int n) {
        if(n==0)
            return "0";
        StringBuilder hex = new StringBuilder();
        String hexchar = "0123456789ABCDEF";
        while (n > 0) {
            hex.insert(0, hexchar.charAt(n%16)); 
            n /= 16;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("Binary: " + decimalToBinary(n));
        System.out.println("Octal: " + decimalToOctal(n));
        System.out.println("Hexadecimal: " + decimalToHexadecimal(n));

        sc.close();
    }
}
