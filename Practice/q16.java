import java.util.*;

public class Main {

    public static int digitSum(int n) { //O(1) solution
        // Write your code here
        if (n == 0)
            return 0;
        return 1 + (n - 1) % 9; 
    }
    
    public static int digitSum(int n) { //O(dxk) where d is no. of digits and k is no. of reductions required
    
        while (n >= 10) { // Outer loop runs for a fixed no. of times. It is a constant. So O(1).
            int sum = 0;
    
            while (n > 0) { // Basically d = (log 10 n) + 1. Hence O(log n) 
                sum += n % 10;
                n /= 10;
            }
    
            n = sum;
        }
    
        return n;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(digitSum(n));

        sc.close();
    }
}
