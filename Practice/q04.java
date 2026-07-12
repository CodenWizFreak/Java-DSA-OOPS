import java.util.*;

public class Main {

    public static long totalHandshakes(int n) {
        // Write your code here
        return (long)n*(n-1)/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(totalHandshakes(n));
        }

        sc.close();
    }
}
