import java.util.*;

public class Main {

    public static String isArmstrong(int n) {
        // Write your code here
        int k = String.valueOf(n).length();
        int sum=0;
        int copy = n;
        while(n>0){
            sum=sum+(int)Math.pow(n%10,k);
            n/=10;
        }
        if(sum==copy)
            return "Armstrong";
        return "Not Armstrong";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isArmstrong(n));

        sc.close();
    }
}
