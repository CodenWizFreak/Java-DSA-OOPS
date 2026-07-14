
import java.util.*;

public class Main {

    public static int findMissingNumber(int[] arr) { //convert to long for integer overflow
        // Write your code here.
        int org_sum = Arrays.stream(arr).sum();
        int n = arr.length;
        int act_sum = (n+1)*(n+2)/2;
        return Math.abs(org_sum-act_sum);
    }
    public static int findMissingNumberSingleLoop(int[] arr) {
        int n = arr.length;
        int xor = 0;
        // Loop goes from 0 to n-1 (indexing the array)
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];    // XOR the actual array elements
            xor ^= (i + 1);   // XOR the numbers from 1 to N
        }
        // Don't forget to XOR the final missing range value (N+1)
        xor ^= (n + 1);
        return xor;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMissingNumber(arr));

        sc.close();
    }
}
