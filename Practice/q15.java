import java.util.*;

public class Main {

    public static int gcd(int a, int b) { //O(log(min(a, b)))
        // Write your code here 
        if (b == 0)
            return a;
        return gcd(b,a%b);
    }
    
    public static int gcd(int a, int b) { 
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) { //O(log(min(a, b))) (since it calls gcd)
        // Write your code here
        return (a*b) / gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        int lcm = lcm(a, b);

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        sc.close();
    }
}
