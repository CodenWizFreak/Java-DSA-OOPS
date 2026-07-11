import java.util.*;

public class Main {

    public static int fibonacci(int n) { //O(2^n) time and stack overflow chances
        // Write your code here
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);    
    }
    public static int fibonacci(int n) { //O(n) time and O(1) space
        // Write your code here
        if(n<=1)
            return 0;
        int a=0,b=1,s=0;
        for(int i=2;i<=n;i++)   
        {
            s=a+b;
            a=b;
            b=s;
        }
        return s;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonacci(n));

        sc.close();
    }
}
