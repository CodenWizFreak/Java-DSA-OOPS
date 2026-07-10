import java.util.*;

public class Main {

    public static int sumOfDigits(int n) {
        // Write your code here
        if(n<=0)
            return 0;
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumOfDigits(n));

        sc.close();
    }
}
