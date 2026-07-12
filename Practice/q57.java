import java.util.*;

public class Main {

    public static double calculateSpeed(int time) {
        double speedInMps = 1000.0 / time;
        return speedInMps * 18 / 5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time = sc.nextInt();

        System.out.println(calculateSpeed(time));

        sc.close();
    }
}
