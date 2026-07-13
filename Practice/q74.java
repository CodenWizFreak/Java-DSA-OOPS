import java.util.*;

public class Main {

    public static int calculateScore(int[][] stocks, int[] queries) {

        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        for(int[]stock : stocks)
            map.put(stock[0],stock[1]);
        int score = 0;
        for (int id : queries){
            Integer qty = map.get(id);
            if(qty==null)
                score-=6;
            else if(qty==0)
                score-=2;
            else if(qty==1)
                score+=2;
            else if(qty==2)
                score+=3;
        }
        return score;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] stocks = new int[n][2];

        for (int i = 0; i < n; i++) {
            stocks[i][0] = sc.nextInt();
            stocks[i][1] = sc.nextInt();
        }

        int q = sc.nextInt();

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }

        System.out.println(calculateScore(stocks, queries));

        sc.close();
    }
}
