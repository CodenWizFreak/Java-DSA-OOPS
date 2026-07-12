import java.util.*;

public class Main {

    public static int unitsProduced(int x, int d) {
        return (x * d) / 24;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(unitsProduced(x, d));

        sc.close();
    }
}
