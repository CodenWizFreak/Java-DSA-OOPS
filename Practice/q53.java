import java.util.*;

public class Main {

    public static int timeToCrossBridge(int speed) {
        double speedInMps = speed * (5.0 / 18.0);
        double time = 800 / speedInMps;
    
        return (int) time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int speed = sc.nextInt();

        System.out.println(timeToCrossBridge(speed));

        sc.close();
    }
}
