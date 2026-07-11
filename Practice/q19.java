import java.util.*;

public class Main {

    public static int findSmallest(int[] arr) {
        // Write your code here
        int min = arr[0];
        for(int i=0;i<arr.length;i++)
            if(arr[i]<min)
                min=arr[i];
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findSmallest(arr));

        sc.close();
    }
}
