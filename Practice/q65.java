import java.util.*;

public class Main {

    public static int nextNumber(int[] arr) {
        int n = arr.length + 1;
        return n * n + n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(nextNumber(arr));

        sc.close();
    }
}
