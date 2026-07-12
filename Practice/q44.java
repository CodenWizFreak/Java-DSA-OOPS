import java.util.*;

public class Main {

    public static void findVehicles(int v, int w) {
        // Write your code here
        if(v<=0||w<=0||w%2!=0){
            System.out.println("Invalid");
            return;
        }
        int fw = (w-2*v)/2;
        int tw = v - fw;
        if (tw < 0 || fw < 0) {
            System.out.println("INVALID INPUT");
            return;
        }
        System.out.println("TW = " + tw);
        System.out.println("FW = " + fw);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int w = sc.nextInt();

        findVehicles(v, w);

        sc.close();
    }
}
