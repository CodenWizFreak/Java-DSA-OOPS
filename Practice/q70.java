import java.util.*;

public class Main {

    public static int nthTerm(int n) {
        if (n % 2 == 1) {
            // Odd position -> Series A
            return (n + 1) / 2;
        } else {
            // Even position -> Series B
            int term = n / 2;
            return term * term;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(nthTerm(n));

        sc.close();
    }
}
