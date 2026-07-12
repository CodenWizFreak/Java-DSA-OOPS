import java.util.*;

public class Main {

    public static long nthTerm(String type, int a, int value, int n) {
        if (type.equals("AP")) {
            return a + (long) (n - 1) * value;
        } else {
            return (long) (a * Math.pow(value, n - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next();
        int a = sc.nextInt();
        int value = sc.nextInt(); // D for AP, R for GP
        int n = sc.nextInt();

        System.out.println(nthTerm(type, a, value, n));

        sc.close();
    }
}
