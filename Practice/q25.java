
import java.util.*;

public class Main {

    public static void rotateLeft(int[] arr, int k) { // TC O(N) and SC O(1) 
        //arr = {1,2,3,4,5} and k=2
        int n = arr.length; //5
        if (n == 0) {
            return;
        }
        k %= n; //2%5 = 2
        reverse(arr, 0, k - 1); //reverse(arr,0,1) i.e. 2,1,3,4,5
        reverse(arr, k, n - 1); //reverse(arr,2,4) i.e. 2,1,5,4,3
        reverse(arr, 0, n - 1); //reverse(arr,0,4) i.e. 3,4,5,1,2
        
        /*
        For right rotation:
        reverse(arr, 0, n - 1); //reverse(arr,0,4) i.e. 5,4,3,2,1
        reverse(arr, 0, k - 1); //reverse(arr,0,1) i.e. 4,5,3,2,1
        reverse(arr, k, n - 1); //reverse(arr,2,4) i.e. 4,5,1,2,3
        
        */
    }
    
    private static void reverse(int[] arr, int left, int right) { // In place reversal
    
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        rotateLeft(arr, k);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}
