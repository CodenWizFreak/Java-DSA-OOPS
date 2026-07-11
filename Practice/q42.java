import java.util.*;

public class Main {

    public static int fibonacciSum(int n) {
        // Write your code here
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int a=0,b=1,s=0,sum=2;
        for(int i=3;i<=n;i++)   
        {
            s=a+b;
            sum+=s;
            a=b;
            b=s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonacciSum(n));

        sc.close();
    }
}
