import java.util.*;

public class Main {

    public static int closestMultiple(int x, int y) {
        int lower = (int) Math.floor((double) x / y) * y;
        int upper = lower + y;
    
        if (x - lower < upper - x)
            return lower;
        else
            return upper;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(closestMultiple(x, y));

        sc.close();
    }
}
