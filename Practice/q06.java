import java.util.*;

public class Main {

    public static int findLostCoin(int[] coins) {
        // Write your code here.
        int res = 0;
        for(int coin: coins)
            res^=coin;
        return res;    
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(findLostCoin(coins));

        sc.close();
    }
}
