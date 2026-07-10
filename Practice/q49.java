import java.util.*;

public class Main {

    public static boolean isPerfect(int n) { // This is O(N/2) solution
        // Write your code here
        if(n<=1)
            return false;
        int sum=0;    
        for(int i=1;i<=n/2;i++)
            sum+=(n%i==0)?i:0;
        return sum==n;
    }

    public static boolean isPerfect(int n) { // O(sqrt N) solution (better for large constraints)
        if (n <= 1) {
            return false;
        }

        int sum = 1; // 1 is a proper divisor of every number > 1

        for (int i = 2; i * i <= n; i++) { 
            if (n % i == 0) {
                sum += i;
                if (i != n / i) 
                    sum += n / i;    
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPerfect(n) ? "YES" : "NO");

        sc.close();
    }
}
